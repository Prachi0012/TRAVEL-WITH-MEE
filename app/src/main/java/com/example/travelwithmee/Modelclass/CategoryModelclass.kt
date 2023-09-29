package com.example.travelwithmee.Modelclass

import android.net.Uri

class CategoryModelclass {
    var Place : String = " "
    var people : String = " "
    var city : String = " "
    var price : String = " "
    var description : String = " "
    var key : String = " "
    var Imageuri : String = " "
    var Like : Int=0
    constructor(){

    }
    constructor(place: String, city: String, description: String, price: String, people: String,
                key: String, imageuri: Uri,Like : Int){
        this.Place=place
        this.city=city
        this.description=description
        this.price=price
        this.people=people
        this.key=key
        this.Imageuri=imageuri.toString()
        this.Like=Like
    }
}