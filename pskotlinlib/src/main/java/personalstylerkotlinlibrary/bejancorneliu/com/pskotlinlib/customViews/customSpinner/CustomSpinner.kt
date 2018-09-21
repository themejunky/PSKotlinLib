package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Spinner
import kotlinx.android.synthetic.main.lib_custom_button.view.*
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class CustomSpinner(context: Context, attrs: AttributeSet) : CustomSpinnerBase(context, attrs) {

    interface CustomSpinnerInterface {
        fun onCustomSpinnerChange(view: String)
    }

    fun setListener(nListener: CustomSpinner.CustomSpinnerInterface) {
        mListener = nListener
    }

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
            } else {
                nSpinnerTitle.visibility = View.GONE
            }

            //set Error & Mandatory
            if (it.hasValue(R.styleable.CustomSpinner_cs_default_error_text)) {
                nSpinnerMandatory.visibility = View.VISIBLE
                nSpinnerError.text = it.getString(R.styleable.CustomSpinner_cs_default_error_text)
                mDefaultError = it.getString(R.styleable.CustomSpinner_cs_default_error_text)
            }

            // set tag
            if (it.hasValue(R.styleable.CustomSpinner_cs_tag)) {
                nContainer.tag = it.getString(R.styleable.CustomSpinner_cs_tag)
            }
        }
    }

    fun setTitle(nTitle : String) {
        nSpinnerTitle.text = nTitle
    }

    fun getSpinner() : Spinner {
        return nSpinner
    }

    fun getSpinnerSelectedId(): String {
        return mSpinnerSelectedId
    }

    fun getSpinnerSelectedValue() : String {
        return mSpinnerSelectedValue
    }

    fun setSpinnerPositionByValue(nValue : String) {
        var nPosition = 0

        for (item in (nSpinner.adapter as CustomSpinnerAdapter).getValues()) {
            if (item.value.equals(nValue)) {
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

    fun setSpinner(nValues: List<Item>, nAlignment: String, nBold: Boolean = false) {
        nSpinner.adapter = CustomSpinnerAdapter(context, nValues, nAlignment, nBold)
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