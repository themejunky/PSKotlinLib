package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import kotlin.properties.Delegates

open class CustomSpinnerBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), AdapterView.OnItemSelectedListener {

    var mIsSpinnerValid by Delegates.observable<Boolean?>(true) { _, _, new ->
        if (new == false && mStartValidating) errorStyle() else defaultStyle()
    }
    var mStartValidating : Boolean = false
    var mSpinnerSelectedId : Int = 0
    var mSpinnerSelectedValue : String = ""

    fun errorStyle() {
        nSpinnerTitle.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nSpinnerMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_red))
        nSpinnerError.visibility= View.VISIBLE
        nSpinner.background = ContextCompat.getDrawable(context, R.drawable.spinner_error)
    }

    private fun defaultStyle() {
        nSpinnerTitle.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
        nSpinnerMandatory.setTextColor(ContextCompat.getColor(context,R.color.lib_base_black))
        nSpinnerError.visibility= View.GONE
        nSpinner.background = ContextCompat.getDrawable(context, R.drawable.spinner_default)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, nPositionSelected: Int, p3: Long) {
        mIsSpinnerValid = nPositionSelected != 0

        mSpinnerSelectedId = nPositionSelected
        mSpinnerSelectedValue = (nSpinner.adapter as CustomSpinnerAdapter).getValues().get(nPositionSelected).value.toString()

        mStartValidating = true
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented")
    }
}
