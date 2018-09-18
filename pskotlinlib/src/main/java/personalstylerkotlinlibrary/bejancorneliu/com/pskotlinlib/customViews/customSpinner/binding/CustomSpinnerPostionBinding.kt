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
        fun setcs_positions(editText: CustomSpinner, entries: Int?) {
            if (entries!=null) {
                editText.getSpinner().setSelection(entries)
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["cs_positionAttrChanged"], requireAll = false)
        fun setProvinceListener(view: CustomSpinner, cityChange: InverseBindingListener) {
            val listener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    cityChange.onChange()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    cityChange.onChange()
                }
            }
            view.getSpinner().onItemSelectedListener = listener
        }


        @JvmStatic
        @InverseBindingAdapter(attribute = "cs_position")
        fun getcs_position(nMe: CustomSpinner): Int {
            return nMe.getSpinner().selectedItemPosition
        }
    }
}