package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_position"))
class CustomSpinnerPostionBinding {
    companion object {

        @JvmStatic
        @BindingAdapter("cs_position")
        fun setcs_positions(nCustomSpinner: CustomSpinner?, nPosition: Int?) {
            if (nCustomSpinner != null && nPosition != null) {
                nCustomSpinner.getSpinner().setSelection(nPosition)
            }
        }

        /*
        @JvmStatic
        @BindingAdapter(value = ["cs_positionAttrChanged"], requireAll = false)
        fun setProvinceListener(view: CustomSpinner?, cityChange: InverseBindingListener?) {
            if (view!=null && cityChange!=null) {
                val listener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                        cityChange.onChange()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        cityChange.onChange()
                    }
                }
                view.getSpinner().onItemSelectedListener = listener
            }
        }


        @JvmStatic
        @InverseBindingAdapter(attribute = "cs_position")
        fun getcs_position(nMe: CustomSpinner): Int {
            return nMe.getSpinner().selectedItemPosition
        }*/
    }
}