package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.util.Log
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_show_error"))
class CustomSpinnerShowErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cs_show_error")
        fun setcs_show_error(editText: CustomSpinner, text: Boolean) {
            Log.d("asdaddasdas","11")
            if (text) {
                editText.triggerError() }
            else {
                editText.triggerDefault() }
        }
    }
}