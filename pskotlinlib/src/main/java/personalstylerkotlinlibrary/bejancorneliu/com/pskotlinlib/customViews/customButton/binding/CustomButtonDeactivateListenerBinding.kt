package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton

@InverseBindingMethods(InverseBindingMethod(type = CustomButton::class, attribute = "cb_deactivate_listener"))
class CustomButtonDeactivateListenerBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cb_deactivate_listener")
        fun setcb_enable(nCustomButton: CustomButton?, nDeactivate: Boolean?) {
            if (nCustomButton != null && nDeactivate != null) {
                nCustomButton.disableListener(nDeactivate)
            }
        }
    }
}