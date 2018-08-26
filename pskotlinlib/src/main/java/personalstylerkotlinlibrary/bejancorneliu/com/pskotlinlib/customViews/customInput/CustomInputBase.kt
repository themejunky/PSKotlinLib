package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import kotlin.properties.Delegates

open class CustomInputBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs) {

    var mIsInputValid by Delegates.observable<Boolean?>(false) { _, _, new ->
       if (new == false && mStartValidating) errorStyle() else defaultStyle()
    }

    var mStartValidating : Boolean = false

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
        mStartValidating = true

        when(nInputType) {
            "1" -> validationNormalText()
            "12" -> validationTinyText()
            "2" -> validationEmail()
            "3" -> validationPhone()
            "4" -> validationPassword()
            "5" -> validationNumber()
        }
    }

    private fun validationNormalText() {
        mIsInputValid = nInput.text.toString().length>=3
    }

    private fun validationTinyText() {
        mIsInputValid = nInput.text.toString().isNotEmpty()
    }

    private fun validationEmail() {
        mIsInputValid = isEmailValid(nInput.text.toString())
    }

    private fun validationPhone() {
        mIsInputValid = isPhoneValid(nInput.text.toString())
    }

    private fun validationPassword() {
        mIsInputValid = nInput.text.toString().length > 5
    }

    private fun validationNumber() {
        mIsInputValid = nInput.text.toString().isNotEmpty()
    }



    /**
     * Local Library :)
     */
    private fun isEmailValid(nEmail: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(nEmail)
        return matcher.matches()
    }

    private fun isPhoneValid(nPhone: String): Boolean {
        return nPhone.length == 10 // in 4..10
    }
}