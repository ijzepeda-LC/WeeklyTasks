package com.hanson.maw24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Task1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        var name =  intent.getStringExtra("value_to_send_from_main_activity")


        val toast = Toast.makeText(this, ("Welcome"+name.toString()), Toast.LENGTH_LONG) // in Activity
        toast.show()

    }
}