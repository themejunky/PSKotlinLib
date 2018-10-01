package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.customImageGallery
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs.ManageImage
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs.UploadInfo
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageText.customImageText
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner

class MainActivity : AppCompatActivity(), CustomInput.CustomInputInterface, CustomButton.CustomButtonInterface, CustomSpinner.CustomSpinnerInterface, ManageImage.ChooseManageImage, customImageText.CustomImageTextInterface {
    override fun onCustomBoxImageTextChange(mTag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //adasdasasdasd

    override fun onDeleteImageFromGallery(nPosition: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onEditImageFromGallery(nPosition: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCustomInputChange(view: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCustomSpinnerChange(view: String) {
        Log.d("spinner", "11 : " + System.currentTimeMillis() + "/" + view)
    }

    override fun onCustomButtonClick(view: View) {
        Log.d("asdadadsd", "1 : " + System.currentTimeMillis())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dsada = UploadInfo(this)
        dsada.refresh()
        dsada.setInfo("ceva")

//        mAddService.setListener(this)

        nCeva.addView(customImageGallery(this,0,this).setImage("https://image.slidesharecdn.com/androiddevelopmentwithkotlinpart2-internetservicesandjson-180205080930/95/android-development-with-kotlin-part-2-internet-services-and-json-31-638.jpg?cb=1517818354"))

//        val valori: ArrayList<Item> = ArrayList()
//        valori.add(Item(nId = "1", nValue = "Email1"))
//        valori.add(Item(nId = "2", nValue = "Email2"))
//        valori.add(Item(nId = "3", nValue = "Email3"))
//        valori.add(Item(nId = "4", nValue = "Email4"))
//
//
//        mCategory.getSpinner().adapter = CustomSpinnerAdapter(this, valori, "left", false)
//        mCategory.setListener(this)

//        mEmail.setListener(this)
//        mEmail.triggerError()
        //mInput.triggerError()

          //  nIc.setActivationState(true)

       // dasdasdas.setListener(this)
    }
}
