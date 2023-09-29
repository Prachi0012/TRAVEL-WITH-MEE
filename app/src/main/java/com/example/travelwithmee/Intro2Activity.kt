package com.example.travelwithmee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Intro2Activity : AppCompatActivity() {
    lateinit var btnnext: CardView
    lateinit var btnback: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2)
        initview()
    }

    private fun initview() {

        btnnext=findViewById(R.id.btnnext)
        btnback=findViewById(R.id.btnback)
        btnnext.setOnClickListener {
            var i = Intent(this@Intro2Activity,Intro3Activity::class.java)
            startActivity(i)
        }
        btnback.setOnClickListener {
            var i = Intent(this@Intro2Activity,Intro1Activity::class.java)
            startActivity(i)
        }

    }
}