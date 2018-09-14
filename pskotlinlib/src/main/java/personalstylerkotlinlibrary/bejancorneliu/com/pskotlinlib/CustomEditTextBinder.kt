package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib

import android.databinding.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_input.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import android.databinding.InverseBindingAdapter


//
////,event = "android:textAttrChanged",method = "getText"
//@InverseBindingMethods(InverseBindingMethod(type = CustomInput::class,attribute = "textulmeu"))
//class CustomEditTextBinder {
//    companion object {
//        @JvmStatic
//        @BindingAdapter(value = ["textulmeuAttrChanged"], requireAll = false)
//        fun setListener(editText: CustomInput, listener: InverseBindingListener?) {
//            if (listener != null) {
//                editText.nInput.addTextChangedListener(object : TextWatcher {
//                    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//
//                    }
//
//                    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//
//                    }
//
//                    override fun afterTextChanged(editable: Editable) {
//                        listener.onChange()
//                    }
//                })
//            }
//        }
//
////        @JvmStatic @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
////        fun getTextString(editText: CustomInput): String {
////            return editText.nInput.text.toString()
////        }
//
//
//
//
//        @JvmStatic
//        @InverseBindingAdapter(attribute = "textulmeu")
//        fun getTextulmeu(nMe: CustomInput): String {
//            return nMe.nInput.text.toString()
//        }
//
//        @JvmStatic
//        @BindingAdapter("textulmeu")
//        fun setTextulmeu(editText: CustomInput, text: String?) {
//            text?.let {
//                if (it != editText.nInput.text.toString()) {
//                    editText.nInput.setText(it)
//                }
//            }
//        }
//
//        @JvmStatic
//        @InverseBindingAdapter(attribute = "textulmeu")
//        fun gettextulmeu(nMe: CustomInput): String {
//            return nMe.nInput.text.toString()
//        }
//
//        @JvmStatic
//        @BindingAdapter("textulmeu")
//        fun settextulmeu(editText: CustomInput, text: String?) {
//            text?.let {
//                if (it != editText.nInput.text.toString()) {
//                    editText.nInput.setText(it)
//                }
//            }
//        }
//    }
//}