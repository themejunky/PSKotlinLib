package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_button.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomButton(context: Context, attrs: AttributeSet) : CustomButtonBase(context, attrs) {

    interface CustomButtonInterface {
        fun onCustomButtonClick(view: View)
    }

    fun setListener(nListener: CustomButtonInterface?) {
        if (nListener != null) {
            mListener = nListener
            mSaveListener = nListener
        }
    }

    init {
        inflate(context, R.layout.lib_custom_button, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomButton).use {

            // disable state default colors
            mDisableColorActiveDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)
            mDisableColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_disable_active))

            mDisableColorShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)
            mDisableColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_disable_shadow))

            mDisableColorHoverDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)
            mDisableColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_disable_pressed))

            mColorActiveDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)
            mColorHoverDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)
            mColorShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_button_background) as GradientDrawable)

            // set text
            if (it.hasValue(R.styleable.CustomButton_cb_text)) {
                nButton.text = it.getString(R.styleable.CustomButton_cb_text)
            }

            // set tag
            if (it.hasValue(R.styleable.CustomButton_cb_tag)) {
                nContainer.tag = it.getString(R.styleable.CustomButton_cb_tag)
            }

            // set disalbe
            if (it.hasValue(R.styleable.CustomButton_cb_form_loading)) {
                mButtonIsActive = it.getBoolean(R.styleable.CustomButton_cb_form_loading, false)
            }

            // set custom active color
            if (it.hasValue(R.styleable.CustomButton_cb_color_active)) {
                mColorActiveDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_color_active, 0))
            }

            // set custom hover color
            if (it.hasValue(R.styleable.CustomButton_cb_color_hover)) {
                mColorHoverDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_color_hover, 0))
            }

            // set custom shadow color
            if (it.hasValue(R.styleable.CustomButton_cb_color_shadow)) {
                mColorShadowDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_color_shadow, 0))
            }

            //the above can be replaced with build in colors
            if (it.hasValue(R.styleable.CustomButton_cb_button_color)) {
                when (it.getString(R.styleable.CustomButton_cb_button_color)) {
                    "1" -> {
                        mColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_blue_active))
                        mColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_blue_pressed))
                        mColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_blue_shadow))
                    }
                    "2" -> {
                        mColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_green_active))
                        mColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_green_pressed))
                        mColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_green_shadow))
                    }
                    "3" -> {
                        mColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_grey_active))
                        mColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_grey_pressed))
                        mColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_grey_shadow))
                    }
                    "4" -> {
                        mColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_red_active))
                        mColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_red_pressed))
                        mColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_red_shadow))
                    }
                    "5" -> {
                        mColorActiveDrawable.setColor(ContextCompat.getColor(context, R.color.lib_violet_active))
                        mColorHoverDrawable.setColor(ContextCompat.getColor(context, R.color.lib_violet_pressed))
                        mColorShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_violet_shadow))
                    }
                }
            }

            if (it.hasValue(R.styleable.CustomButton_cb_form_validation)) {
                mButtonValidation = it.getBoolean(R.styleable.CustomButton_cb_form_validation, false)
                if (it.getBoolean(R.styleable.CustomButton_cb_form_validation, false)) {
                    mInactiveRelease()
                } else {
                    mActiveRelease()
                }
            }
            nContainer.setOnTouchListener(this)
        }
    }

    fun setTag(nTag: Int) {
        nContainer.tag = context.getString(nTag)
    }

    fun setTag(nTag: String) {
        nContainer.tag = nTag
    }

    fun setText(nText: Int) {
        nButton.text = context.getString(nText)
    }

    fun setText(nText: String) {
        nButton.text = nText
    }

    fun setActive() {
        mActiveRelease()
    }

    fun setInactive() {
        mInactiveRelease()
    }

    fun disableListener(nDisable: Boolean) {
        if (nDisable) {
            mListener = null
        } else {
            mListener = mSaveListener
        }
    }

    fun setDisable(nDisable: Boolean) {
        mButtonIsActive = nDisable
    }
}