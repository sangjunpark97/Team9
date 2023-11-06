package com.example.team9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.team9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun replaceFragment(frag: Fragment) {
            supportFragmentManager.beginTransaction().let {
                it.replace(binding.frmFragment.id, Fragment())
                it.commit()
            }
        }


        replaceFragment(TodoListFragment())




    }
}