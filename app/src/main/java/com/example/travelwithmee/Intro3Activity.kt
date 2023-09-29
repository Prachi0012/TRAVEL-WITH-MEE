package com.example.travelwithmee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Intro3Activity : AppCompatActivity() {
    lateinit var btnnext: CardView
    lateinit var btnback: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro3)
        initview()
    }

    private fun initview() {
        btnnext=findViewById(R.id.btnnext)
        btnback=findViewById(R.id.btnback)
        btnnext.setOnClickListener {
            var i = Intent(this@Intro3Activity,MainActivity2::class.java)
            startActivity(i)
        }
        btnback.setOnClickListener {
            var i = Intent(this@Intro3Activity,Intro2Activity::class.java)
            startActivity(i)
        }

    }
}