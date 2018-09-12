package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customBoxImage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import kotlinx.android.synthetic.main.lib_custom_box_image.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools.use
import android.support.v4.content.ContextCompat
import android.util.Log

class CustomBoxImage(context: Context, attrs: AttributeSet) : CustomBoxImageBase(context, attrs) {

    interface CustomBoxImageInterface {
        fun onCustomBoxImageChange(mTag : String)
    }



    fun setListener(nListener: CustomBoxImageInterface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_box_image, this)
        this.setOnTouchListener(this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomBoxImage).use {

            mPicContainer.viewTreeObserver.addOnGlobalLayoutListener(this)

            //set Icon
            if (it.hasValue(R.styleable.CustomBoxImage_cbi_icon)) {
                mIcon.setImageDrawable(it.getDrawable(R.styleable.CustomBoxImage_cbi_icon))
            }

            //set Icon
            if (it.hasValue(R.styleable.CustomBoxImage_cbi_text)) {
                mText.text = it.getString(R.styleable.CustomBoxImage_cbi_text)
            }

            //set Tag
            if (it.hasValue(R.styleable.CustomBoxImage_cbi_tag)) {
                mContainer.tag = it.getString(R.styleable.CustomBoxImage_cbi_tag)
            }

            // set custom active color
            mActiveTextColor = if (it.hasValue(R.styleable.CustomBoxImage_cbi_active_text_color)) {
                it.getColor(R.styleable.CustomTextView_ctv_active_text_color,0)
            } else {
                ContextCompat.getColor(context, R.color.lib_border_box_image_active)
            }



            // set custom hover color
            mHoverTextColor = if (it.hasValue(R.styleable.CustomBoxImage_cbi_hover_text_color)) {
                it.getColor(R.styleable.CustomBoxImage_cbi_hover_text_color,0)
            } else {
                ContextCompat.getColor(context, R.color.lib_border_box_image_inactive)
            }
        }
    }

    fun setActivationState(nValue : Boolean) {
        mIsActive = nValue
    }

    fun getActivationState() : Boolean {
        return mIsActive
    }




}