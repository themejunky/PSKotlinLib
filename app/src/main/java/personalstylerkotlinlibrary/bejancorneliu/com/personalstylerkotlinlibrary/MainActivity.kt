package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.adapter.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class MainActivity : AppCompatActivity(), CustomInput.CustomInputInterface, CustomButton.CustomButtonInterface, CustomSpinner.CustomSpinnerInterface {
    override fun onCustomSpinnerChange(view: String) {
        Log.d("spinner", "11 : " + System.currentTimeMillis() + "/" + view)
    }

    override fun onCustomButtonClick(view: View) {
        Log.d("asdadadsd", "1 : " + System.currentTimeMillis())
    }

    override fun onCustomInputChange() {
        Log.d("spinner", "1 : " + System.currentTimeMillis())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valori: ArrayList<Item> = ArrayList()
        valori.add(Item(nId = "1", nValue = "Email1"))
        valori.add(Item(nId = "2", nValue = "Email2"))
        valori.add(Item(nId = "3", nValue = "Email3"))
        valori.add(Item(nId = "4", nValue = "Email4"))

        mCategory.getSpinner().adapter = CustomSpinnerAdapter(this, valori, "left", false)
        mCategory.setListener(this)

//        mEmail.setListener(this)
//        mEmail.triggerError()
        //mInput.triggerError()

          //  nIc.setActivationState(true)

       // dasdasdas.setListener(this)
    }
}
