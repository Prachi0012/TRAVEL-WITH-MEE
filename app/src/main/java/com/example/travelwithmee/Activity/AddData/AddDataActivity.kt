package com.example.travelwithmee.Activity.AddData

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travelwithmee.Modelclass.AddDataModelclass
import com.example.travelwithmee.databinding.ActivityAddDataBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class AddDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddDataBinding
    var reference = FirebaseDatabase.getInstance().reference
    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var Imageuri: Uri
    var Like : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnsubmit.setOnClickListener {
            var place = binding.edtPlace.text.toString()
            var city = binding.edtCity.text.toString()
            var phone = binding.edtnumber.text.toString()
            var email = binding.edtemail.text.toString()
            var days = binding.edtdays.text.toString()

            var price = binding.edtprice.text.toString()

            var description = binding.edtdescription.text.toString()
            var rate = binding.edtrate.text.toString()

            var key = reference.root.child("Datatb").push().key ?:""

            var modelClass = AddDataModelclass(place,city,phone,email,price,description,days,rate,key,Imageuri, Like)

            reference.root.child("Datatb").child(key).setValue(modelClass).addOnCompleteListener {

                if(it.isSuccessful)
                {
                    Toast.makeText(this, "Data Added Successful", Toast.LENGTH_SHORT).show()
                }
            }.addOnCanceledListener { Log.e("TAG", "Error: "+ it ) }
        }



        var reference = FirebaseDatabase.getInstance().reference

        binding.btnaddimg.setOnClickListener {


            val intent = Intent()
            intent.type = "image/HomePlace/*"
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
                .child("images/HomePlace/" + UUID.randomUUID().toString())

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
                                this@AddDataActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@AddDataActivity,
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