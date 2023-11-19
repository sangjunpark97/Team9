package com.example.team9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.team9.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import java.util.UUID

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val navController = binding.frgNav.getFragment<NavHostFragment>().navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.todoListFragment, R.id.scheduleFragment, R.id.gradeFragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        realTimeDatabaseTest()


        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = binding.frgNav.getFragment<NavHostFragment>().navController

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun realTimeDatabaseTest() {
        val db = Firebase.database
        val uuid = UUID.randomUUID().toString()
        val myRef = db.getReference("3")
        val testData = JWAData.appData(
            "",
            JWAData.Todo(
                "어드벤쳐디자인",
                "23년10월4일까지",
                ""
            ),
            "3시간",
            "강의동204호",
            "김형래교수님",
            "발표준비잘할것"
        )

        myRef.child("subject").setValue(testData.subject)
        myRef.child("todo").push().setValue(
            testData.todo)

        myRef.child("classTime").setValue(testData.classTime)
        myRef.child("classRoom").setValue(testData.classRoom)
        myRef.child("teacher").setValue(testData.teacher)
        myRef.child("scheduleMemo").setValue(testData.scheduleMemo)
    }

    private fun writeValue(myRef: DatabaseReference, data: String) {
        myRef.setValue(data)
    }
}