package com.android.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("dataFromSignInActivityId")
        val name = intent.getStringExtra("dataFromSignInActivityName")
        val edit_textid =findViewById<EditText>(R.id.editTextId1_3)
        val edit_textname = findViewById<EditText>(R.id.editTextName3_3)
        edit_textid.setText(id)
        edit_textname.setText(name)
    }
}