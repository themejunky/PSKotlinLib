package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions

import android.content.res.TypedArray
import java.security.MessageDigest

fun TypedArray.use(block: (TypedArray) -> Unit) {
    try {
        block(this)
    } finally {
        recycle()
    }
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}