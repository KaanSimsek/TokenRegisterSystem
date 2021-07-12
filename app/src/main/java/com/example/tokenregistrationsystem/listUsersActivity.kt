package com.example.tokenregistrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tokenregistrationsystem.databinding.ActivityListUsersBinding
import java.util.ArrayList

class listUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)
        binding=ActivityListUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context=this
        var db=DataBaseHelper(context)
        val list:MutableList<Merchant> = db.readData()
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,userListToStringList(list))

        binding.usersList.adapter=adapter

        binding.backButtonForList.setOnClickListener {
            val intent = Intent(this,AdminActivity::class.java)
            startActivity(intent)
        }


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