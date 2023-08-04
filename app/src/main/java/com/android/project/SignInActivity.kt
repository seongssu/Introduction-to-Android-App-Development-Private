package com.android.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private var intent1_1_id: String? = null
    private var intent2_1_psw: String? = null
    private var intent3_1_name: String? = null
    private var intent4_1_age: String? = null
    private var intent5_1_mbti: String? = null
    lateinit var signInLauncher: ActivityResultLauncher<Intent>
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
                if (id == intent1_1_id && psw == intent2_1_psw) {
                    saveData("dataFromSignInActivityId", id)
                    saveData("dataFromSignInActivityName", intent3_1_name ?: "")
                    saveData("dataFromSignInActivityAge", intent4_1_age ?: "")
                    saveData("dataFromSignInActivityMbti", intent5_1_mbti ?: "")
                    val intent1 = Intent(this, HomeActivity::class.java)
                    startActivity(intent1)
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
            val intent2_1 = Intent(this, SignUpActivity::class.java)
            signInLauncher.launch(intent2_1)
        }
        signInLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    if (data != null) {
                        intent1_1_id = data.getStringExtra("dataFromSignUpActivityId")
                        intent2_1_psw = data.getStringExtra("dataFromSignUpActivityPsw")
                        intent3_1_name = data.getStringExtra("dataFromSignUpActivityName")
                        intent4_1_age = data.getStringExtra("dataFromSignUpActivityAge")
                        intent5_1_mbti = data.getStringExtra("dataFromSignUpActivity")
                    }
                }
            }
    }

    private fun saveData(key: String, value: String) {
        val sharedPreferences = getSharedPreferences("my_shared_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}

