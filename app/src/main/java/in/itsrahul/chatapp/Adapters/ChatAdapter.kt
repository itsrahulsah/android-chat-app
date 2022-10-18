package `in`.itsrahul.chatapp.Adapters

import `in`.itsrahul.chatapp.R
import `in`.itsrahul.chatapp.model.Chat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ChatAdapter : RecyclerView.Adapter<ViewHolder>() {
    private val SEND = 1
    private val RECIEVE = 2
    private val chatList = ArrayList<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == SEND){
            val view =  LayoutInflater.from(parent.context).inflate(R.layout.send_chat_item,parent,false)
            SendViewHolder(view)
        }else{
            val view =  LayoutInflater.from(parent.context).inflate(R.layout.recieve_chat_item,parent,false)
            RecieveViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList.get(position)
        if(holder.javaClass == SendViewHolder::class.java){
           val sendHolder = holder as SendViewHolder
            sendHolder.chatText.text = chat.text
        }else{
            val reciveHolder = holder as RecieveViewHolder
            reciveHolder.chatText.text = chat.text
        }

    }

    override fun getItemViewType(position: Int): Int {
        val currentChat = chatList[position]
        if(currentChat.isSender)
            return SEND

        return RECIEVE
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    fun updateChats(newList:List<Chat>){
        chatList.clear()
        chatList.addAll(newList)
        notifyDataSetChanged()
    }
    class SendViewHolder(itemView: View) :ViewHolder(itemView) {

        val chatText: TextView = itemView.findViewById(R.id.SendChatText);
    }
    class RecieveViewHolder(itemView: View) :ViewHolder(itemView){

        val chatText : TextView = itemView.findViewById(R.id.recieveChatText)
    }
}


