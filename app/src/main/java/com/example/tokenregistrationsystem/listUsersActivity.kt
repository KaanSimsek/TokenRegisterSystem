package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

class listUsersActivity : AppCompatActivity() {

    lateinit var listView :ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)
        listView=findViewById(R.id.usersList)
        val context=this
        var db=DataBaseHelper(context)
        val list:MutableList<Merchant> = db.readData()
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,userListToStringList(list))
        listView.adapter=adapter
    }

    fun backForList(view: View) {
        val intent = Intent(this,AdminActivity::class.java)
        startActivity(intent)
    }

    fun userListToStringList(list: MutableList<Merchant>):ArrayList<String>{
        var arr:ArrayList<String> = ArrayList()
        for (i in 0..list.size-1){
            var str=""
            str += list.get(i).id +"."+
                    list.get(i).name+"  "+
                    list.get(i).password + "  " +
                    list.get(i).terminalID + "  " +
                    list.get(i).deviceType + "  " +
                    list.get(i).trID + "  " +
                    list.get(i).registerDate
            arr.add(str)

        }
        return arr
    }
}