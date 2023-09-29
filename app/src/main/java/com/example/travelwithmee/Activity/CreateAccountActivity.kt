package com.example.travelwithmee.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.ActivityCreateAccountBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var btnSignUp : CardView
    lateinit var edtEmail : EditText
    lateinit var edtPassword : EditText
    lateinit var sharedPreferences: SharedPreferences

    lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences("MySharedPref", MODE_PRIVATE)

        val auth = Firebase.auth
        initview()
    }

    private fun initview() {
        btnSignUp = findViewById(R.id.btnSignUp)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)


        val intent = intent
        val emailLink = intent.data.toString()

        val credential = EmailAuthProvider.getCredentialWithLink(emailLink ,emailLink)

        Firebase.auth.currentUser!!.linkWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login Sucessfully", Toast.LENGTH_SHORT).show()
                    val result = task.result

                } else {
                    Log.e("TAG", "Error linking emailLink credential", task.exception)
                }
            }

        binding.Btncreate.setOnClickListener {
            var i = Intent(this@CreateAccountActivity,MainActivity2::class.java)
            startActivity(i)
        }
    }
}