package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.*
import android.view.View
import android.widget.AdapterView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_position"))
class CustomSpinnerPostionBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("cs_position")
        fun setcs_position(nCustomSpinner: CustomSpinner?, nPosition: Int?) {
            if (nCustomSpinner != null && nPosition != null) {
                nCustomSpinner.getSpinner().setSelection(nPosition)
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["cs_positionAttrChanged"], requireAll = false)
        fun setListener(views: CustomSpinner, listener: InverseBindingListener?) {
            if (listener == null) {
                views.getSpinner().onItemSelectedListener = null
            } else {
                val listener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                        listener.onChange()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        listener.onChange()
                    }
                }
                views.getSpinner().onItemSelectedListener = listener
            }
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "cs_position")
        fun getcs_position(nCustomSpinner: CustomSpinner): String {
            return nCustomSpinner.getSpinner().selectedItem.toString()
        }
    }
}