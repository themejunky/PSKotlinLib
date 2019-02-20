package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageGallery.dialogs.ManageImage
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customImageText.CustomImageText
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class MainActivity : AppCompatActivity(), CustomInput.CustomInputInterface, CustomButton.CustomButtonInterface, CustomSpinner.CustomSpinnerInterface, ManageImage.ChooseManageImage, CustomImageText.CustomImageTextInterface,  View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(this,"sdaas12345",Toast.LENGTH_SHORT).show()
    }

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


        val mOrderStartHour: MutableList<Item> = ArrayList(0)
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))
        mOrderStartHour.add(Item("1","1"))

        mAvailable.setSpinner(mOrderStartHour,"left",false)
    }


}
