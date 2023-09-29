package com.example.travelwithmee.Activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelwithmee.Adapter.CategoryAdapter
import com.example.travelwithmee.Modelclass.CategoryModelclass
import com.example.travelwithmee.databinding.ActivityDesignationdetailAcitivityBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DesignationdetailAcitivity : AppCompatActivity() {

    lateinit var binding: ActivityDesignationdetailAcitivityBinding

    lateinit var placetitle: String
    var list = ArrayList<CategoryModelclass>()
    var reference = FirebaseDatabase.getInstance().reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignationdetailAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }


    private fun initview() {

        if (intent != null) {
            placetitle = intent.getStringExtra("category").toString()
            binding.txtTitle.text = placetitle

            Log.e("TAG", "initview: failed" )
            if (placetitle == "Beach") {
                callBeach()
            }
            else if (placetitle == "Mountain") {

                callMountain()
            }
            else if (placetitle == "Lake") {

                callLake()
            }
            else if (placetitle == "Camp") {

                callCamp()
            }
            else if (placetitle == "City") {

                callCity()
            }
            else if (placetitle == "Desert") {

                callDesert()
            }
            else if (placetitle == "Forest") {

                callForest()
            }
        }

    }

    private fun callForest() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("ForestDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list, onItemclick = {Place, city, description, price, key,
                                                                                                    Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callDesert() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("DesertDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callCity() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("CityDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callCamp() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("CampDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callLake() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("LakeDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callMountain() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("MountainDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(this@DesignationdetailAcitivity, LinearLayoutManager.VERTICAL, false)

                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }

            override fun onCancelled(error: DatabaseError) {

                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })
    }

    private fun callBeach() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        reference.root.child("BeachDataTb").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {


                for (child in dataSnapshot.children) {

                    var data: CategoryModelclass? =
                        child.getValue(CategoryModelclass::class.java)
                    Log.e("TAG", "onDataChange: ")

//                    list.add(data as BeachDataAddModelclass)
                    if (data != null) {
                        list.add(data)
                    }
                }
                progressDialog.dismiss()
                var adapter = CategoryAdapter(this@DesignationdetailAcitivity, list,onItemclick = {Place, city, description, price, key,
                                                                                                   Imageuri ->
                    var i = Intent(this@DesignationdetailAcitivity,DisplayDataActivity::class.java)
                    i.putExtra("Place",Place)
                    i.putExtra("city",city)
                    i.putExtra("description",description)
                    i.putExtra("price",price)
                    i.putExtra("key",key)
                    i.putExtra("Imageuri",Imageuri)
                    startActivity(i)

                })
                var manager = LinearLayoutManager(
                    this@DesignationdetailAcitivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                binding.beachrcv.adapter = adapter
                binding.beachrcv.layoutManager = manager
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }


        })


    }


}




