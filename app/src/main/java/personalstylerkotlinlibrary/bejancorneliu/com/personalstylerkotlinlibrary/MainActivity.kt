package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases.Cities

class MainActivity : AppCompatActivity(), CustomInput.CustomInputInterface, CustomButton.CustomButtonInterface, CustomSpinner.Custom_Spinner_Interface {
    override fun onCustomSpinnerChange() {
        Log.d("spinner","1 : "+System.currentTimeMillis())
    }

    override fun onCustomButtonClick(view: View) {
        Log.d("buton_apas", "1 : " + System.currentTimeMillis())
    }

    override fun onCustomInputChange() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valori : ArrayList<Cities> = ArrayList()
        valori.add(Cities(id="1",name ="Email1"))
        valori.add(Cities(id="2",name ="Email2"))
        valori.add(Cities(id="3",name ="Email3"))
        valori.add(Cities(id="4",name ="Email4"))

        mCity.getSpinner().adapter =  CustomSpinnerAdapter(this,valori, "left",false)

        mCity.setListener(this)

        //mInput.triggerError()

          //  nIc.setActivationState(true)

       // dasdasdas.setListener(this)
    }
}
