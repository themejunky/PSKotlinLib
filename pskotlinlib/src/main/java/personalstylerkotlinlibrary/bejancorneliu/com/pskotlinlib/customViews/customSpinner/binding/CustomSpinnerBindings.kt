package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

@BindingAdapter(value = ["cs_select_option_by_id"])
fun setSavedSelectionById(mCustomSpinner: CustomSpinner, mId: String?) {
    if (mId!="" && mCustomSpinner.getSpinner().adapter!=null) {

        var position = 0

        loop@ for (item in (mCustomSpinner.getSpinner().adapter as CustomSpinnerAdapter).getValues()) {
            if (item.id==mId) {
                mCustomSpinner.getSpinner().setSelection(position)
                break@loop
            } else {
                position++
            }
        }
    }
}

@BindingAdapter(value = ["cs_select_option_by_value"])
fun setSavedSelectionByValue(mCustomSpinner: CustomSpinner, mValue : String?) {
    if (mValue!="" && mCustomSpinner.getSpinner().adapter!=null) {

        var position = 0

        loop@ for (item in (mCustomSpinner.getSpinner().adapter as CustomSpinnerAdapter).getValues()) {
            if (item.value==mValue) {
                mCustomSpinner.getSpinner().setSelection(position)
                break@loop
            } else {
                position++
            }
        }
    }
}

@BindingAdapter(value = ["cs_ws_error_text"])
fun setcs_ws_error_text(nCustomSpinner: CustomSpinner?, nValue: String?) {
    if (nCustomSpinner != null && nValue != null) {
        with(nCustomSpinner) {
            nSpinnerError.text = nValue
            nSpinnerMandatory.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("cs_set_entries")
fun setcs_set_entries(nCustomSpinner: CustomSpinner?, nValues: List<Item>?) {
    if (nCustomSpinner != null && nValues != null) {
        nCustomSpinner.getSpinner().adapter = CustomSpinnerAdapter(nCustomSpinner.context, nValues, "left", false)
    }
}

@BindingAdapter("cs_show_error")
fun setcs_show_error(nCustomSpinner: CustomSpinner?, nValue: Boolean?) {
    if (nCustomSpinner != null && nValue != null) {
        when (nValue) {
            true -> nCustomSpinner.triggerError()
            false -> nCustomSpinner.triggerDefault()
        }
    }
}

