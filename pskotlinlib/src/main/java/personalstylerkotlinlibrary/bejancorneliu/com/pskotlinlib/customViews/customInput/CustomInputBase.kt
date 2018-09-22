package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.isValid3Lenght
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.isValidEmail
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.isValidPassword
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.isValidPhone
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

open class CustomInputBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs) {

    lateinit var mListener: CustomInput.CustomInputInterface
    var mDefaultError : String = ""


    var mIsInputValid by Delegates.observable(false) { _, _, new ->
        if (new) defaultStyle()
    }

    fun errorStyle() {
        nInputTitle.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nInputMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nInputError.visibility= View.VISIBLE
        nInput.background = ContextCompat.getDrawable(context, R.drawable.lib_edit_text_error)
    }

    private fun defaultStyle() {
        nInputTitle.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
        nInputMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_black))
        nInputError.visibility= View.GONE
        nInput.background = ContextCompat.getDrawable(context, R.drawable.lib_edit_text_selector)
    }

    protected fun validationFieldObserver(nInputType: String) {
        RxTextView.afterTextChangeEvents(nInput).skip(2).debounce(10, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe { _ -> validationFieldCore(nInputType)}
    }

    private fun validationFieldCore(nInputType: String) {
        nInputError.text = mDefaultError
        when(nInputType) {
            "1" -> validationNormalText()
            "12" -> validationTinyText()
            "2" -> validationEmail()
            "3" -> validationPhone()
            "4" -> validationPassword()
            "5" -> validationNumber()
        }
        try {
            mListener.onCustomInputChange(nContainer.tag.toString())
        } catch (e : Exception) {
            Log.d("CUSTOM_INPUT",""+e.message)
        }
    }

    private fun validationNormalText() {
        mIsInputValid = nInput.text.toString().isNotEmpty()
    }

    private fun validationTinyText() {
        mIsInputValid = nInput.text.toString().isValid3Lenght()
    }

    private fun validationEmail() {
        mIsInputValid = nInput.text.toString().isValidEmail()
    }

    private fun validationPhone() {
        mIsInputValid = nInput.text.toString().isValidPhone()
    }

    private fun validationPassword() {
        mIsInputValid = nInput.text.toString().isValidPassword()
    }

    private fun validationNumber() {
        mIsInputValid = nInput.text.toString().isNotEmpty()
    }
}