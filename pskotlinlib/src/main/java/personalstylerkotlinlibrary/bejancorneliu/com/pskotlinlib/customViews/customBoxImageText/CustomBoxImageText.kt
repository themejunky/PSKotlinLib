package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImageText

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_box_image_text.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomBoxImageText(context: Context, attrs: AttributeSet) : CustomBoxImageTextBase(context, attrs) {
    interface CustomBoxImageTextInterface {
        fun onCustomBoxImageTextChange(mTag: String, mIsActive: Boolean)
    }

    fun setListener(nListener: CustomBoxImageTextInterface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_box_image_text, this)
        this.setOnTouchListener(this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomBoxImageText).use {

            //set Icon
            if (it.hasValue(R.styleable.CustomBoxImageText_cbit_icon)) {
                mImage.setImageDrawable(it.getDrawable(R.styleable.CustomBoxImageText_cbit_icon))
            }

            //set Text
            if (it.hasValue(R.styleable.CustomBoxImageText_cbit_text)) {
                mText.text = it.getString(R.styleable.CustomBoxImageText_cbit_text)
            }

            //set Tags
            if (it.hasValue(R.styleable.CustomBoxImageText_cbit_tag)) {
                mContainer.tag = it.getString(R.styleable.CustomBoxImageText_cbit_tag)
            }

            // set custom active color
            mActiveTextColor = if (it.hasValue(R.styleable.CustomBoxImageText_cbit_active_text_color)) {
                it.getColor(R.styleable.CustomBoxImageText_cbit_active_text_color, 0)
            } else {
                ContextCompat.getColor(context, R.color.lib_border_box_image_active)
            }


            // set custom hover colorss
            mHoverTextColor = if (it.hasValue(R.styleable.CustomBoxImageText_cbit_hover_text_color)) {
                it.getColor(R.styleable.CustomBoxImageText_cbit_hover_text_color, 0)
            } else {
                ContextCompat.getColor(context, R.color.lib_border_box_image_inactive)
            }

        }
    }

    fun setActivationState(nValue: Boolean) {
        mIsActive = nValue
        if (mIsActive) {
            mText.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
            mImage.setColorFilter(ContextCompat.getColor(context, R.color.lib_base_black))
            mContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_round_corners)
        } else {
            mText.setTextColor(mHoverTextColor)
            mImage.setColorFilter(mHoverTextColor)
            mContainer.background = ContextCompat.getDrawable(context, R.drawable.lib_container_roud_corners_hover)
        }
    }

    fun getActivationState(): Boolean {
        return mIsActive
    }

    fun getParrent(): View {
        return this
    }
}