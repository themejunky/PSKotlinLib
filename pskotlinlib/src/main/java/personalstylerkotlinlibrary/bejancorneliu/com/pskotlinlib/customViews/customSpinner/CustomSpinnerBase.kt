package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import kotlin.properties.Delegates

open class CustomSpinnerBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), AdapterView.OnItemSelectedListener {
    lateinit var mListener : CustomSpinner.Custom_Spinner_Interface
    var mIsSpinnerValid by Delegates.observable<Boolean?>(false) { _, _, new ->
        if (new == false && mStartValidating) errorStyle() else defaultStyle()
    }
    var mDefaultError : String = ""
    var mStartValidating : Boolean = false
    var mSpinnerSelectedId : Int = 0
    var mSpinnerSelectedValue : String = ""

    fun errorStyle() {
        nSpinnerTitle.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nSpinnerMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nSpinnerError.visibility= View.VISIBLE
        nSpinner.background = ContextCompat.getDrawable(context, R.drawable.lib_spinner_error)
    }

    private fun defaultStyle() {
        nSpinnerTitle.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
        nSpinnerMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_black))
        nSpinnerError.visibility= View.GONE
        nSpinner.background = ContextCompat.getDrawable(context, R.drawable.lib_spinner_default)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, nPositionSelected: Int, p3: Long) {
        //mIsSpinnerValid = nPositionSelected != 0

        Log.d("spinner","changed 1")

        nSpinnerError.text = mDefaultError
        mSpinnerSelectedId = nPositionSelected


        Log.d("spinner","changed 2")
        //TODO : de facut o singura tye list : ITEM

        if (nSpinner.adapter is CustomSpinnerAdapter) {
            mSpinnerSelectedValue = (nSpinner.adapter as CustomSpinnerAdapter).getValues()[nPositionSelected].name
        } else  if (nSpinner.adapter is CustomSpinnerAdapterItem) {
            mSpinnerSelectedValue = (nSpinner.adapter as CustomSpinnerAdapterItem).getValues()[nPositionSelected].value
        }
        Log.d("spinner","changed 3")
        mStartValidating = true
        try {
            Log.d("spinner","changed 4 : "+mListener)
            mListener.onCustomSpinnerChange()
            Log.d("spinner","changed 41 : "+mListener)
        } catch (e : Exception) {
            Log.d("spinner","changed 5")
            Log.d("CUSTOM_SPINNER",""+e.message)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        try {
            mListener.onCustomSpinnerChange()
        } catch (e : Exception) {
            Log.d("CUSTOM_SPINNER",""+e.message)
        }
    }
}
