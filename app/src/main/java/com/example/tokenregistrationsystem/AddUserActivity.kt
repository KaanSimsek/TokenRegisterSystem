package com.example.tokenregistrationsystem

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


class AddUserActivity : AppCompatActivity() {
    lateinit var userName : EditText
    lateinit var userPassword : EditText
    lateinit var userTerminalID : EditText
    lateinit var userTC : EditText
    val specialChars= ArrayList<Char>()
    val context=this
    var db=DataBaseHelper(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)
        userName = findViewById<EditText>(R.id.userName)
        userPassword = findViewById<EditText>(R.id.userPassword)
        userTerminalID = findViewById<EditText>(R.id.userTerminalID)
        userTC = findViewById<EditText>(R.id.userTC)
    }

    fun AddUserOnClick(view: View) {
        //Toast.makeText(this, userName.text.toString() +" "+userPassword.text.toString(), Toast.LENGTH_SHORT).show()
        var nameOfUser = userName.text.toString()
        var passwordOfUser = userPassword.text.toString()
        var terminalIDOfUser = userTerminalID.text.toString()
        var tcOfUser = userTC.text.toString()

        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val formatedDate = formatter.format(date)

        if(checkPassword(passwordOfUser) && checkTerminal(terminalIDOfUser) && !checkDeviceType(terminalIDOfUser).equals("False") && nameOfUser.length!=0 && tcOfUser.length!=0){
            var merchant = Merchant(nameOfUser,passwordOfUser,terminalIDOfUser,tcOfUser,checkDeviceType(terminalIDOfUser),formatedDate)
            db.insertData(merchant)
        }
        else{
            Toast.makeText(applicationContext,"Unsuccess",Toast.LENGTH_LONG).show()
        }
    }

    fun BackFromAddOnClick(view: View) {
        val intent = Intent(this,AdminActivity::class.java)
        startActivity(intent)
    }

    fun checkPassword(password : String):Boolean{
        specialCharInit()
        if(password.length<=18 && password.length>=6){
            var upper=0
            var lower=0
            var number=0
            var special=0
            for (i in 0..password.length-1){
                if(password.get(i).isUpperCase())
                    upper=1
                else if(password.get(i).isLowerCase())
                    lower=1
                else if(password.get(i).isDigit())
                    number=1
                else if(specialChars.contains(password.get(i)))
                    special=1
            }
            return upper * lower * number * special==1
        }
        else
            return false
    }
    fun checkTerminal(id : String):Boolean{
        if(id.length==12){
            if(id.contains("AS"))
                return true
            else if(id.contains("AT"))
                return true
            else if(id.contains("AX"))
                return true
            else if(id.contains("AU"))
                return true
        }
        return false
    }
    fun checkDeviceType(id : String):String{
        if(id.contains("AS"))
            return "220TR"
        else if(id.contains("AT"))
            return "300TR"
        else if(id.contains("AX"))
            return "400TR"
        else if(id.contains("AU"))
            return "1000TR"
        return "False"
    }
    fun specialCharInit(){
        specialChars.add('.')
        specialChars.add(',')
        specialChars.add('-')
        specialChars.add('?')
        specialChars.add('_')
        specialChars.add('@')
        specialChars.add('>')
        specialChars.add('<')
        specialChars.add('|')
        specialChars.add(';')
        specialChars.add(':')
        specialChars.add('+')
        specialChars.add('*')
        specialChars.add('/')
        specialChars.add('~')
        specialChars.add('"')
        specialChars.add('é')
        specialChars.add('^')
        specialChars.add('#')
        specialChars.add('$')
        specialChars.add('(')
        specialChars.add(')')
        specialChars.add('[')
        specialChars.add(']')
        specialChars.add('{')
        specialChars.add('}')
        specialChars.add('=')
        specialChars.add('&')
        specialChars.add('´')
        specialChars.add('¨')
    }
}