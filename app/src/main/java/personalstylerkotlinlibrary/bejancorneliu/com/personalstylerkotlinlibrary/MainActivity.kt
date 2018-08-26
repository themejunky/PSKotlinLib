package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customInput.CustomInput
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_LEFT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_RIGHT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class MainActivity : AppCompatActivity(), CustomInput.Custom_Input_Interface {
    override fun onCustomInputChange() {
       Log.d("asdasdasdas","mod")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPassword.setListener(this)
        mPassword.isValid()
    }
}
