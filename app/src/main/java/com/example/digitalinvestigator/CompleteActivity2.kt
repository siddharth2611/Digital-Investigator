package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.digitalinvestigator.databinding.ActivityComplete2Binding

class CompleteActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityComplete2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Use View Binding for easier access to views
        binding = ActivityComplete2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listener for the "Prepare" button
        binding.btnPrepare.setOnClickListener {
            // Open CaseCompActivity
            startActivity(Intent(this, CaseCompActivity::class.java))
        }
    }
}
