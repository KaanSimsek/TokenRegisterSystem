package com.example.tokenregistrationsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tokenregistrationsystem.databinding.ActivityAdminBinding


class AdminActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val i = this.intent
        var arr=ArrayList<Bank>()
        binding=ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addUser.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
        binding.DeleteUser.setOnClickListener {
            val intent = Intent(this, DeleteUserActivity::class.java)
            startActivity(intent)
        }
        binding.ListUsers.setOnClickListener {
            val intent = Intent(this, listUsersActivity::class.java)
            startActivity(intent)
        }
        binding.addBankBtn.setOnClickListener {
            val intent =  Intent(this, addBankToUser::class.java)
            startActivity(intent)
        }
        binding.removeBankBtn.setOnClickListener {
            val intent = Intent(this,deleteBankFromUser::class.java)
            startActivity(intent)
        }
        binding.ActiveDeactiveBanks.setOnClickListener {
            val intent = Intent(this,ActiveDeactiveBanksActivity::class.java)
            startActivity(intent)
        }
    }

}