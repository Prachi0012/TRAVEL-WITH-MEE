package com.example.travelwithmee.Activity.AddData

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travelwithmee.Modelclass.CategoryModelclass
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.ActivityCampAdddataBinding
import com.example.travelwithmee.databinding.ActivityCityAddDataBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class CityAddDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityCityAddDataBinding
    var reference = FirebaseDatabase.getInstance().reference
    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var Imageuri: Uri
    var Like : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnbsubmit.setOnClickListener {
            var place = binding.edtbeach.text.toString()
            var city = binding.edtbcity.text.toString()
            var description = binding.edtbdescription.text.toString()
            var price = binding.edtbprice.text.toString()
            var people = binding.edtbstaypeople.text.toString()


            var key = reference.root.child("CityDataTb").push().key ?:""

            var modelClass = CategoryModelclass(place,city,description,price,people,key,Imageuri,Like)

            reference.root.child("CityDataTb").child(key).setValue(modelClass).addOnCompleteListener {

                if(it.isSuccessful)
                {
                    Toast.makeText(this, "Data Added Successful", Toast.LENGTH_SHORT).show()
                }
            }.addOnCanceledListener { Log.e("TAG", "Error: "+ it ) }
        }

        var reference = FirebaseDatabase.getInstance().reference

        binding.btnbaddimg.setOnClickListener {


            val intent = Intent()
            intent.type = "image/City/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(
                    intent,
                    "Select Image from here..."
                ),
                PICK_IMAGE_REQUEST
            )


        }
    }
    private fun uploadImage() {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            // Defining the child of storageReference
            val ref: StorageReference = FirebaseStorage.getInstance().getReference()
                .child("images/City/" + UUID.randomUUID().toString())

            // adding listeners on upload
            // or failure of image
            if (ref != null) {
                ref.putFile(uri).continueWith {

                    ref.downloadUrl.addOnCompleteListener {
                        Imageuri= it.result
                    }


                }

                    .addOnSuccessListener { // Image uploaded successfully
                        // Dismiss dialog
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@CityAddDataActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@CityAddDataActivity,
                                "Failed " + e.message,
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }

            }
        }
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {

            // Get the Uri of data
            uri = data.data!!
            uploadImage()

        }
    }
}