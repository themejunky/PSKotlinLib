package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput

import android.content.Context
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomInput(context: Context, attrs: AttributeSet) : CustomInputBase(context, attrs){

    interface CustomInputInterface {
        fun onCustomInputChange(view: String)
    }

    fun setListener(nListener: CustomInputInterface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_input, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomInput).use {

        nInput.setPadding((10 * mDensity + 0.5f).toInt(), (10*mDensity + 0.5f).toInt()+(0.15f*14).toInt(),(10 * mDensity + 0.5f).toInt(), (10*mDensity + 0.5f).toInt())

        nInput.typeface = typefaceRegular
        nInputTitle.typeface = typefaceBold
        nInputMandatory.typeface = typefaceBold
        nInputError.typeface = typefaceBold

        //set Title
        if (it.hasValue(R.styleable.CustomInput_ci_title_text)) {
            nInputTitle.text = it.getString(R.styleable.CustomInput_ci_title_text)
        } else {
            nInputTitle.visibility = View.GONE
        }

        //set Input Text
        if (it.hasValue(R.styleable.CustomInput_textulmeu)) {
            nInput.setText(it.getString(R.styleable.CustomInput_textulmeu))
        }

        //set Error & Mandatory
        if (it.hasValue(R.styleable.CustomInput_ci_default_error_text)) {
            nInputMandatory.visibility = View.VISIBLE
            nInputError.text = it.getString(R.styleable.CustomInput_ci_default_error_text)
            mDefaultError = it.getString(R.styleable.CustomInput_ci_default_error_text)
        }

        //set Hint
        if (it.hasValue(R.styleable.CustomInput_ci_hint_text)) {
            nInput.hint = it.getString(R.styleable.CustomInput_ci_hint_text)
        }

        //set IME option (done or next)
        if (it.hasValue(R.styleable.CustomInput_ci_imei_option)) {
            when (it.getString(R.styleable.CustomInput_ci_imei_option)) {
                "1" -> nInput.imeOptions = EditorInfo.IME_ACTION_DONE
                "2" -> nInput.imeOptions = EditorInfo.IME_ACTION_NEXT
            }
        } else {
            nInput.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        //set keyboard type
        if (it.hasValue(R.styleable.CustomInput_ci_keyboard)) {
            val mInputType = it.getString(R.styleable.CustomInput_ci_keyboard)
            validationFieldObserver(mInputType)
            when (it.getString(R.styleable.CustomInput_ci_keyboard)) {
                "1" ->  nInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
                "12" -> nInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
                "2" ->  nInput.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                "3" ->  nInput.inputType = InputType.TYPE_CLASS_PHONE
                "4" ->  nInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                "5" ->  nInput.inputType = InputType.TYPE_CLASS_NUMBER
            }
        }
            //set number of line
            if (it.hasValue(R.styleable.CustomInput_ci_lines)) {
                with(nInput) {
                    minLines = it.getInteger(R.styleable.CustomInput_ci_lines, 1)
                    maxLines = it.getInteger(R.styleable.CustomInput_ci_lines, 1)
                    gravity = android.view.Gravity.TOP and android.view.Gravity.START
                    imeOptions = android.view.inputmethod.EditorInfo.IME_FLAG_NO_ENTER_ACTION
                    isVerticalScrollBarEnabled = true
                }
            } else {
                //nInput.setSingleLine()
            }

            // set tag
            if (it.hasValue(R.styleable.CustomInput_ci_tag)) {
                nContainer.tag = it.getString(R.styleable.CustomInput_ci_tag)
            }
        }
    }

    fun setErrorMessage(nErrorMessage: String) {
        nInputError.text=nErrorMessage
        mIsInputValid=false
        errorStyle()
    }

    fun triggerError() {
        mIsInputValid=false
        errorStyle()
    }

    fun triggerDefault() {
        mIsInputValid=true
    }

    fun getInput() : EditText {
        return nInput
    }

    fun getInputString() : String {
        return nInput.text.toString()
    }

    fun setInputText(nText : String) {
        nInput.setText(nText)
    }

    fun isValidWithoutErrorTriggering() : Boolean {
        return mIsInputValid
    }

    fun isValid() : Boolean {
        if (!mIsInputValid) {
            triggerError()
        }
        return mIsInputValid
    }
}