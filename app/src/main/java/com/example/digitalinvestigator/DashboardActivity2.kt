package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import android.widget.ImageView
import android.widget.FrameLayout

class DashboardActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drawer)

        // Reference to the DrawerLayout
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        // Reference to the menu icon
        val menuIcon: ImageView = findViewById(R.id.menuIcon)

        // Open the drawer when the menu icon is clicked
        menuIcon.setOnClickListener {
            drawerLayout.open()
        }

        // Adjust padding for system bars (status bar, navigation bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Reference to the FrameLayouts
        val caseRFrame: FrameLayout = findViewById(R.id.CaseRFrame)
        val investigationFrame: FrameLayout = findViewById(R.id.investigationFrame)
        val precFrame: FrameLayout = findViewById(R.id.precFrame)
        val digitalEvidenceFrame: FrameLayout = findViewById(R.id.digitalEvidenceFrame)
        val completeFrame: FrameLayout = findViewById(R.id.completeFrame)

        // Set OnClickListeners for each FrameLayout to open their respective activities
        caseRFrame.setOnClickListener {
            openActivity(CaseRegistrationActivity::class.java)
        }

        investigationFrame.setOnClickListener {
            openActivity(InvestigationActivity::class.java)
        }

        precFrame.setOnClickListener {
            openActivity(PrecautionActivity::class.java)
        }

        digitalEvidenceFrame.setOnClickListener {
            openActivity(DegEviActivity::class.java)
        }

        completeFrame.setOnClickListener {
            openActivity(CompleteActivty::class.java)
        }
    }

    // Method to open the respective activity
    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
