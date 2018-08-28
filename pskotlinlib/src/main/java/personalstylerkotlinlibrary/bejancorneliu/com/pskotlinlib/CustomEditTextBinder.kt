package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib

import android.databinding.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput


@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class,attribute = "app:Text",method = "getText"))
class CustomEditTextBinder {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["app:textAttrChanged"])
        fun setListener(editText: CustomInput, listener: InverseBindingListener?) {
            if (listener != null) {
                editText.nInput.addTextChangedListener(object : TextWatcher {
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

        @JvmStatic
        @BindingAdapter("app:Text")
        fun setText(editText: CustomInput, text: String?) {
            text?.let {
                if (it != editText.nInput.text.toString()) {
                    editText.nInput.setText(it)
                }
            }
        }
    }
}