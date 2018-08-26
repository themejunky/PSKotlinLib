package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.lib_custom_button.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView

const val ACTIVE_BUTTON = "active"
const val INACTIVE_BUTTON = "inactive"

open class CustomButtonBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {

    var mButtonValidation : Boolean = false

    var mActiveBackgroundDrawable : GradientDrawable = GradientDrawable()
    var mActiveShadowDrawable : GradientDrawable = GradientDrawable()
    var mInactiveBackgroundDrawable : GradientDrawable = GradientDrawable()
    var mInactiveShadowDrawable : GradientDrawable = GradientDrawable()
    lateinit var mListener : CustomButton.Custom_Button_Interface

    override fun onTouch(p0: View, p1: MotionEvent): Boolean {
            mButtonValidation.let {
                if (p1.action==MotionEvent.ACTION_DOWN) {
                    when(it) {
                        false -> mActiveTouch()
                        true -> mInactiveTouch()
                    }
                    return true
                }
                else if (p1.action==MotionEvent.ACTION_UP) {
                    when(it) {
                        false -> mActiveRelease()
                        true -> mInactiveRelease()
                    }

                    try {
                        mListener.onCustomButtonClick(p0)
                    } catch (e : Exception) {
                        Log.d("CUSTOM_BUTTON",""+e.message)
                    }


                    return true
                }
            }



        return false
    }

    private fun mActiveTouch() {
        nButton.background = mActiveShadowDrawable;
        nShadow.background = mActiveBackgroundDrawable
        nShadow.visibility=View.GONE
    }

    protected fun mActiveRelease() {
        nButton.background = mActiveBackgroundDrawable;
        nShadow.background = mActiveShadowDrawable
        nShadow.visibility=View.VISIBLE
    }

    private fun mInactiveTouch() {
        nButton.background = mInactiveShadowDrawable;
        nShadow.background = mInactiveBackgroundDrawable
        nShadow.visibility=View.GONE
    }

    protected fun mInactiveRelease() {
        nButton.background = mInactiveBackgroundDrawable;
        nShadow.background = mInactiveShadowDrawable
        nShadow.visibility=View.VISIBLE
    }
}
