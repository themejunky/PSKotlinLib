package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_ws_error_text"))
class CustomSpinnerErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cs_ws_error_text")
        fun setcs_ws_error_text(editText: CustomSpinner, text: String) {
            editText.nInputError.text = text
            editText.nInputMandatory.visibility = View.VISIBLE
        }
    }
}