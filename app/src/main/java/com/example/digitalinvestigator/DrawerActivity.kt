package com.example.digitalinvestigator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Set up listener for navigation items
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.reg -> {
                    Log.d("DrawerActivity", "CaseRegistrationActivity selected")
                    startActivity(Intent(this, CaseRegistrationActivity::class.java))
                }
                R.id.cpredict -> {
                    Log.d("DrawerActivity", "InvestigationActivity selected")
                    startActivity(Intent(this, InvestigationActivity::class.java))
                }
                R.id.precpredict -> {
                    Log.d("DrawerActivity", "PrecautionActivity selected")
                    startActivity(Intent(this, PrecautionActivity::class.java))
                }
                R.id.diger -> {
                    Log.d("DrawerActivity", "DegEviActivity selected")
                    startActivity(Intent(this, DegEviActivity::class.java))
                }
                R.id.fcom -> {
                    Log.d("DrawerActivity", "CompleteActivity selected")
                    startActivity(Intent(this, CompleteActivty::class.java))
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
