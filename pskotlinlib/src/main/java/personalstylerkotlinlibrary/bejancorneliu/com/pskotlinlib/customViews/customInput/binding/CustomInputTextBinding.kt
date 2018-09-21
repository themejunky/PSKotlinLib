package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.binding

import android.databinding.*
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput

@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class, attribute = "ci_text_text"))
class CustomInputTextBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("ci_text_text")
        fun setci_text_text(editText: CustomInput, text: String?) {
            text?.let {
                if (it != editText.nInput.text.toString()) {
                    editText.nInput.setText(it)
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["ci_text_textAttrChanged"], requireAll = false)
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
        @InverseBindingAdapter(attribute = "ci_text_text")
        fun getci_text_text(nMe: CustomInput): String {
            return nMe.nInput.text.toString()
        }
    }
}