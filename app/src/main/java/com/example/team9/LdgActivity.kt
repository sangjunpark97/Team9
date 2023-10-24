package com.example.team9

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.team9.databinding.ActivityMainBinding
import com.example.team9.databinding.LdgBinding

class LdgActivity : AppCompatActivity() {
    lateinit var binding : LdgBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdgBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}