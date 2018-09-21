package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton

@InverseBindingMethods(InverseBindingMethod(type = CustomButton::class,attribute = "cb_enable"))
class CustomButtonEnableBiding {
    companion object {
        @JvmStatic
        @BindingAdapter("cb_enable")
        fun setcb_enable(nCustomButton: CustomButton?, nEnable: Boolean?) {
            if (nCustomButton != null && nEnable != null) {
                if (nEnable) {
                    nCustomButton.setActive()
                } else {
                    nCustomButton.setInactive()
                }
            }
        }
    }
}