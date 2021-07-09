package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class DeleteUserActivity : AppCompatActivity() {
    lateinit var terminalIdText : EditText
    val context=this
    var db=DataBaseHelper(context)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_user)
        terminalIdText=findViewById(R.id.deleteWithTerminalET)
    }

    fun backFromDelete(view: View) {
        val intent = Intent(context,AdminActivity::class.java)
        startActivity(intent)
    }
    fun deleteUserClick(view: View) {
        var bol =db.deleteData(terminalIdText.text.toString())
        if(!bol){
            Toast.makeText(context,"There is no merchant whith this terminal id",Toast.LENGTH_LONG).show()
        }
    }
}