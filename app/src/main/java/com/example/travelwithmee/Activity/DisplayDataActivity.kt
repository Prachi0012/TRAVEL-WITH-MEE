package com.example.travelwithmee.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.travelwithmee.R
import com.example.travelwithmee.R.drawable
import com.example.travelwithmee.databinding.ActivityDisplayDataBinding
import com.google.android.libraries.places.api.model.Place

class DisplayDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityDisplayDataBinding
    lateinit var data :String
    lateinit var Place :String
    var Like : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityDisplayDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        if(intent!=null) {


            var key = intent.getStringExtra("key").toString()
            Place = intent.getStringExtra("Place").toString()
            var city = intent.getStringExtra("city").toString()
            var description = intent.getStringExtra("description").toString()
            var price = intent.getStringExtra("price").toString()
            var Imageuri = intent.getStringExtra("Imageuri").toString()


            binding.txtplace.text= Place
            binding.txtcity.text=city
            binding.txtdescription.text=description
            binding.txtprice.text=price

            Glide.with(baseContext).load(Imageuri).into(binding.img)
        }


        binding.btnlike.setOnClickListener {


                binding.btnlike.setImageResource(drawable.fillheart)

        }

        binding.maplocation.setOnClickListener {

            var i = Intent(this@DisplayDataActivity,MapLocationActivity::class.java)
            i.putExtra("location",Place)
            startActivity(i)


        }

    }
}