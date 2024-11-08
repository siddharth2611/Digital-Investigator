package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CaseRegistrationActivity : AppCompatActivity() {

    private lateinit var edtExpectedAttack: EditText
    private lateinit var edtLocationTime: EditText
    private lateinit var edtIncidentDescription: EditText
    private lateinit var edtDateLocation: EditText
    private lateinit var edtComplainantDetails: EditText
    private lateinit var edtInvestigator: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnSaveDraft: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_registration)

        // Initialize views
        edtExpectedAttack = findViewById(R.id.edtExpectedAttack)
        edtLocationTime = findViewById(R.id.edtLocationTime)
        edtIncidentDescription = findViewById(R.id.edtIncidentDescription)
        edtDateLocation = findViewById(R.id.edtDateLocation)
        edtComplainantDetails = findViewById(R.id.edtComplainantDetails)
        edtInvestigator = findViewById(R.id.edtInvestigator)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSaveDraft = findViewById(R.id.btnSaveDraft)

        btnSubmit.setOnClickListener {
            val expectedAttack = edtExpectedAttack.text.toString()
            val locationTime = edtLocationTime.text.toString()
            val incidentDescription = edtIncidentDescription.text.toString()
            val dateLocation = edtDateLocation.text.toString()
            val complainantDetails = edtComplainantDetails.text.toString()
            val investigator = edtInvestigator.text.toString()

            val caseNumber = "CASE-${System.currentTimeMillis()}"

            val intent = Intent(this, CaseConfirmationActivity::class.java).apply {
                putExtra("CASE_NUMBER", caseNumber)
                putExtra("EXPECTED_ATTACK", expectedAttack)
                putExtra("LOCATION_TIME", locationTime)
                putExtra("INCIDENT_DESCRIPTION", incidentDescription)
                putExtra("DATE_LOCATION", dateLocation)
                putExtra("COMPLAINANT_DETAILS", complainantDetails)
                putExtra("INVESTIGATOR", investigator)
            }
            startActivity(intent)
        }

        btnSaveDraft.setOnClickListener {
            saveDraft()
        }
    }

    private fun saveDraft() {
        Toast.makeText(this, "Draft saved", Toast.LENGTH_SHORT).show()
    }
}