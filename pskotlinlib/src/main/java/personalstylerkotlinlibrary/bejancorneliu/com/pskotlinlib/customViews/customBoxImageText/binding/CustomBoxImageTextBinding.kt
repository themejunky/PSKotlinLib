package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.CustomBoxImage
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText.CustomBoxImageText

@InverseBindingMethods(InverseBindingMethod(type = CustomBoxImageText::class, attribute = "cbit_is_active"))
class CustomButtonDeactivateListenerBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cbit_is_active")
        fun setis_active(mCustomBoxImage: CustomBoxImage?, isActive: Boolean?) {
            if (mCustomBoxImage != null && isActive != null) {
                mCustomBoxImage.setActivationState(isActive)
            }
        }
    }
}