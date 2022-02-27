package com.gdsc.gdscubworkshopandroid1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnImplicit: Button
    private lateinit var btnExplicit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImplicit = findViewById(R.id.btn_intent_implicit)
        btnExplicit = findViewById(R.id.btn_intent_explicit)

        btnImplicit.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(intent)
        }

        btnExplicit.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}