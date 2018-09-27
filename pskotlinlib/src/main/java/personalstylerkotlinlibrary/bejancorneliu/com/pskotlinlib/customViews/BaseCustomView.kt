package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews

import android.content.Context
import android.graphics.Typeface
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

open class BaseCustomView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    val typefaceRegular = Typeface.createFromAsset(context.assets, "Regular.ttf")
    val typefaceBold = Typeface.createFromAsset(context.assets, "Bold.ttf")
    var mDensity: Int = (context.resources.displayMetrics.density).toInt()

}

open class BaseCustomViewContext(context: Context) : ConstraintLayout(context) {

    val typefaceRegular = Typeface.createFromAsset(context.assets, "Regular.ttf")
    val typefaceBold = Typeface.createFromAsset(context.assets, "Bold.ttf")
    var mDensity: Int = (context.resources.displayMetrics.density).toInt()

}

