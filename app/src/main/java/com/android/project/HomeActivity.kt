package com.android.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val strData = intent.getStringExtra("dataFromSignInActivity")
        val edit_id =findViewById<EditText>(R.id.edit_Text1)
        edit_id.setText(strData)
    }
}