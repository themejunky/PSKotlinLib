package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButtonImageText

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_button_image_text.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions.use

class CustomButtonImageText(context: Context, attrs: AttributeSet) : CustomButtonImageTextBase(context, attrs) {

    interface CustomButtonImageTextInterface {
        fun onCustomBoxImageTextChange(mTag: String, mIsActive: Boolean)
    }

    fun setListener(nListener: CustomButtonImageTextInterface) {
        mListener = nListener
    }

    init {
        inflate(context, R.layout.lib_custom_button_image_text, this)
        context.obtainStyledAttributes(attrs, R.styleable.CustomButtonImageText).use {

            // set text
            if (it.hasValue(R.styleable.CustomButtonImageText_cbuit_text)) {
                nButton.text = it.getString(R.styleable.CustomButtonImageText_cbuit_text)
            }

            // set tag
            if (it.hasValue(R.styleable.CustomButtonImageText_cbuit_tag)) {
                nContainer.tag = it.getString(R.styleable.CustomButtonImageText_cbuit_tag)
            }

            // set state of the button
            if (it.hasValue(R.styleable.CustomButtonImageText_cbuit_enable)) {
                if (it.getBoolean(R.styleable.CustomButtonImageText_cbuit_enable,false)) {
                    nContainer.background = (ContextCompat.getDrawable(context, R.drawable.lib_round_full_green))
                    nButton.setTextColor(ContextCompat.getColor(context, R.color.lib_base_white))
                    mIsActive = true
                } else {
                    defaultInactiveButton()
                }
            } else {
                defaultInactiveButton()
            }

            //set icon
            if (it.hasValue(R.styleable.CustomButtonImageText_cbuit_icon)) {
                if (it.getBoolean(R.styleable.CustomButtonImageText_cbuit_icon,false)) {

                    nIcon.visibility = View.VISIBLE
                }
            }

            nContainer.setOnTouchListener(this)
        }
    }

    private fun defaultInactiveButton() {
        nContainer.background = (ContextCompat.getDrawable(context, R.drawable.lib_round_border_gray))
        nButton.setTextColor(ContextCompat.getColor(context, R.color.lib_base_black))
        mIsActive = false
    }

    fun getState() : Boolean {
        return mIsActive
    }

    fun setState(nState : Boolean) {
        mIsActive = nState
    }
}