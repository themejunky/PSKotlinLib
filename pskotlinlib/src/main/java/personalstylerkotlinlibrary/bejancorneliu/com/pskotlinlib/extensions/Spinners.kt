package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions

import android.widget.Spinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

fun Spinner.setSpinnerEntries(nValues: List<Item>?) {
    if (nValues != null) {
        adapter = CustomSpinnerAdapter(context, nValues, "left", false)
    }
}