package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput


@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class,attribute = "ci_error_text"))
class CustomInputErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("ci_error_text")
        fun setci_error_text(editText: CustomInput, text: String?) {
            text?.let {
                if (it != editText.nInputError.text.toString()) {
                    editText.nInput.setText(it)
                }
            }
        }
    }
}