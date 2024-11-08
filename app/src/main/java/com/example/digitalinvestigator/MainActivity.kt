package com.example.digitalinvestigator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private lateinit var slideButton: MaterialCardView
    private lateinit var swipeButton: MaterialCardView
    private var initialX: Float = 0f
    private var initialButtonX: Float = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Make status bar transparent and layout fullscreen
        makeStatusBarTransparent()

        slideButton = findViewById(R.id.slideButton)
        swipeButton = findViewById(R.id.swipeButton)

        setupSwipeButton()
    }

    private fun makeStatusBarTransparent() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = android.graphics.Color.TRANSPARENT
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupSwipeButton() {
        slideButton.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Store initial positions
                    initialX = event.rawX
                    initialButtonX = view.x
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    // Calculate new position
                    val delta = event.rawX - initialX
                    val newX = initialButtonX + delta

                    // Constrain movement within bounds
                    when {
                        newX < 4f -> view.x = 4f
                        newX > swipeButton.width - slideButton.width - 4f ->
                            view.x = swipeButton.width - slideButton.width - 4f
                        else -> view.x = newX
                    }

                    // Check if button is slid far enough
                    if (view.x >= (swipeButton.width - slideButton.width) * 0.7) {
                        navigateToNextScreen()
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    // Reset if not slid far enough
                    if (view.x < (swipeButton.width - slideButton.width) * 0.7) {
                        view.animate().x(4f).setDuration(200).start()
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToNextScreen() {
        slideButton.animate()
            .x(swipeButton.width - slideButton.width - 4f)
            .setDuration(100)
            .withEndAction {
                // Use FLAG_ACTIVITY_NEW_TASK and FLAG_ACTIVITY_CLEAR_TOP
                val intent = Intent(this, IntroActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                // Finish MainActivity to ensure it is removed from the task stack
                finish()
            }
            .start()
    }

}
