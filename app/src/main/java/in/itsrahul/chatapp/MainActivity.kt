package `in`.itsrahul.chatapp

import `in`.itsrahul.chatapp.Adapters.ChatAdapter
import `in`.itsrahul.chatapp.databinding.ActivityMainBinding
import `in`.itsrahul.chatapp.model.Chat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
        private lateinit var binging : ActivityMainBinding
        private lateinit var viewModel: ChatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)

        val adapter  = ChatAdapter()
        val layoutManager =  LinearLayoutManager(this)
        val recyclerView = binging.recyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)

        viewModel.allChats.observe(this) {
            it?.let {
                adapter.updateChats(it)
                recyclerView.scrollToPosition(recyclerView.adapter?.itemCount?.minus(1) ?: 0 )
            }
        }


        binging.sendbtn.setOnClickListener { run { sendMessage() } }
        binging.recivebtn.setOnClickListener { run { recievMessage() } }
    }

    private fun recievMessage() {
        val message = binging.messageBox.text.toString()
        viewModel.sendMessage(Chat(message,false))
        val recyclerView = binging.recyclerView
        recyclerView.scrollToPosition(recyclerView.adapter?.itemCount?.minus(1) ?: 0 )
        binging.messageBox.setText("")
    }

    private fun sendMessage() {
        val message = binging.messageBox.text.toString()
        viewModel.sendMessage(Chat(message,true))
        val recyclerView = binging.recyclerView
        recyclerView.scrollToPosition(recyclerView.adapter?.itemCount?.minus(1) ?: 0 )
        binging.messageBox.setText("")
    }
}