package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.custom_button.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.BaseCustomView

const val ACTIVE_BUTTON = "active"
const val INACTIVE_BUTTON = "inactive"


open class CustomButtonBase(context: Context, attrs: AttributeSet) : BaseCustomView(context, attrs), View.OnTouchListener {

    var mActiveBackgroundDrawable : GradientDrawable = GradientDrawable()
    var mActiveShadowDrawable : GradientDrawable = GradientDrawable()
    var mInactiveBackgroundDrawable : GradientDrawable = GradientDrawable()
    var mInactiveShadowDrawable : GradientDrawable = GradientDrawable()

    override fun onTouch(p0: View, p1: MotionEvent): Boolean {
        if (p1.action==MotionEvent.ACTION_DOWN) {
            if (this.tag!=null) {
                when(this.tag) {
                    ACTIVE_BUTTON -> mActiveTouch()
                    INACTIVE_BUTTON -> mInactiveTouch()
                }
            }
        } else if (p1.action==MotionEvent.ACTION_UP) {
            if (this.tag!=null) {
                this.tag.let {
                    when(it) {
                        ACTIVE_BUTTON -> mActiveRelease()
                        INACTIVE_BUTTON -> mInactiveRelease()
                    }
                }

            }
        }
        return false
    }

    private fun mActiveTouch() {
        nButton.background = mActiveShadowDrawable;
        nShadow.background = mActiveBackgroundDrawable
        nShadow.visibility=View.GONE
    }

    private fun mActiveRelease() {
        nButton.background = mActiveBackgroundDrawable;
        nShadow.background = mActiveShadowDrawable
        nShadow.visibility=View.VISIBLE
    }

    private fun mInactiveTouch() {
        nButton.background = mInactiveShadowDrawable;
        nShadow.background = mInactiveBackgroundDrawable
        nShadow.visibility=View.GONE
    }

    private fun mInactiveRelease() {
        nButton.background = mInactiveBackgroundDrawable;
        nShadow.background = mInactiveShadowDrawable
        nShadow.visibility=View.VISIBLE
    }

}
