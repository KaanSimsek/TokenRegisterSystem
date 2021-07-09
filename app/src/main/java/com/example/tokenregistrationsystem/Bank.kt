package com.example.tokenregistrationsystem

class Bank {
    lateinit var bankID : String
    lateinit var bankName: String
    var mode : Boolean = false

    constructor(bankName : String, bankID : String){
        this.bankID=bankID
        this.bankName=bankName
    }

    constructor(){

    }

}