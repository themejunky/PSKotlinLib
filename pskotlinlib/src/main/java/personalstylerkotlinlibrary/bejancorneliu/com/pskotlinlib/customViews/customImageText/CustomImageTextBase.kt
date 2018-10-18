package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageText

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_box_image_text.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView

open class CustomImageTextBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {

    var mColorActiveDrawable: Int = 0
    var mColorHoverDrawable: Int = 0

    lateinit var mListener: CustomImageText.CustomImageTextInterface

    override fun onTouch(v: View, event: MotionEvent): Boolean {
            when {
                event.action == MotionEvent.ACTION_DOWN -> {
                    mText.setTextColor(mColorHoverDrawable)
                    mImage.setColorFilter(mColorHoverDrawable)
                }
                event.action == MotionEvent.ACTION_UP -> {

                    mText.setTextColor(mColorActiveDrawable)
                    mImage.setColorFilter(mColorActiveDrawable)
                    try {
                        mListener.onCustomBoxImageTextChange(mContainer.tag.toString())
                    } catch (e: Exception) {
                        callOnClick()
                        Log.d("CUSTOM_IMAGE_TEXT", e.message)
                    }
                }
                event.action == MotionEvent.ACTION_CANCEL -> {
                    mText.setTextColor(mColorActiveDrawable)
                    mImage.setColorFilter(mColorActiveDrawable)
                }
            }
        return true
    }

}