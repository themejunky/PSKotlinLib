package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools

import android.content.res.TypedArray
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

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}