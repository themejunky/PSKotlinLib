package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.util.Log
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput

@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class,attribute = "ci_show_error"))
class CustomInputShowErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("ci_show_error")
        fun setci_show_error(editText: CustomInput, text: Boolean) {
            if (text) {
                editText.triggerError() }
            else {
                editText.triggerDefault() }
        }
    }
}