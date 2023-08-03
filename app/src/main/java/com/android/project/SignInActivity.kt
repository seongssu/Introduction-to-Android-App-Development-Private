package com.android.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btn_calllognin =findViewById<Button>(R.id.btnlogin)
        btn_calllognin.setOnClickListener {
            val edit_id = findViewById<EditText>(R.id.editId)
            val strData =edit_id.text.toString()
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("dataFromSignInActivity", strData)
            startActivity(intent)
        }
    }
}