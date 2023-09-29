package com.example.travelwithmee.Modelclass

import android.net.Uri

class AddDataModelclass {
    var Place : String = " "
    var email : String = " "
    var city : String = " "
    var rate : String = " "
    var price : String = " "
    var phone : String = " "
    var day : String = " "
    var description : String = " "
    var key : String = " "
    var Imageuri : String = " "
    var Like : Int = 0

    constructor(){

    }

    constructor(Place:String,city:String,Phone:String,Email:String,price:String,Description:String,day:String,rate:String,key:String,Imageuri: Uri,Like : Int){

        this.Place=Place
        this.city=city
        this.email=Email
        this.phone=Phone
        this.price=price
        this.rate=rate
        this.day=day
        this.description=Description
        this.key=key
        this.Imageuri=Imageuri.toString()
    }
}