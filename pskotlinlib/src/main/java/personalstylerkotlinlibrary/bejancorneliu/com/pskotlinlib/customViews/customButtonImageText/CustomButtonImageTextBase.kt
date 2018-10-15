package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButtonImageText

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_button_image_text.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView
import kotlin.properties.Delegates

open class CustomButtonImageTextBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {

    lateinit var mListener: CustomButtonImageText.CustomButtonImageTextInterface

    var mIsActive by Delegates.observable(false) { _, _, _ -> judgeState() }

    var mHoverTextColor = ContextCompat.getColor(context,R.color.lib_disable_pressed)
    var mHoverBackgroundColor = ContextCompat.getDrawable(context,R.drawable.lib_round_border_grey_pressed)

    var mInactiveTextColor = ContextCompat.getColor(context,R.color.lib_base_black)
    var mInactiveBackgroundColor = ContextCompat.getDrawable(context,R.drawable.lib_round_border_gray)

    var mActiveTextColor = ContextCompat.getColor(context,R.color.lib_base_white)
    var mActiveBackgroundColor = ContextCompat.getDrawable(context,R.drawable.lib_round_full_green)

    override fun onTouch(v: View, event: MotionEvent): Boolean {
            when {
                event.action == MotionEvent.ACTION_DOWN -> {
                    nButton.setTextColor(mHoverTextColor)
                    nContainer.background = mHoverBackgroundColor
                }
                event.action == MotionEvent.ACTION_UP -> {
                    mIsActive = !mIsActive

                    try {
                        mListener.onCustomBoxImageTextChange(nContainer.tag.toString(), mIsActive)
                    } catch (e: Exception) {
                        Log.d("CUSTOM_BUTTON_IMAGE_TEXT", e.message)
                    }
                }

                event.action == MotionEvent.ACTION_CANCEL -> {
                    judgeState()
                }
            }
        return true
    }

    private fun judgeState() {
        if (mIsActive) {
            nButton.setTextColor(mActiveTextColor)
            nContainer.background = mActiveBackgroundColor
        } else {
            nButton.setTextColor(mInactiveTextColor)
            nContainer.background = mInactiveBackgroundColor
        }
    }
}