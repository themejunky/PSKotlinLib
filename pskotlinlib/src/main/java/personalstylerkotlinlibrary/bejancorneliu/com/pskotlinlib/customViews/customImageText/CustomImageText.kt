package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageText

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import kotlinx.android.synthetic.main.lib_custom_image_text.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomImageText(context: Context, attrs: AttributeSet) : CustomImageTextBase(context, attrs) {

    interface CustomImageTextInterface {
        fun onCustomBoxImageTextChange(mTag: String)
    }

    fun setListener(nListener: CustomImageTextInterface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_image_text, this)
        this.setOnTouchListener(this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomImageText).use {

            //set Icon
            if (it.hasValue(R.styleable.CustomImageText_cit_icon)) {
                mImage.setImageDrawable(it.getDrawable(R.styleable.CustomImageText_cit_icon))
            }

            //set Text
            if (it.hasValue(R.styleable.CustomImageText_cit_text)) {
                mText.text = it.getString(R.styleable.CustomImageText_cit_text)
            }

            // set tagu
            if (it.hasValue(R.styleable.CustomImageText_cit_tag)) {
                mContainer.tag = it.getString(R.styleable.CustomImageText_cit_tag)
            }

            //the above can be replaced with build in colors
            if (it.hasValue(R.styleable.CustomImageText_cit_color)) {
                when (it.getString(R.styleable.CustomImageText_cit_color)) {
                    "1" -> {
                        mColorActiveDrawable = (ContextCompat.getColor(context, R.color.lib_blue_active))
                        mColorHoverDrawable = (ContextCompat.getColor(context, R.color.lib_blue_pressed))
                    }
                    "2" -> {
                        mColorActiveDrawable = (ContextCompat.getColor(context, R.color.lib_green_active))
                        mColorHoverDrawable = (ContextCompat.getColor(context, R.color.lib_green_pressed))
                    }
                    "3" -> {
                        mColorActiveDrawable = (ContextCompat.getColor(context, R.color.lib_grey_active))
                        mColorHoverDrawable = (ContextCompat.getColor(context, R.color.lib_grey_pressed))
                    }
                    "4" -> {
                        mColorActiveDrawable = (ContextCompat.getColor(context, R.color.lib_red_active))
                        mColorHoverDrawable = (ContextCompat.getColor(context, R.color.lib_red_pressed))
                    }
                    "5" -> {
                        mColorActiveDrawable = (ContextCompat.getColor(context, R.color.lib_violet_active))
                        mColorHoverDrawable = (ContextCompat.getColor(context, R.color.lib_violet_pressed))
                    }
                }
            }

            mText.setTextColor(mColorHoverDrawable)
            mImage.setColorFilter(mColorHoverDrawable)

        }
    }
}