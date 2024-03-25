package com.hanson.maw24.adapters
import com.hanson.maw24.R
import com.hanson.maw24.models.ChatUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<ChatUser>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //TODO: STEP1: LINK THE CHAT_ITEM VIEW  TO THIS ADAPTER
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return UserViewHolder(itemView)
    }
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //TODO: STEP2: HAVING LINKED THE CHAT_ITEM WE FND THE VIEWS-> textviews
        val textViewName: TextView = itemView.findViewById(R.id.text_view_name)
        val textViewAge: TextView = itemView.findViewById(R.id.text_view_age)
        val textMessage: TextView = itemView.findViewById(R.id.messageTextView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //TODO: STEP3: Once we have the ids of textviews, we link them to the ChatUser variables
        val currentItem = userList[position]
        holder.textViewName.text = currentItem.name
        holder.textViewAge.text = currentItem.age.toString()
        holder.textMessage.text = currentItem.message
    }

    override fun getItemCount() = userList.size

}
