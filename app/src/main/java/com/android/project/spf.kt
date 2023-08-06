package com.android.project

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

object spf{
     fun saveData(context: Context, key: String, value:String) {
        val sharedPreferences = context.getSharedPreferences("spf",
            AppCompatActivity.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getData(context:Context,key: String):String? {
        val sharedPreferences = context.getSharedPreferences("spf",
            AppCompatActivity.MODE_PRIVATE
        )
        return sharedPreferences.getString(key, null)
    }
}