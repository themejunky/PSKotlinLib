package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_ws_error_text"))
class CustomSpinnerErrorBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cs_ws_error_text")
        fun setcs_ws_error_text(editText: CustomSpinner, text: String) {
            Log.d("asdaddasdas","1")
            editText.nSpinnerError.text = text
            editText.nSpinnerMandatory.visibility = View.VISIBLE
        }
    }
}