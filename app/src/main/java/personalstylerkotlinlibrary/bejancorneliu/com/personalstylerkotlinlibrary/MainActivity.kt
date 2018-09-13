package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customButton.CustomButton
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_LEFT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_RIGHT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class MainActivity : AppCompatActivity(), CustomInput.Custom_Input_Interface, CustomButton.Custom_Button_Interface {
    override fun onCustomButtonClick(view: View) {
        Log.d("buton_apas","1 : "+System.currentTimeMillis());
    }

    override fun onCustomInputChange() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  nIc.setActivationState(true)

       // dasdasdas.setListener(this)
    }
}
