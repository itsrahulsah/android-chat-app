package `in`.itsrahul.chatapp

import `in`.itsrahul.chatapp.model.Chat
import `in`.itsrahul.chatapp.repository.ChatRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ChatViewModel(application: Application): AndroidViewModel(application) {
    val allChats:LiveData<List<Chat>>
    val repository : ChatRepository

    init{
        val dao = ChatRoomDatabase.getDatabase(application).getChatDao()
        repository = ChatRepository(dao)
        allChats = repository.allChats
    }

    fun sendMessage(chat:Chat) = viewModelScope.launch(Dispatchers.IO){
            repository.insert(chat)
    }
}