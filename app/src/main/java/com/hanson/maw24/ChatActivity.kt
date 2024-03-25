package com.hanson.maw24

import android.content.Context
import com.hanson.maw24.models.ChatUser
import com.hanson.maw24.adapters.UserAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ChatActivity : AppCompatActivity() {


    private lateinit var db: FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var localUserArrayList: ArrayList<ChatUser>
    private lateinit var userAdapter: UserAdapter
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var sendMessageButton = findViewById<Button>(R.id.send_button)
        messageEditText= findViewById(R.id.messageFieldEditText)
        recyclerView = findViewById(R.id.recyclerView)

        // RECYCLERVIEW
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        localUserArrayList = arrayListOf()
       //ADAPTER
        userAdapter = UserAdapter(localUserArrayList)
        recyclerView.adapter = userAdapter

        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance()

        //Load chats
        getChats()

        // button clicklistener
        sendMessageButton.setOnClickListener{
            if(messageEditText.text.toString()!="") {
                SendChat(db)
                getChats()
            }

        }


    }

    //TODO: Copy loadSharedPreferences
    private fun loadName(): String? {
        // load info from shared preferences
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name_key", null)
        return name
    }

    fun SendChat(db: FirebaseFirestore) {
        // TODO change username from SharedPrefs into John Doe
        var name=loadName()

        val user = ChatUser(name.toString(), 30, messageEditText.text.toString())
        messageEditText.setText("")


        db.collection("chats")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("Firebase", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firebase", "Error adding document", e)
            }
    }

    private fun getChats() {
        db.collection("chats")
            .get()
            .addOnSuccessListener { documents ->

                localUserArrayList.clear() // Clear the existing list
                for (document in documents) {
                    val localUser = document.toObject(ChatUser::class.java)
                    localUserArrayList.add(localUser)
                }
                userAdapter.notifyDataSetChanged()

            }
            .addOnFailureListener { exception ->
                Log.w("Firebase", "Error getting documents: ", exception)
            }
        userAdapter.notifyDataSetChanged()
    }
}