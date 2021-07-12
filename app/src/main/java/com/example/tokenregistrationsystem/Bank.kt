package com.example.tokenregistrationsystem

class Bank(bankName : String? = "", bankID : String? = "") {
    lateinit var bankID : String
    lateinit var bankName: String
    var mode : Boolean = false

    init {
        this.bankID= bankID!!
        this.bankName= bankName!!
    }
    /*constructor(bankName : String, bankID : String){
        this.bankID=bankID
        this.bankName=bankName
    }*/



}