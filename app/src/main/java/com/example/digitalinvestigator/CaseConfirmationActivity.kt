package com.example.digitalinvestigator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CaseConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_confirmation)

        // Retrieve data from the intent
        val caseNumber = intent.getStringExtra("CASE_NUMBER") ?: "Unknown"

        // Display confirmation message with case number
        val caseDetailsText = findViewById<TextView>(R.id.caseDetailsText)
        caseDetailsText.text = "Case has been registered in the database,\nPlease proceed for the investigation process\n Case Number='$caseNumber'"
    }
}
