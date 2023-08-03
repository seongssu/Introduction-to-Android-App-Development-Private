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

        var btn_calllognin =findViewById<Button>(R.id.btnlogin)
        btn_calllognin.setOnClickListener {
            var edit_id = findViewById<EditText>(R.id.editTextText1)
            var strData =edit_id.text.toString()
            var intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("dataFromSignInActivity", strData)
            startActivity(intent)
        }
    }
}