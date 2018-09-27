package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.lib_custom_image_gallery.view.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.R
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs.ManageImage

class customImageGallery(context: Context, private val nPosition : Int, private val nListener : ManageImage.ChooseManageImage) : customImageGalleryBase(context), View.OnClickListener {

    init {
        inflate(context, R.layout.lib_custom_image_gallery, this)

        mContainer.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        ManageImage(context,nPosition,nListener)
    }

    fun setImage(nUrl : String) {
        Glide.with(context).load(nUrl).into(mImage)
    }
}