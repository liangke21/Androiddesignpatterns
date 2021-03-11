package com.example.androiddesignpatterns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddesignpatterns.databinding.ActivityMainBinding
import com.example.androiddesignpatterns.normal.NormalActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {

            intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

    }
}