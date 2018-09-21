package personalstylerkotlinlibrary.bejancorneliu.com.pskotlinlib.databases

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "platform")
data class Platform(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "uid")
        var uid: Int = 0,

        @ColumnInfo(name = "id")
        var id: String = "",

        @ColumnInfo(name = "name")
        var name: String = "",

        @ColumnInfo(name = "type")
        var type: String = ""
)