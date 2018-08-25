package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.tools

import android.content.res.TypedArray

inline fun TypedArray.use(block: (TypedArray) -> Unit) {
    try {
        block(this)
    } finally {
        recycle()
    }
}