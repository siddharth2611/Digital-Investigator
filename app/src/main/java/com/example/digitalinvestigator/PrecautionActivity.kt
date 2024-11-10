package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrecautionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_precaution)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the buttons
        val forInvestigatorButton: Button = findViewById(R.id.for_investigator)
        val forVictimButton: Button = findViewById(R.id.for_victim)

        // Set click listeners
        forInvestigatorButton.setOnClickListener {
            // Start PrecautionActivity2
            val intent = Intent(this, PrecautionActivity2::class.java)
            startActivity(intent)
        }

        forVictimButton.setOnClickListener {
            // Start PrecautionActivity3
            val intent = Intent(this, PrecautionActivty3::class.java)
            startActivity(intent)
        }
    }
}
