package com.example.tokenregistrationsystem

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.ArrayList


val database_name="DataBaseForApp"
val user_table="Users"
val col_id="ID"
val col_name="Name"
val col_password="Password"
val col_TerminalId="TerminalID"
val col_DeviceType="DeviceType"
val col_trID="TrID"
val col_registerDate="RegisterDate"

class DataBaseHelper(var context: Context):SQLiteOpenHelper(context, database_name,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = " CREATE TABLE " + user_table + "(" +
                col_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                col_name + " VARCHAR(256)," +
                col_password + " VARCHAR(256)," +
                col_TerminalId + " VARCHAR(256)," +
                col_DeviceType + " VARCHAR(256)," +
                col_trID + " VARCHAR(256)," +
                col_registerDate + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insertData(user:Merchant){
        val db=this.writableDatabase
        val cv= ContentValues()
        cv.put(col_name,user.name)
        cv.put(col_password,user.password)
        cv.put(col_TerminalId,user.terminalID)
        cv.put(col_DeviceType,user.deviceType)
        cv.put(col_trID,user.trID)
        cv.put(col_registerDate,user.registerDate)
        var result=db.insert(user_table,null,cv)
        if(result==(1).toLong()){
            Toast.makeText(context,"Unsuccess", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
        }
        db.close()
    }
    fun readData(): MutableList<Merchant> {
        var listOfTable : MutableList<Merchant> = ArrayList()
        val db = this.readableDatabase
        var question = "Select * from " + user_table
        var res = db.rawQuery(question,null)
        if(res.moveToFirst()){
            do {
                var merchant = Merchant()
                merchant.id = res.getString(res.getColumnIndex(col_id))
                merchant.name=res.getString(res.getColumnIndex(col_name))
                merchant.password=res.getString(res.getColumnIndex(col_password))
                merchant.terminalID=res.getString(res.getColumnIndex(col_TerminalId))
                merchant.deviceType=res.getString(res.getColumnIndex(col_DeviceType))
                merchant.trID=res.getString(res.getColumnIndex(col_trID))
                merchant.registerDate=res.getString(res.getColumnIndex(col_registerDate))
                listOfTable.add(merchant)
            }while (res.moveToNext())
        }
        res.close()
        db.close()
        return listOfTable
    }
    fun deleteData(terminalID : String):Boolean{
        var db = this.writableDatabase
        val success= db.delete(user_table, col_TerminalId + "=?", arrayOf(terminalID))
        db.close()
        return Integer.parseInt("$success")!=-1
    }
}