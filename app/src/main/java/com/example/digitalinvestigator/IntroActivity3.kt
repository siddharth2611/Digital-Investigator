package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class IntroActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro3)

        // Initialize progress indicators
        updateProgressIndicators()


        findViewById<MaterialButton>(R.id.btnStart2).setOnClickListener {
            navigateToSignIn()
        }
    }

    private fun updateProgressIndicators() {
        findViewById<View>(R.id.progressItem1).setBackgroundColor(getColor(R.color.progress_inactive))
        findViewById<View>(R.id.progressItem2).setBackgroundColor(getColor(R.color.progress_inactive))
        findViewById<View>(R.id.progressItem3).setBackgroundColor(getColor(R.color.progress_active))
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
