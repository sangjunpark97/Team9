package com.example.team9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.team9.databinding.ActivityMainBinding

class todolistactivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolistactivity)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)







    }
}