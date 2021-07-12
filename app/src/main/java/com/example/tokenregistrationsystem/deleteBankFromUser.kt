package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokenregistrationsystem.databinding.ActivityAddBankToUserBinding
import com.example.tokenregistrationsystem.databinding.ActivityDeleteBankFromUserBinding

class deleteBankFromUser : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteBankFromUserBinding
    private lateinit var bankName : String
    private lateinit var bankID : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_bank_from_user)
        binding = ActivityDeleteBankFromUserBinding.inflate(layoutInflater)
        val context=this
        var db=DataBaseHelper(context)
        setContentView(binding.root)
        binding.buttonForDelBank.setOnClickListener {
            db.deleteBankToUser(binding.getTerminalIdOfUserDel.text.toString(),Bank(bankName,bankID))
        }
        binding.backFDeleteBank.setOnClickListener {
            var intent = Intent(this,AdminActivity::class.java)
            startActivity(intent)
        }
        binding.yapiKrediDelRadio.setOnClickListener {
            bankName = "Yapıkredi"
            bankID = "0"
        }
        binding.denizBankDelRadio.setOnClickListener {
            bankName = "DenizBank"
            bankID = "1"
        }
        binding.isBankasiDelRadio.setOnClickListener {
            bankName = "İşBankası"
            bankID = "2"
        }
        binding.vakifBankDelRadio.setOnClickListener {
            bankName = "VakıfBank"
            bankID = "3"
        }
    }
}