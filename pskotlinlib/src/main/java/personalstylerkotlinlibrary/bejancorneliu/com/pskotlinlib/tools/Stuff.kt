package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools

import android.app.Activity
import android.os.Environment
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
/**test*/
class Stuff() {
    @Throws(IOException::class)
    fun createImageFile(nActivity: Activity): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val nFile = File.createTempFile("IMG_" + timeStamp + "_", ".jpg", nActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
        nFile.deleteOnExit()
        return nFile
    }
}