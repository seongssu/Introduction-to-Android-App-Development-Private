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
        val edit_id = findViewById<EditText>(R.id.editTextId1_1)
        val edit_psw = findViewById<EditText>(R.id.editTextPassword2_1)
        val btn_calllognin1_1 = findViewById<Button>(R.id.btnlogin1_1)
        btn_calllognin1_1.setOnClickListener {

            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()

            if (!id.isEmpty() && !psw.isEmpty()) {
                val intent1 = Intent(this, HomeActivity::class.java)
                val intent2_1_id = intent.getStringExtra("dataFromSignUpActivityId")
                val intent2_2_name = intent.getStringExtra("dataFromSignUpActivityName")
                val intent2_3_psw = intent.getStringExtra("dataFromSignUpActivityPsw")
                if(id == intent2_1_id && psw == intent2_3_psw){
                    startActivity(intent1)
                    intent1.putExtra("dataFromSignInActivityId",id)
                    intent1.putExtra("dataFromSignInActivityName",intent2_2_name)
                    edit_id.text.clear()
                    edit_psw.text.clear()
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "회원가입 부터 해주세요", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        val btn_calljoin2_1 = findViewById<Button>(R.id.btnjoin2_1)
        btn_calljoin2_1.setOnClickListener {
            val intent1 = Intent(this, SignUpActivity::class.java)
            startActivity(intent1)
            edit_id.text.clear()
            edit_psw.text.clear()
        }
    }
}