package com.android.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btn_calllognin =findViewById<Button>(R.id.btnlogin)
        btn_calllognin.setOnClickListener {
            val edit_id = findViewById<EditText>(R.id.editId)
            val edit_psw = findViewById<EditText>(R.id.editTextPassword)
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()
            val strData =edit_id.text.toString()
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("dataFromSignInActivity", strData)
            if(!id.isEmpty()&& !psw.isEmpty()){
                startActivity(intent)
                Toast.makeText(this,"로그인 되었습니다.",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
            }

        }
    }

}