package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding.old

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

//@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_set_entries"))
//class CustomSpinnerPopulateBinding {
//    companion object {
//        @JvmStatic
//        @BindingAdapter("cs_set_entries")
//        fun setcs_set_entries(nCustomSpinner: CustomSpinner?, nValues: List<Item>?) {
//            if (nCustomSpinner != null && nValues != null) {
//                nCustomSpinner.getSpinner().adapter = CustomSpinnerAdapter(nCustomSpinner.context, nValues, "left", false)
//            }
//        }
//    }
//}