package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tokenregistrationsystem.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    val context=this
    var db=DataBaseHelper(context)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding=ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userModeEnter.setOnClickListener {
            var password=binding.userPasswordUserMode.text.toString()
            var id=binding.userIdUserMode.text.toString()
            if(db.checkWhetherUserInDatabase(id,password)){
                var intent=Intent(context,userDataActivity::class.java)
                intent.putExtra("password",password)
                intent.putExtra("id",id)
                startActivity(intent)
            }
            else{
                Toast.makeText(context,"You are not registered",Toast.LENGTH_SHORT).show()
            }
        }
    }
}