package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokenregistrationsystem.databinding.ActivityActiveDeactiveBanksBinding
import com.example.tokenregistrationsystem.databinding.ActivityDeleteBankFromUserBinding

class ActiveDeactiveBanksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActiveDeactiveBanksBinding
    private var bankNames = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active_deactive_banks)
        binding = ActivityActiveDeactiveBanksBinding.inflate(layoutInflater)
        val context=this
        var db=DataBaseHelper(context)
        setContentView(binding.root)



        binding.backFromActivateBank.setOnClickListener {
            var intent = Intent(this,AdminActivity::class.java)
            startActivity(intent)
        }

        binding.activateBankBtn.setOnClickListener {
            if(binding.yapikrediCheckBox.isChecked)
                bankNames.add("Yapıkredi")
            if (binding.denizBankCheckBox.isChecked)
                bankNames.add("DenizBank")
            if (binding.isBankasiCheckBox.isChecked)
                bankNames.add("İşBankası")
            if (binding.vakifBankCheckBox.isChecked)
                bankNames.add("VakıfBank")
            if(bankNames.size!=0)
                db.activateBanksOrDeactivateBanks(binding.takeTerminalIdActivateBank.text.toString(),bankNames,true)
        }

        binding.deActivateBankBtn.setOnClickListener {
            if(binding.yapikrediCheckBox.isChecked)
                bankNames.add("Yapıkredi")
            if (binding.denizBankCheckBox.isChecked)
                bankNames.add("DenizBank")
            if (binding.isBankasiCheckBox.isChecked)
                bankNames.add("İşBankası")
            if (binding.vakifBankCheckBox.isChecked)
                bankNames.add("VakıfBank")
            if(bankNames.size!=0)
                db.activateBanksOrDeactivateBanks(binding.takeTerminalIdActivateBank.text.toString(),bankNames,false)
        }
    }
}