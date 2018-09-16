package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.binding

import android.databinding.*
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.lib_custom_box_image.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage.CustomBoxImage

@InverseBindingMethods(InverseBindingMethod(type = CustomBoxImage::class, attribute = "cbi_is_selected"))
class CustomBoxImageSelectedBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cbi_is_selected")
        fun setcbi_is_selected(mCustomBoxImage: CustomBoxImage, mIsSelected: Boolean) {

            mCustomBoxImage.setActivationState(mIsSelected)
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "cbi_is_selected")
        fun getcbi_is_selected(mCustomBoxImage: CustomBoxImage): Boolean {
            return mCustomBoxImage.getActivationState()
        }

        @JvmStatic
        @BindingAdapter(value = ["cbi_is_selectedAttrChanged"], requireAll = false)
        fun setListener(editText: CustomBoxImage, listener: InverseBindingListener?) {
            if (listener != null) {
                editText.mText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun afterTextChanged(editable: Editable) {
                        listener.onChange()
                    }
                })
            }
        }
    }
}