package com.wisnia.videooo.authentication.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.domain.authentication.model.TokenModel
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.model.PermissionState
import com.wisnia.videooo.login.view.TOKEN_KEY
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class AuthenticationActivity : AppCompatActivity() {

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_auth_permission)

        val token = intent.getSerializableExtra(TOKEN_KEY) as TokenModel
        AuthenticationWebViewClient(token.token).let { client ->
            setupWebView(client, token)
            subscribeAccessPermissionEvents(client)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(webViewClient: AuthenticationWebViewClient, token: TokenModel) {
        findViewById<WebView>(R.id.authPermissionWebView).apply {
            setWebViewClient(webViewClient)
            settings.javaScriptEnabled = true
            token.authenticationPage?.let { loadUrl(it) }
        }
    }

    private fun subscribeAccessPermissionEvents(webViewClient: AuthenticationWebViewClient) {
        disposables += webViewClient.permissionSubject.subscribe { state ->
            when (state) {
                PermissionState.ALLOW -> setResult(Activity.RESULT_OK)
                PermissionState.DENY -> setResult(Activity.RESULT_CANCELED)
                PermissionState.NONE -> Any()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}
