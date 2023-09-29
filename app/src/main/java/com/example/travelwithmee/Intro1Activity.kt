package com.example.travelwithmee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Intro1Activity : AppCompatActivity() {
    lateinit var btnnext: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1)
        initview()
    }

    private fun initview() {

        btnnext=findViewById(R.id.btnnext)
        btnnext.setOnClickListener {
            var i = Intent(this@Intro1Activity,Intro2Activity::class.java)
            startActivity(i)
        }

    }
}