package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.digitalinvestigator.databinding.ActivityCompleteActivtyBinding

class CompleteActivty : AppCompatActivity() {

    private lateinit var binding: ActivityCompleteActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Use View Binding for easier access to views
        binding = ActivityCompleteActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listener for the "Complete" button
        binding.completeBtn.setOnClickListener {
            // Open CompleteActivity2
            startActivity(Intent(this, CompleteActivity2::class.java))
        }
    }
}
