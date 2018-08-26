package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item
import java.util.ArrayList

const val ROW_LEFT = "left"
const val ROW_RIGHT = "right"

open class CustomSpinnerAdapter(context: Context, nValues: List<Item>, nAlignment: String, nBold:Boolean=false) : BaseAdapter() {
    private val mInflator: LayoutInflater = LayoutInflater.from(context)
    private val mValues: MutableList<Item>
    private val typefaceRegular = Typeface.createFromAsset(context.assets, "Regular.ttf")
    private val typefaceBold = Typeface.createFromAsset(context.assets, "Bold.ttf")
    private var mDensity: Int = (context.getResources().getDisplayMetrics().density).toInt()
    private val mAlignment = nAlignment
    private val mBold = nBold

    init {
        this.mValues = ArrayList()
        this.mValues.addAll(nValues)
    }

    override fun getCount(): Int {
        return mValues.size
    }

    override fun getItem(position: Int): Any {
        return mValues[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getValues() : List<Item> {
        return mValues
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = if (mAlignment.equals(ROW_LEFT)) {
                this.mInflator.inflate(R.layout.lib_custom_spinner_row_left_adapter, parent, false)
            } else {
                this.mInflator.inflate(R.layout.lib_custom_spinner_row_right_adapter, parent, false)
            }
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.label.text = mValues[position].value
        vh.label.typeface = if (mBold) { typefaceBold } else { typefaceRegular }
        vh.label.setPadding((10*mDensity + 0.15f ).toInt(), (5*mDensity + 0.15f).toInt(), (10*mDensity + 0.15f).toInt(), (5*mDensity + 0.15f).toInt()+(14*1.0f).toInt())

        return view
    }
}

private class ListRowHolder(row: View?) {
     val label: TextView = row?.findViewById(R.id.nRowSpinerAdapterText) as TextView

}