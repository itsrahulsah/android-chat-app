package `in`.itsrahul.chatapp

import `in`.itsrahul.chatapp.model.Chat
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChatDao {

    @Query("SELECT * FROM chat_table ORDER BY id ASC")
     fun getAllChats():LiveData<List<Chat>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(chat:Chat)
}