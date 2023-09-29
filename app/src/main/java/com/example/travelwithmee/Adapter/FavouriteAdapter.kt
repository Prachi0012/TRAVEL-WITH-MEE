package com.example.travelwithmee.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelwithmee.Modelclass.CategoryModelclass
import com.example.travelwithmee.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FavouriteAdapter(var  context: Context?, var liked:((Int, String) -> Unit), var invoke:((CategoryModelclass) -> Unit)) : RecyclerView.Adapter<FavouriteAdapter.myAdapter>() {

    var list= ArrayList<CategoryModelclass>()
    lateinit var firebaseDatabase: DatabaseReference

    class myAdapter(view : View) : RecyclerView.ViewHolder(view){
        var amount : TextView =view.findViewById(R.id.txtplace)
        var rating : TextView =view.findViewById(R.id.txtLocation)
        var img : ImageView =view.findViewById(R.id.img)
        var name : TextView =view.findViewById(R.id.txtprice)
        var cvHotel: CardView =view.findViewById(R.id.txtdescription)
//        var imgLiked : ImageView =view.findViewById(R.id.imgLiked)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.beach_item_file,parent,false)
        return myAdapter(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myAdapter, position: Int) {
        firebaseDatabase = FirebaseDatabase.getInstance().getReference()

        Glide.with(context!!).load(list[position].Imageuri).into(holder.img)
        holder.amount.setText(list[position].Place)
        holder.rating.setText(list[position].city)

        holder.cvHotel.setOnClickListener {
            invoke.invoke(list[position])

        }

//            holder.imgLiked.setImageResource(R.drawable.user)



//
//        holder.imgLiked.setOnClickListener {
//            if(suratDetailsList[position].fav==1)
//            {
//                liked.invoke(0,suratDetailsList[position].key)
//                holder.imgLiked.setImageResource(R.drawable.hearttt)
//                suratDetailsList[position].fav=0
//            }
//
//            else
//            {
//                liked.invoke(1,suratDetailsList[position].key)
//                holder.imgLiked.setImageResource(R.drawable.user)
//                suratDetailsList[position].fav=1
//            }


//        }
    }

    fun updateList(list: ArrayList<CategoryModelclass>) {
        this.list=list
        notifyDataSetChanged()
    }
}
