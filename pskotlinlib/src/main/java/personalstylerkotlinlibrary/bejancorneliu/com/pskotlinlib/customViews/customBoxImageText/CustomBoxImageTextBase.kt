package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_box_image.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import kotlin.properties.Delegates

abstract class CustomBoxImageTextBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {
    var mActiveTextColor: Int = 0
    var mHoverTextColor: Int = 0
    lateinit var mListener: CustomBoxImageText.CustomBoxImageTextInterface
    var mIsActive by Delegates.observable(false) { _, _, _ -> judgeState() }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when {
            event.action == MotionEvent.ACTION_DOWN -> {
                mText.setTextColor(mHoverTextColor)
                mIcon.setColorFilter(mHoverTextColor)
                mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_roud_corners_hover)
            }
            event.action == MotionEvent.ACTION_UP -> {

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

                try {
                    mListener.onCustomBoxImageTextChange(mContainer.tag.toString(), mIsActive)
                } catch (e: Exception) {
                    Log.d("CUSTOM_BOX_IMAGE", e.message)
                }
            }
            event.action == MotionEvent.ACTION_CANCEL -> {
                mIsActive = false
                mText.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
                mIcon.setColorFilter(ContextCompat.getColor(context, R.color.lib_base_black))
                mPicContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners)
            }
        }
        return true
    }

    private fun judgeState() {
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
}