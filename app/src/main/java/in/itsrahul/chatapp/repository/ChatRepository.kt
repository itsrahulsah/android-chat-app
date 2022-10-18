package `in`.itsrahul.chatapp.repository

import `in`.itsrahul.chatapp.ChatDao
import `in`.itsrahul.chatapp.model.Chat
import androidx.lifecycle.LiveData
import androidx.room.Dao

class ChatRepository(private  val chatDao : ChatDao) {

    val allChats : LiveData<List<Chat>> = chatDao.getAllChats()
    suspend fun insert(chat: Chat){
        chatDao.insert(chat)
    }

}