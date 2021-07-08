package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
    }

    fun registerUserOnClick(view: View) {
        val intent = Intent(this, AddUserActivity::class.java)
        startActivity(intent)

    }

    fun listUsers(view: View) {
        val intent = Intent(this,listUsersActivity::class.java)
        startActivity(intent)

    }

    fun deleteUser(view: View) {
        val intent = Intent(this,DeleteUserActivity::class.java)
        startActivity(intent)
    }

    fun addBankToUser(view: View) {}

    fun removeBankFromUser(view: View) {}

    fun activateOrDeactivateBanksFromUser(view: View) {}
}