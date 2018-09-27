package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.lib_dialog_choose_photo_option.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseDialog

class ManageImage(mContext: Context, nPosition : Int, nListener : ChooseManageImage )  : BaseDialog(mContext) {

    var mListener: ChooseManageImage = nListener
    var mPosition = nPosition

    interface ChooseManageImage {
        fun onDeleteImageFromGallery()
        fun onEditImageFromGallery()
    }

    fun refresh() {
        createView(R.layout.lib_dialog_choose_photo_option)

        mContainer.mDelete.setOnClickListener(this)
        mContainer.mEdit.setOnClickListener(this)

        showDialog()
    }

    override fun onClick(view: View) {
        when (view.tag) {
           mContext.getString(R.string.lib_delete) -> mListener.onDeleteImageFromGallery()
           mContext.getString(R.string.lib_edit) -> mListener.onEditImageFromGallery()
        }
        mDialog.dismiss()
    }

    fun getPosition() : Int {
        return mPosition
    }
}