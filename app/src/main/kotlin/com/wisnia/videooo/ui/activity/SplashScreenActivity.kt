package com.wisnia.videooo.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLoginScreen()
    }

    private fun showLoginScreen() {
        Intent(this, LoginActivity::class.java).let {
            startActivity(it)
            finish()
        }
    }
}