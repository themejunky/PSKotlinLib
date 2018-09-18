package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools

import android.content.res.TypedArray
import android.widget.Spinner
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.customViews.customSpinner.CustomSpinnerAdapter
import personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model.Item
import java.security.MessageDigest
import java.util.regex.Pattern

inline fun TypedArray.use(block: (TypedArray) -> Unit) {
    try {
        block(this)
    } finally {
        recycle()
    }
}

fun String.isValidEmail(): Boolean {
    val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun String.isValidPassword(): Boolean {
    return this.length > 5
}

fun String.isValid3Lenght(): Boolean {
    return this.length >= 3
}

fun String.isValid5Lenght(): Boolean {
    return this.length >= 5
}

fun String.isValidPhone(): Boolean {
    return this.length == 10
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}

fun Spinner.setSpinnerEntries(entries: List<Item>?) {
    if (entries != null) {
        adapter = CustomSpinnerAdapter(context,entries, "left",false)
    }
}