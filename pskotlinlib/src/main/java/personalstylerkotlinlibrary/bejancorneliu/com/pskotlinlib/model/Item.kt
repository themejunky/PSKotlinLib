package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.model

class Item {
    var id: String = ""
    var value: String = ""

    constructor(nValue: String) {
        value = nValue
    }

    constructor(nId: String, nValue: String) {
        id = nId
        value = nValue
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(obj: Any?): Boolean {
        if (obj is Item) {
            val c = obj as Item?
            if (c!!.value == value && c.id === id) return true
        }

        return false
    }
}
