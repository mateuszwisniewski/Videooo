package com.wisnia.videooo.authentication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.permission.PermissionState
import com.wisnia.videooo.login.view.TOKEN_KEY
import kotlinx.android.synthetic.main.activty_auth_permission.authPermissionWebView

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_auth_permission)

        val token = intent.getSerializableExtra(TOKEN_KEY) as Token
        val webViewClient = AuthenticationWebViewClient(token.token)
        setupWebView(webViewClient, token)
        subscribeAccessPermissionEvents(webViewClient)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(webViewClient: AuthenticationWebViewClient, token: Token) {
        authPermissionWebView.apply {
            setWebViewClient(webViewClient)
            settings.javaScriptEnabled = true
            loadUrl(token.authenticationPage)
        }
    }

    private fun subscribeAccessPermissionEvents(webViewClient: AuthenticationWebViewClient) {
        webViewClient.permissionEvent.subscribe {
            when (it) {
                PermissionState.ALLOW -> setResult(Activity.RESULT_OK)
                PermissionState.DENY -> setResult(Activity.RESULT_CANCELED)
                PermissionState.NONE -> Any()
            }
        }
    }
}