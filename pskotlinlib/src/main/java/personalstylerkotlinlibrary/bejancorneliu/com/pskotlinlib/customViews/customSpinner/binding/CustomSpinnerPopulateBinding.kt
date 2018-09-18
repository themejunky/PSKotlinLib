package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases.Cities
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_set_entries"))
class CustomSpinnerPopulateBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cs_set_entries")
        fun setcs_set_entries(editText: CustomSpinner, entries: List<Cities>?) {
            if (entries!=null) {
                editText.getSpinner().adapter =  CustomSpinnerAdapter(editText.context,entries, "left",false)
            }
        }

    }
}