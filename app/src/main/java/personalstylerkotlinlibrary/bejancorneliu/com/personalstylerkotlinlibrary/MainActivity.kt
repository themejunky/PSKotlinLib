package personalstylerkotlinlibrary.bejancorneliu.com.personalstylerkotlinlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_LEFT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.ROW_RIGHT
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valori : ArrayList<Item> = ArrayList()
        valori.add(Item("1","Email1"))
        valori.add(Item("2","Email2"))
        valori.add(Item("3","Email3"))
        valori.add(Item("4","Email4"))
        nNewSpinner.setSpinner(valori, ROW_LEFT,false)

        nNewSpinner.setSpinnerPositionById("2")

    }
}
