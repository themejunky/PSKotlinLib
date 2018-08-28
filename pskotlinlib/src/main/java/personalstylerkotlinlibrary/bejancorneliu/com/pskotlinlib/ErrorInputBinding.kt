package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib

import android.databinding.InverseBindingAdapter
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.databinding.BindingAdapter
import android.databinding.InverseBindingListener
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput


class ErrorInputBinding {
    @BindingAdapter(value = "TextAttrChanged")
    fun setListener(errorInputLayout: CustomInput, textAttrChanged: InverseBindingListener?) {
        if (textAttrChanged != null) {
            errorInputLayout.nInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable) {

                }
            })
        }
    }

    @BindingAdapter("text")
    fun setText(view: CustomInput, value: String?) {
            view.nInput.setText(value)
    }

    @InverseBindingAdapter(attribute = "text")
    fun getText(errorInputLayout: CustomInput): String {
        return errorInputLayout.nInput.text.toString()
    }
}