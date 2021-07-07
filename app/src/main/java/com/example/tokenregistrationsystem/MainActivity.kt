package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun adminClick(view: View) {
        val adminIntent = Intent(this,AdminActivity::class.java)
        startActivity(adminIntent)

    }
    fun userClick(view: View) {
        val userIntent = Intent(this,UserActivity::class.java)
        startActivity(userIntent)
    }
}