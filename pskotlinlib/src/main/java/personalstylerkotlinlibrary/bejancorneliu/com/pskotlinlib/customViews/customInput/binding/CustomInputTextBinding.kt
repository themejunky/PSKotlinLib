package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.binding

import android.databinding.*
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput

@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class, attribute = "ci_text_text"))
class CustomInputTextBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("ci_text_text")
        fun setci_text_text(nCustomInput: CustomInput?, nValue: String?) {
            if (nCustomInput != null && nValue != null) {
                nCustomInput.nInput.setText(nValue)
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["ci_text_textAttrChanged"], requireAll = false)
        fun setListener(nCustomInput: CustomInput?, nListener: InverseBindingListener?) {
            if (nListener != null && nCustomInput != null) {
                nCustomInput.nInput.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                        Log.d("inainte1", "" + charSequence.toString())
                    }

                    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                        Log.d("inainte2", "" + charSequence.toString())
                    }

                    override fun afterTextChanged(editable: Editable) {
                        Log.d("inainte3", "")
                        // nListener.onChange()
                    }
                })
            }
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "ci_text_text")
        fun getci_text_text(nCustomInput: CustomInput?): String {
            if (nCustomInput != null) {
                return nCustomInput.nInput.text.toString()
            } else {
                return "null"
            }
        }
    }
}