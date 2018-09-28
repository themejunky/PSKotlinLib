package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions

import android.widget.Spinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases.Platform
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item
import java.util.ArrayList

fun Spinner.setSpinnerEntries(nValues: List<Item>?) {
    if (nValues != null) {
        adapter = CustomSpinnerAdapter(context, nValues, "left", false)
    }
}

fun Spinner.setSpinnerEntriesP(nValues: List<Platform>?) {
    if (nValues != null) {
        val mList: MutableList<Item> = ArrayList()
        for (item in nValues) {
            mList.add(Item(nId = item.id, nValue = item.name))
        }
        adapter = CustomSpinnerAdapter(context, mList, "left", false)

    }
}