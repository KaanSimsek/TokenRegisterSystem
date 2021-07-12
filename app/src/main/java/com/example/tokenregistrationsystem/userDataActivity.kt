package com.example.tokenregistrationsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tokenregistrationsystem.databinding.ActivityUserDataBinding

class userDataActivity : AppCompatActivity() {
    val context=this
    var db=DataBaseHelper(context)
    private lateinit var binding: ActivityUserDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        binding=ActivityUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent= getIntent()

        var pass=intent.getStringExtra("password")
        var id=intent.getStringExtra("id")

        var array=db.returnListOfUserData(id!!, pass!!)

        var array1=ArrayList<String>()
        var array2=ArrayList<String>()

        array1.add(array.get(0))
        array1.add(array.get(1))
        array1.add(array.get(2))
        array1.add(array.get(3))
        array1.add(array.get(4))
        array1.add(array.get(5))
        array1.add(array.get(6))

        array2.add(array.get(7))
        array2.add(array.get(8))

        val adapter1 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array1)
        val adapter2 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array2)

        binding.listForUser.adapter=adapter1
        binding.userBankList.adapter=adapter2


    }
}