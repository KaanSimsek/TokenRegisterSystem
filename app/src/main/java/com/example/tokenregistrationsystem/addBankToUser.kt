package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.tokenregistrationsystem.databinding.ActivityAddBankToUserBinding
import com.example.tokenregistrationsystem.databinding.ActivityAddBankToUserBinding.*

class addBankToUser : AppCompatActivity() {
    private lateinit var binding: ActivityAddBankToUserBinding
    private lateinit var bankName: String
    private lateinit var bankID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bank_to_user)
        binding= ActivityAddBankToUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context=this
        var db=DataBaseHelper(context)
        binding.backFAddBank.setOnClickListener {
            val intent = Intent(this,AdminActivity::class.java)
            startActivity(intent)
        }
        binding.buttonForAddBank.setOnClickListener {
            db.addBankToUser(binding.getTerminalIdOfUser.text.toString(),Bank(bankName,bankID))
        }
        binding.yapiKrediAddRadio.setOnClickListener {
            bankName = "Yapıkredi"
            bankID = "0"
        }
        binding.denizBankAddRadio.setOnClickListener {
            bankName = "DenizBank"
            bankID = "1"
        }
        binding.isBankasiAddRadio.setOnClickListener {
            bankName = "İşBankası"
            bankID = "2"
        }
        binding.vakifBankAddRadio.setOnClickListener {
            bankName = "VakıfBank"
            bankID = "3"
        }
    }




}