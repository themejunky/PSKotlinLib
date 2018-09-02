package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import kotlinx.android.synthetic.main.lib_custom_box_image.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import kotlin.properties.Delegates

abstract class CustomBoxImageBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    var mSavedSize = 0
    var mActiveTextColor : Int = 0
    var mHoverTextColor : Int = 0

    var mIsActive by Delegates.observable<Boolean>(false) { _, _, _ -> judgeState() }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        mSavedSize = measuredWidth
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onGlobalLayout() {
        val params = mPicContainer.layoutParams as ConstraintLayout.LayoutParams
        params.width = mSavedSize
        params.height = mSavedSize
        mPicContainer.layoutParams = params

        this.requestLayout()
        mPicContainer.requestLayout()
        mIcon.requestLayout()
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (event.action== MotionEvent.ACTION_DOWN) {
            mText.setTextColor(mHoverTextColor)
            mIcon.setColorFilter(mHoverTextColor)
            mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_roud_corners_hover)
        }
        if (event.action== MotionEvent.ACTION_UP) {

            mIsActive = !mIsActive

            if (mIsActive) {
                mText.setTextColor(mActiveTextColor)
                mIcon.setColorFilter(mActiveTextColor)
                mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners_active)
            } else {
                mText.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
                mIcon.setColorFilter(ContextCompat.getColor(context, R.color.lib_base_black))
                mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners)
            }
        }
        return true
    }

    fun judgeState() {
        if (mIsActive) {
            mText.setTextColor(mActiveTextColor)
            mIcon.setColorFilter(mActiveTextColor)
            mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners_active)
        } else {
            mText.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
            mIcon.setColorFilter(ContextCompat.getColor(context, R.color.lib_base_black))
            mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners)
        }

        Toast.makeText(context,""+mIsActive,Toast.LENGTH_SHORT).show()
    }
}