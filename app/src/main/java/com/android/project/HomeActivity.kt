package com.android.project

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    val imageList = arrayOf(
        R.drawable.z1,
        R.drawable.z2,
        R.drawable.z3,
        R.drawable.z4,
        R.drawable.z5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val id = getData("dataFromSignInActivityId")
        val name = getData("dataFromSignInActivityName")
        val age = getData("dataFromSignInActivityAge")
        val mbti = getData("dataFromSignInActivityMbti")
        val edit_textid = findViewById<EditText>(R.id.editTextId1_3)
        val edit_textname = findViewById<EditText>(R.id.editTextName3_3)
        val edit_Text_age = findViewById<EditText>(R.id.editTextAge4_3)
        val edit_Text_mbti = findViewById<EditText>(R.id.editTextMbti5_3)
        val edit_imageView = findViewById<ImageView>(R.id.img)

        edit_textid.setText(id)
        edit_textname.setText(name)
        edit_Text_age.setText(age)
        edit_Text_mbti.setText(mbti)
        val randomNumber = Random.nextInt(0 , 5)
        edit_imageView.setImageResource(imageList[randomNumber])



        val btn_callexit = findViewById<Button>(R.id.btnlogin3_3)
        btn_callexit.setOnClickListener {
            finish()
        }
    }

    private fun getData(key: String): String? {
        val sharedPreferences = getSharedPreferences("my_shared_prefs", MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }
}

