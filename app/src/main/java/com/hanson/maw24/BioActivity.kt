package com.hanson.maw24

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BioActivity : AppCompatActivity() {


    private lateinit var editTextName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        editTextName = findViewById<TextView>(R.id.nameTextView)
        loadName()

    }


    private fun loadName() {
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name_key", null)
        name?.let {
            editTextName.setText(it)
            editTextName.isEnabled = false
        }
    }

}