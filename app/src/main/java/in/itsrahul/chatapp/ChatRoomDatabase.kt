package `in`.itsrahul.chatapp

import `in`.itsrahul.chatapp.model.Chat
import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = arrayOf(Chat::class), version = 1, exportSchema = false)
public abstract class ChatRoomDatabase : androidx.room.RoomDatabase() {

    abstract fun getChatDao(): ChatDao


    companion object{
        @Volatile
        private var INSTANCE : ChatRoomDatabase? = null

        fun getDatabase(context:Context): ChatRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatRoomDatabase::class.java,
                    "chat_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }


        }

    }
}