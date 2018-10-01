package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.binding

import android.databinding.*
import android.view.View
import android.widget.AdapterView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases.Platform
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

@InverseBindingMethods(InverseBindingMethod(type = CustomSpinner::class,attribute = "cs_position"))
class CustomSpinnerPostionAndPopulateBinding {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["cs_position","cs_set_entries"], requireAll = true)
        fun setcs_position(nCustomSpinner: CustomSpinner?, nPosition: Int?, nValues: List<Platform>?) {
            if (nCustomSpinner != null && nPosition != null && nValues!=null ) {

                if (nCustomSpinner.getSpinner().adapter  == null) {
                    val mList: MutableList<Item> = ArrayList()
                    for (item in nValues) {
                        mList.add(Item(nId = item.id, nValue = item.name))
                    }
                    nCustomSpinner.getSpinner().adapter = CustomSpinnerAdapter(nCustomSpinner.context, mList, "left", false)
                }

                if (nCustomSpinner.getPositionExt()!=nPosition) {
                    nCustomSpinner.getSpinner().setSelection(nPosition)
                    nCustomSpinner.setPositionExt(nPosition)
                }
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["cs_positionAttrChanged"], requireAll = false)
        fun setListener(views: CustomSpinner, listener: InverseBindingListener?) {
            if (listener == null) {
                views.getSpinner().onItemSelectedListener = null
            } else {
                val listener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                        listener.onChange()
                        views.byPass2()
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
        fun getcs_position(nCustomSpinner: CustomSpinner): Int {
            return nCustomSpinner.getSpinner().selectedItemId.toInt()
        }
    }
}