package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput

@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class, attribute = "ci_ws_error_text"))
class CustomInputErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("ci_ws_error_text")
        fun setci_ws_error_text(nCustomInput: CustomInput?, nValue: String?) {
            if (nCustomInput != null && nValue != null) {
                with(nCustomInput)
                {
                    nInputError.text = nValue
                    nInputMandatory.visibility = View.VISIBLE
                }
            }
        }
    }
}