package com.example.travelwithmee.Activity.AddData

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelwithmee.Modelclass.CategoryModelclass
import com.example.travelwithmee.databinding.ActivityMountainAddDataBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class MountainAddDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityMountainAddDataBinding
    var reference = FirebaseDatabase.getInstance().reference
    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var Imageuri: Uri
    var Like : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMountainAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnmsubmit.setOnClickListener {
            var place = binding.edtmountain.text.toString()
            var city = binding.edtmcity.text.toString()
            var description = binding.edtmdescription.text.toString()
            var price = binding.edtmprice.text.toString()
            var people = binding.edtmstaypeople.text.toString()


            var key = reference.root.child("MountainDataTb").push().key ?: ""

            var modelClass =
                CategoryModelclass(place, city, description, price, people, key, Imageuri,Like)

            reference.root.child("MountainDataTb").child(key).setValue(modelClass)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Data Added Successful", Toast.LENGTH_SHORT).show()
                    }
                }.addOnCanceledListener { Log.e("TAG", "Error: " + it) }


        }
        var reference = FirebaseDatabase.getInstance().reference

        binding.btnmaddimg.setOnClickListener {


            val intent = Intent()
            intent.type = "image/Mountain/*"
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
                .child("images/Mountain/" + UUID.randomUUID().toString())

            // adding listeners on upload
            // or failure of image
            if (ref != null) {
                ref.putFile(uri).continueWith {

                    ref.downloadUrl.addOnCompleteListener {
                        Imageuri = it.result
                    }


                }

                    .addOnSuccessListener { // Image uploaded successfully
                        // Dismiss dialog
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@MountainAddDataActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@MountainAddDataActivity,
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