package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.util.AttributeSet
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools.use
import kotlinx.android.synthetic.main.custom_button.view.*
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat

class CustomButton(context: Context, attrs: AttributeSet) : CustomButtonBase(context, attrs) {

    init {
        inflate(context, R.layout.custom_button, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomButton).use {


            mInactiveBackgroundDrawable = (ContextCompat.getDrawable(context, R.drawable.shadow2) as GradientDrawable)
            mInactiveBackgroundDrawable.setColor(ContextCompat.getColor(context,R.color.lib_button_inactive_background))

            mInactiveShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.shadow2) as GradientDrawable)
            mInactiveShadowDrawable.setColor(ContextCompat.getColor(context,R.color.lib_button_inactive_shadow))

            if (it.hasValue(R.styleable.CustomButton_cb_active_background)) {
                mActiveBackgroundDrawable = (ContextCompat.getDrawable(context, R.drawable.shadow2) as GradientDrawable)
                mActiveBackgroundDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_active_background,0))
            }

            if (it.hasValue(R.styleable.CustomButton_cb_active_shadow)) {
                mActiveShadowDrawable = (ContextCompat.getDrawable(context, R.drawable.shadow2) as GradientDrawable)
                mActiveShadowDrawable.setColor(it.getColor(R.styleable.CustomButton_cb_active_shadow,0))
            }

            nButton.background = mActiveBackgroundDrawable
            nShadow.background = mActiveShadowDrawable

            nContainer.setOnTouchListener(this)
        }
    }
}