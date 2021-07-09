package com.example.tokenregistrationsystem

class Merchant {
    lateinit var name : String
    lateinit var password : String
    lateinit var terminalID : String
    lateinit var trID : String
    lateinit var deviceType : String
    lateinit var registerDate : String
    lateinit var id : String

    constructor(name:String,password:String,terminalID : String,trID : String,deviceType : String,registerDate : String ){
        this.name=name
        this.password=password
        this.terminalID=terminalID
        this.trID=trID
        this.deviceType=deviceType
        this.registerDate=registerDate
    }
    constructor(){

    }

}