package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText.CustomBoxImageText

@InverseBindingMethods(InverseBindingMethod(type = CustomBoxImageText::class, attribute = "cbit_is_active"))
class CustomButtonDeactivateListenerBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cbit_is_active")
        fun setcbit_is_active(mCustomBoxImage: CustomBoxImageText?, isActive: Boolean?) {
            if (mCustomBoxImage != null && isActive != null) {
                mCustomBoxImage.setActivationState(isActive)
            }
        }
    }
}