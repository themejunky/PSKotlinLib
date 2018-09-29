package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding.old

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_spinner.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

//@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_ws_error_text"))
//class CustomSpinnerErrorBinding {
//    companion object {
//        @JvmStatic
//        @BindingAdapter("cs_ws_error_text")
//        fun setcs_ws_error_text(nCustomSpinner: CustomSpinner?, nValue: String?) {
//            if (nCustomSpinner != null && nValue != null) {
//                with(nCustomSpinner) {
//                    nSpinnerError.text = nValue
//                    nSpinnerMandatory.visibility = View.VISIBLE
//                }
//            }
//        }
//    }
//}