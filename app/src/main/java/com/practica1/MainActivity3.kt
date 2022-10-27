package com.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val retu = findViewById<Button>(R.id.ReturnBtn)

        var bundle = intent.extras
        val a = bundle?.getString("catA")
        val b = bundle?.getString("catB")
        val c = bundle?.getString("Hipo")

        val aText: TextView = findViewById(R.id.resultA)
        val bText: TextView = findViewById(R.id.resultB)
        val cText: TextView = findViewById(R.id.resultC)

        aText.setText("= " + a)
        bText.setText("= " + b)
        cText.setText("= " + c)

        retu.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }


}