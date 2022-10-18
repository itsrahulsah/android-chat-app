package `in`.itsrahul.chatapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity(tableName = "chat_table")
 class Chat(@ColumnInfo(name="chat_text") val text:String,
            @ColumnInfo(name ="isSender") val isSender :Boolean ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int =0


}

