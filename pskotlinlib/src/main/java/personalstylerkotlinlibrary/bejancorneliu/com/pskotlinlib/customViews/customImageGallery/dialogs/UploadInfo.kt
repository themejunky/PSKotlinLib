package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs

import android.content.Context
import kotlinx.android.synthetic.main.lib_dialog_upload_update.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseDialog

class UploadInfo(mContext: Context) : BaseDialog(mContext) {

    fun refresh() {
        createView(R.layout.lib_dialog_upload_update)
        mDialog.setCancelable(false)
        showDialog()
    }

    fun setInfo(nString: String) {
        mContainer.mMessage.text = nString
    }

    fun dismiss() {
        mDialog.dismiss()
    }
}