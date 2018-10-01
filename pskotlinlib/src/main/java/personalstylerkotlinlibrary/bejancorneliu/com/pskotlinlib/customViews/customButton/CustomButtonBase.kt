package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_button.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView

open class CustomButtonBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {
    var mButtonValidation: Boolean = false
    var mButtonIsActive: Boolean = true

    var mColorActiveDrawable: GradientDrawable = GradientDrawable()
    var mColorShadowDrawable: GradientDrawable = GradientDrawable()
    var mColorHoverDrawable: GradientDrawable = GradientDrawable()
    var mDisableColorActiveDrawable: GradientDrawable = GradientDrawable()
    var mDisableColorShadowDrawable: GradientDrawable = GradientDrawable()
    var mDisableColorHoverDrawable: GradientDrawable = GradientDrawable()
    var mListener: CustomButton.CustomButtonInterface? = null
    var mSaveListener: CustomButton.CustomButtonInterface? = null
    override fun onTouch(nView: View, nMotionEvent: MotionEvent): Boolean {
        mButtonValidation.let {
            if (nMotionEvent.action == MotionEvent.ACTION_DOWN) {
                when (it) {
                    false -> mActiveTouch()
                    true -> mInactiveTouch()
                }
                return true
            } else if (nMotionEvent.action == MotionEvent.ACTION_UP) {
                when (it) {
                    false -> mActiveRelease()
                    true -> mInactiveRelease()
                }
                if (mButtonIsActive) {
                    try {
                        mListener?.onCustomButtonClick(nView)
                    } catch (e: Exception) {
                        Log.d("CUSTOM_BUTTON", e.message)
                    }
                }
//TODO : ACtiunea de cancel ca la customboximagetext
                return true
            }
        }
        return false
    }

    private fun mActiveTouch() {
        nButton.background = mColorHoverDrawable
        nShadow.background = mColorShadowDrawable
        nShadow.visibility = View.GONE
    }

    protected fun mActiveRelease() {
        nButton.background = mColorActiveDrawable
        nShadow.background = mColorShadowDrawable
        nShadow.visibility = View.VISIBLE
    }

    private fun mInactiveTouch() {
        nButton.background = mDisableColorShadowDrawable
        nShadow.background = mDisableColorActiveDrawable
        nShadow.visibility = View.GONE
    }

    protected fun mInactiveRelease() {
        nButton.background = mDisableColorActiveDrawable
        nShadow.background = mDisableColorShadowDrawable
        nShadow.visibility = View.VISIBLE
    }
}
