package com.android.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewmodel.CreationExtras

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val edit_name2 = findViewById<EditText>(R.id.editTextName3_2)
        val edit_id2 = findViewById<EditText>(R.id.editTextId1_2)
        val edit_psw2 = findViewById<EditText>(R.id.editTextPassword2_2)
        val edit_age2 = findViewById<EditText>(R.id.editTextAge4_2)
        val edit_mbti2 = findViewById<EditText>(R.id.editTextMbti5_2)
        val button_calljoin2_2 = findViewById<Button>(R.id.btnjoin2_2)
        button_calljoin2_2.setOnClickListener {
            val name2 = edit_name2.text.toString()
            val id2 = edit_id2.text.toString()
            val psw2 = edit_psw2.text.toString()
            val age2 = edit_age2.text.toString()
            val mbti2 = edit_mbti2.text.toString()

            if (!name2.isEmpty() && !id2.isEmpty() && !psw2.isEmpty() && !age2.isEmpty()&& !mbti2.isEmpty()) {
                val intent2_1 = Intent(this, SignInActivity::class.java)
                intent2_1.putExtra("dataFromSignUpActivityName", name2)
                intent2_1.putExtra("dataFromSignUpActivityId", id2)
                intent2_1.putExtra("dataFromSignUpActivityPsw", psw2)
                intent2_1.putExtra("dataFromSignUpActivityAge", age2)
                intent2_1.putExtra("dataFromSignUpActivity",mbti2)
                setResult(RESULT_OK,intent2_1)
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }

        }
}}