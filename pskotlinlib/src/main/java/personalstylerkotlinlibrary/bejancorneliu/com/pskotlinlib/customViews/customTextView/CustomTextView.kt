package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customTextView

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs), View.OnTouchListener {

    var mActiveTextColor : Int = 0
    var mHoverTextColor : Int = 0
    lateinit var mListener: CustomTextViewInterface

    interface CustomTextViewInterface {
        fun onCustomTextViewClick(view: View)
    }

    fun setListener(nListener: CustomTextViewInterface) {
        mListener = nListener
    }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.CustomTextView).use {
        this.setOnTouchListener(this)

            // set custom active color
            if (it.hasValue(R.styleable.CustomTextView_ctv_active_text_color)) {
                mActiveTextColor = it.getColor(R.styleable.CustomTextView_ctv_active_text_color,0)
            }

            // set custom hover color
            if (it.hasValue(R.styleable.CustomTextView_ctv_hover_text_color)) {
                mHoverTextColor = it.getColor(R.styleable.CustomTextView_ctv_hover_text_color,0)
            }

            // set tag
            if (it.hasValue(R.styleable.CustomTextView_ctv_tag)) {
                this.tag = it.getString(R.styleable.CustomTextView_ctv_tag)
            }

            //the above can be replaced with build in colors
            if (it.hasValue(R.styleable.CustomTextView_ctv_text_color)) {
                when (it.getString(R.styleable.CustomTextView_ctv_text_color)) {
                    "0" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_black_active); mHoverTextColor= ContextCompat.getColor(context, R.color.lib_black_pressed) }
                    "1" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_blue_active); mHoverTextColor= ContextCompat.getColor(context, R.color.lib_blue_pressed)}
                    "2" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_green_active); mHoverTextColor=ContextCompat.getColor(context, R.color.lib_green_pressed)}
                    "3" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_grey_active); mHoverTextColor=ContextCompat.getColor(context, R.color.lib_grey_pressed)}
                    "4" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_red_active); mHoverTextColor=ContextCompat.getColor(context, R.color.lib_red_pressed)}
                    "5" -> { mActiveTextColor=ContextCompat.getColor(context, R.color.lib_violet_active); mHoverTextColor=ContextCompat.getColor(context, R.color.lib_violet_pressed)}
                }
            }

            this.setTextColor(mActiveTextColor)
        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (event.action==MotionEvent.ACTION_DOWN) {
            this.setTextColor(mHoverTextColor)
        }
        if (event.action==MotionEvent.ACTION_UP) {
            this.setTextColor(mActiveTextColor)

            try {
                mListener.onCustomTextViewClick(this)
            } catch (e : Exception) {
                Log.d("CUSTOM_TEXT_VIEW",e.message)
            }
        }
        return true
    }
}