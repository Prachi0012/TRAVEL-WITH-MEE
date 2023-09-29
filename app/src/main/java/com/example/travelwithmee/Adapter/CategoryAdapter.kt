package com.example.travelwithmee.Adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelwithmee.Activity.DesignationdetailAcitivity
import com.example.travelwithmee.Modelclass.CategoryModelclass
import com.example.travelwithmee.R

class CategoryAdapter (var designationdetailAcitivity: DesignationdetailAcitivity,
                          var list: ArrayList<CategoryModelclass>,var onItemclick : (Place:String,city:String,description:String,price:String,key:String,
                                                                                     Imageuri:String)->Unit
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: android.view.View) : RecyclerView.ViewHolder(itemView){

        var placename : TextView = itemView.findViewById(R.id.txtplacename)
        var placeimg : ImageView = itemView.findViewById(R.id.placeimg)
        var btnmore : CardView = itemView.findViewById(R.id.btnmore)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.MyViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.beach_item_file,parent,false)
        return MyViewHolder(View)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.placename.text = list[position].Place
        Glide.with(designationdetailAcitivity).load(list[position].Imageuri).into(holder.placeimg)


        holder.btnmore.setOnClickListener {
            onItemclick.invoke(
                list[position].Place,
                list[position].city,
                list[position].description,
                list[position].price,
                list[position].key,
                list[position].Imageuri

            )

        }




    }

    override fun getItemCount(): Int {
        return list.size
    }


}