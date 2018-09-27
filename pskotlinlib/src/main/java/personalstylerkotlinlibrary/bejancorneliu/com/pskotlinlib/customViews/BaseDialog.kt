package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews

import android.app.Dialog
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customTextView.CustomTextView

open class BaseDialog(nContext : Context) : View.OnClickListener, CustomTextView.CustomTextViewInterface, CustomInput.CustomInputInterface {
    override fun onCustomInputChange(view : String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCustomTextViewClick(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    protected lateinit var mContainer : ConstraintLayout
    open var mContext = nContext
    lateinit var mBuilder: AlertDialog.Builder
    lateinit var mDialog: AlertDialog
    private var mIsPopUpReady = false

    protected fun createView(nCustomLayout: Int) {
        mContainer = LayoutInflater.from(mContext).inflate(nCustomLayout,null) as ConstraintLayout
        create()
    }

    private fun create() {
        mBuilder = AlertDialog.Builder(mContext).setView(mContainer)
        mDialog = mBuilder.create()
        mIsPopUpReady = true
    }

    fun showDialog() {
        if (mIsPopUpReady && !mDialog.isShowing)  mDialog.show()
    }

    fun getDialog() : Dialog {
        return mDialog
    }

    fun dismissDialog() {
        if (mIsPopUpReady && mDialog.isShowing)
            mDialog.dismiss()
    }

    override fun onClick(view: View) {
    }

}