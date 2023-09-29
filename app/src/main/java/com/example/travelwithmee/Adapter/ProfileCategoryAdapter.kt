package com.example.travelwithmee.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelwithmee.Fragment.HomeFragment
import com.example.travelwithmee.Modelclass.AddDataModelclass
import com.example.travelwithmee.R

class ProfileCategoryAdapter(var homefragment: HomeFragment, var list: ArrayList<AddDataModelclass>) :
    RecyclerView.Adapter<ProfileCategoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        var place : TextView = itemView.findViewById(R.id.txtPlaceName)
        var txtLocation : TextView = itemView.findViewById(R.id.txtLocation)
        var img : ImageView = itemView.findViewById(R.id.img)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileCategoryAdapter.MyViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.item_file,parent,false)
        return MyViewHolder(View)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.place.text = list[position].Place
        holder.txtLocation.text = list[position].city


        Glide.with(homefragment).load(list[position].Imageuri).into(holder.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun refresh(list : ArrayList<AddDataModelclass>)
    {
        this.list = list
        notifyDataSetChanged()

    }
}
