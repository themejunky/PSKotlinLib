package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.extensions

import java.util.regex.Pattern

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
