package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DegEviActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_deg_evi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the buttons
        val newFileButton: Button = findViewById(R.id.new_file)
        val findFileButton: Button = findViewById(R.id.find_file)
        val accessFileButton: Button = findViewById(R.id.access_file)

        // Set click listeners for each button to open ConstructionActivity
        val openConstructionActivity = {
            val intent = Intent(this, ConstructionActivity::class.java)
            startActivity(intent)
        }

        newFileButton.setOnClickListener { openConstructionActivity() }
        findFileButton.setOnClickListener { openConstructionActivity() }
        accessFileButton.setOnClickListener { openConstructionActivity() }
    }
}
