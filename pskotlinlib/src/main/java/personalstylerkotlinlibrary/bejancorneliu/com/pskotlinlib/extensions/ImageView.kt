package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrlPicture(mUrl: String) {
    Glide.with(context).load(mUrl).into(this)
}