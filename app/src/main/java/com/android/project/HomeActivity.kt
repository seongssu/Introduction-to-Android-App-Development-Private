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
        val edit_textid =findViewById<EditText>(R.id.editTextId1_3)
        val edit_textname = findViewById<EditText>(R.id.editTextName3_3)
        edit_textid.setText(id)
        edit_textname.setText(name)
        val editText_age = findViewById<EditText>(R.id.editTextAge4_3)
        val editText_mbti = findViewById<EditText>(R.id.editTextMbti5_3)


        val btn_callexit = findViewById<Button>(R.id.btnlogin3_3)
        btn_callexit.setOnClickListener {
            val age = editText_age.text.toString()
            val mbti = editText_mbti.text.toString()

            editText_age.setText(age)
            editText_mbti.setText(mbti)


            finish()
        }
    }
}