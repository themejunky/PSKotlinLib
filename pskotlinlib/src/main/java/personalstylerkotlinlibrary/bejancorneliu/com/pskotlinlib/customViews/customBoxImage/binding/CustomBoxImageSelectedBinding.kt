package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.widget.CompoundButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.CustomBoxImage
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput


@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class, attribute = "cbi_is_selected"))
class CustomBoxImageSelectedBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cbi_is_selected")
        fun setcbi_is_selected(editText: CustomBoxImage, text: Boolean) {
            editText.setActivationState(text)
        }
    }
}

@BindingAdapter("android:checked")
fun setChecked(checkableView: CompoundButton, isChecked: Boolean?) {
    checkableView.isChecked = isChecked ?: false
}