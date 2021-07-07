package com.example.tokenregistrationsystem

class Merchant {
    lateinit var name : String
    lateinit var password : String
    var id : Int = 0

    constructor(name:String,password:String){
        this.name=name
        this.password=password
    }

}