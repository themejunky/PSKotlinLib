package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.util.AttributeSet
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools.use
import kotlinx.android.synthetic.main.lib_custom_button.view.*
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.view.View

class CustomButton(context: Context, attrs: AttributeSet) : CustomButtonBase(context, attrs) {


    /* click listener interface */
    interface Custom_Button_Interface {
        fun onCustomButtonClick(view: View)
    }

    fun setListener(nListener : Custom_Button_Interface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_button, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomButton).use {

            mInactiveBackgroundDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_shadow2) as GradientDrawable)
            mInactiveBackgroundDrawable.setColor(ContextCompat.getColor(context, R.color.lib_button_inactive_background))

            mInactiveShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_shadow2) as GradientDrawable)
            mInactiveShadowDrawable.setColor(ContextCompat.getColor(context, R.color.lib_button_inactive_shadow))

            if (it.hasValue(R.styleable.CustomButton_cb_text)) {
                nButton.text = it.getString(R.styleable.CustomButton_cb_text)
            }

            if (it.hasValue(R.styleable.CustomButton_cb_tag)) {
                nContainer.tag = it.getString(R.styleable.CustomButton_cb_tag)
            }

            if (it.hasValue(R.styleable.CustomButton_cb_active_background)) {
                mActiveBackgroundDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_shadow2) as GradientDrawable)
                mActiveBackgroundDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_active_background, 0))
            }

            if (it.hasValue(R.styleable.CustomButton_cb_active_shadow)) {
                mActiveShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.lib_shadow2) as GradientDrawable)
                mActiveShadowDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_active_shadow, 0))
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
         //   nContainer.setOnClickListener(this)
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
}