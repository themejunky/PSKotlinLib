package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import kotlin.properties.Delegates

open class CustomSpinnerBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), AdapterView.OnItemSelectedListener {
    lateinit var mListener: CustomSpinner.CustomSpinnerInterface
    var mIsSpinnerValid by Delegates.observable(false) { _, _, new ->
        if (new) defaultStyle()
    }
    var mDefaultError : String = ""
    var mStartValidating : Boolean = false
    var mSpinnerSelectedId: String = ""
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

        mSpinnerSelectedId = (nSpinner.adapter as CustomSpinnerAdapter).getValues()[nPositionSelected].id
        mSpinnerSelectedValue = (nSpinner.adapter as CustomSpinnerAdapter).getValues()[nPositionSelected].value

        try {
            Log.d("custom_spiner", "tag" + nContainer.tag.toString())
            mListener.onCustomSpinnerChange(nContainer.tag.toString())
        } catch (e: Exception) {
            Log.d("custom_spiner", "" + e.message)
        }

//        mIsSpinnerValid = nPositionSelected != 0
//        nSpinnerError.text = mDefaultError

//        mStartValidating = true
//        try {
//            mListener.onCustomSpinnerChange()
//        } catch (e : Exception) {
//            Log.d("CUSTOM_SPINNER",""+e.message)
//        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.d("custom_spiner", "LISTENERU!")
    }
}
