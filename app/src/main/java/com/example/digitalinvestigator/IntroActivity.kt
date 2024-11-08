package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalinvestigator.R
import com.example.digitalinvestigator.SignInActivity
import com.google.android.material.button.MaterialButton

class IntroActivity : AppCompatActivity() {

    private val currentScreen = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Initialize progress indicators
        updateProgressIndicators()

        // Set click listeners
        findViewById<MaterialButton>(R.id.btnSkip).setOnClickListener {
            navigateToSignIn()
        }

        findViewById<MaterialButton>(R.id.btnNext).setOnClickListener {
            navigateToNextScreen()
        }
    }

    private fun updateProgressIndicators() {
        findViewById<View>(R.id.progressItem1).setBackgroundColor(getColor(R.color.progress_active))
        findViewById<View>(R.id.progressItem2).setBackgroundColor(getColor(R.color.progress_inactive))
        findViewById<View>(R.id.progressItem3).setBackgroundColor(getColor(R.color.progress_inactive))
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, IntroActivity2::class.java)
        startActivity(intent)
        finish()
    }
}
