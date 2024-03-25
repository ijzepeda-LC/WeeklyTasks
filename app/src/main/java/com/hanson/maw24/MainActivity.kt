package com.hanson.maw24

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // To use outside the function
    private lateinit var chatButton: Button
    private lateinit var editTextName: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonEdit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ############## USER NAME
        editTextName = findViewById(R.id.username)
        buttonSave = findViewById(R.id.saveButton)
        buttonEdit = findViewById(R.id.editButton)
        buttonEdit.visibility = View.GONE

        loadName()
        buttonSave.setOnClickListener {
            saveName()
        }

        buttonEdit.setOnClickListener {
            //Swap Visibility
            // TODO: It is already in load()
            editTextName.isEnabled = true
            buttonSave.visibility = View.VISIBLE
            buttonEdit.visibility = View.GONE
        }



        //################## TASK 1
        var value_from_main_activity  = "1234ABC"
        var task1Button = findViewById<Button>(R.id.task1Button)

        task1Button.setOnClickListener{
            var task1intent = Intent(this, Task1Activity::class.java)
            task1intent.putExtra("value_to_send_from_main_activity",value_from_main_activity)
            startActivity(task1intent)
        }

        //################## Bio
        var bioButton = findViewById<Button>(R.id.bioButton)

        bioButton.setOnClickListener{
            var bioIntent = Intent(this, BioActivity::class.java)
            startActivity(bioIntent)
        }



        //################## CHAT
        chatButton = findViewById<Button>(R.id.chat_button)
        chatButton.setOnClickListener{
            var intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }



    }

    private fun saveName() {
        val name = editTextName.text.toString()
        if (name.isNotEmpty()) {
            //Save info to sharedpreferences
            val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name_key", name)
            editor.apply()
            // swap visibility
            editTextName.isEnabled = false
            buttonSave.visibility = View.GONE
            buttonEdit.visibility = View.VISIBLE
            // Make Toast
            var toast = Toast.makeText(this, ("Hello $name"),Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    private fun loadName() {
        // load info from shared preferences
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name_key", null)
        name?.let {
            editTextName.setText(it)
            //Swap Visibility
            editTextName.isEnabled = false
            buttonSave.visibility = View.GONE
            buttonEdit.visibility = View.VISIBLE
        }
    }




}