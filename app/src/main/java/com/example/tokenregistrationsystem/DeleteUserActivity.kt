package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.tokenregistrationsystem.databinding.ActivityDeleteUserBinding

class DeleteUserActivity : AppCompatActivity() {
    val context=this
    var db=DataBaseHelper(context)
    private lateinit var binding: ActivityDeleteUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_user)
        //terminalIdText=findViewById(R.id.deleteWithTerminalET)
        binding=ActivityDeleteUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backFromDeleteUser.setOnClickListener {
            val intent = Intent(context,AdminActivity::class.java)
            startActivity(intent)
        }

        binding.deleteUserBtn.setOnClickListener {
            var bol =db.deleteData(binding.deleteWithTerminalET.text.toString())
            if(!bol){
                Toast.makeText(context,"There is no merchant whith this terminal id",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
            }
        }
    }

    /*fun deleteUserClick(view: View) {
        var bol =db.deleteData(terminalIdText.text.toString())
        if(!bol){
            Toast.makeText(context,"There is no merchant whith this terminal id",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
        }
    }*/
}