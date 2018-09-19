package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Spinner
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases.Cities
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools.use

class CustomSpinner(context: Context, attrs: AttributeSet) : CustomSpinnerBase(context, attrs) {

    interface Custom_Spinner_Interface {
        fun onCustomSpinnerChange()
    }
    fun setListener(nListener : CustomSpinner.Custom_Spinner_Interface) {
        mListener = nListener
    }
/**/
    init {

        inflate(context, R.layout.lib_custom_spinner, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomSpinner).use {

        nSpinnerTitle.typeface = typefaceBold
        nSpinnerMandatory.typeface = typefaceBold
        nSpinnerError.typeface = typefaceBold
        nSpinner.onItemSelectedListener=this

            //set Title
            if (it.hasValue(R.styleable.CustomSpinner_cs_title_text)) {
                nSpinnerTitle.text = it.getString(R.styleable.CustomSpinner_cs_title_text)
            }

            //set Error & Mandatory
            if (it.hasValue(R.styleable.CustomSpinner_cs_default_error_text)) {
                nSpinnerMandatory.visibility = View.VISIBLE
                nSpinnerError.text = it.getString(R.styleable.CustomSpinner_cs_default_error_text)
                mDefaultError = it.getString(R.styleable.CustomSpinner_cs_default_error_text)
            }
        }
    }

    fun getSpinner() : Spinner {
        return nSpinner
    }

    fun getSpinnerSelectedId() : Int {
        return mSpinnerSelectedId
    }

    fun getSpinnerSelectedValue() : String {
        return mSpinnerSelectedValue
    }

    fun setSpinnerPositionByValue(nValue : String) {
        var nPosition = 0

        for (item in (nSpinner.adapter as CustomSpinnerAdapter).getValues()) {
            if (item.name.equals(nValue)) {
                nSpinner.setSelection(nPosition)
            } else {
                nPosition++
            }
        }
    }

    fun setSpinnerPositionById(nValue : String) {
        var nPosition = 0

        for (item in (nSpinner.adapter as CustomSpinnerAdapter).getValues()) {
            if (item.id==nValue) {
                nSpinner.setSelection(nPosition)
            } else {
                nPosition++
            }
        }
    }

    fun setSpinnerPositionByPosition(nPosition: Int) {
        nSpinner.setSelection(nPosition)
    }

    fun setSpinner(nValues : List<Cities>, nAlignment: String, nBold: Boolean = false) {
        nSpinner.adapter = CustomSpinnerAdapter(context,nValues, nAlignment,nBold)
    }

    fun setErrorMessage(nErrorMessage: String) {
        nSpinnerError.text=nErrorMessage
        mIsSpinnerValid=false
        errorStyle()
    }

    fun triggerError() {
        mIsSpinnerValid=false
        mStartValidating=true
    }

    fun triggerDefault() {
        mIsSpinnerValid=true
    }
}