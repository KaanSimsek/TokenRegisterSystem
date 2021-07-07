package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast


class AddUserActivity : AppCompatActivity() {
    lateinit var userName : EditText
    lateinit var userPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)
        userName = findViewById<EditText>(R.id.userName)
        userPassword = findViewById<EditText>(R.id.userPassword)
    }

    fun AddUserOnClick(view: View) {
        Toast.makeText(this, userName.text.toString() +" "+userPassword.text.toString(), Toast.LENGTH_SHORT).show()
    }

    fun BackFromAddOnClick(view: View) {
        val intent = Intent(this,AdminActivity::class.java)
        startActivity(intent)
    }
}