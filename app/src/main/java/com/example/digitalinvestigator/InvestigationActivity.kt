package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.digitalinvestigator.databinding.ActivityInvestigationBinding

class InvestigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInvestigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Use View Binding for easier access to views
        binding = ActivityInvestigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listeners for buttons
        binding.predictNextStep.setOnClickListener {
            // Open PredictionActivity
            startActivity(Intent(this, PredictionActivity::class.java))
        }

        binding.predictPattern.setOnClickListener {
            // Open PredictionActivity2
            startActivity(Intent(this, PredicitionActivity2::class.java))
        }
    }
}
