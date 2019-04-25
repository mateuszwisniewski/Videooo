package com.wisnia.videooo.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.videooo.login.LoginActivity

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
