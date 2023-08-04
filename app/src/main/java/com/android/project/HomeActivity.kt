package com.android.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("dataFromSignInActivityId")
        val name = intent.getStringExtra("dataFromSignInActivityName")
        val age = intent.getStringExtra("dataFromSignInActivityAge")
        val mbti = intent.getStringExtra("dataFromSignInActivityMbti")
        val edit_textid =findViewById<EditText>(R.id.editTextId1_3)
        val edit_textname = findViewById<EditText>(R.id.editTextName3_3)
        val edit_Text_age = findViewById<EditText>(R.id.editTextAge4_3)
        val edit_Text_mbti = findViewById<EditText>(R.id.editTextMbti5_3)
        edit_textid.setText(id)
        edit_textname.setText(name)
        edit_Text_age.setText(age)
        edit_Text_mbti.setText(mbti)


        val btn_callexit = findViewById<Button>(R.id.btnlogin3_3)
        btn_callexit.setOnClickListener {
            finish()
        }
    }
}