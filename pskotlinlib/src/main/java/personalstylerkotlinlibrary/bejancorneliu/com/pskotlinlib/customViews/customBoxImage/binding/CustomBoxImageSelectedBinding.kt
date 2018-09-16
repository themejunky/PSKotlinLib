package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.binding

import android.databinding.BindingAdapter
import android.widget.CompoundButton

@BindingAdapter("android:checked")
fun setChecked(checkableView: CompoundButton, isChecked: Boolean?) {
    checkableView.isChecked = isChecked ?: false
}