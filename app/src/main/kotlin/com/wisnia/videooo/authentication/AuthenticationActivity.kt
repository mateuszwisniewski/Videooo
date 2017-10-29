package com.wisnia.videooo.authentication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.permission.PermissionState
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.login.tokenKey
import com.wisnia.videooo.mvp.EmptyPresenter
import com.wisnia.videooo.mvp.PresentationActivity
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.mvp.View
import kotlinx.android.synthetic.main.activty_auth_permission.*

class AuthenticationActivity : PresentationActivity<View>() {

    override fun getPresenter(): Presenter<View> = EmptyPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_auth_permission)

        val token = intent.getSerializableExtra(tokenKey) as Token
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