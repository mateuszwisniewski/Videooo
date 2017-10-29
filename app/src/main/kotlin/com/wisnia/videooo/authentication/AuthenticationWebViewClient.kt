package com.wisnia.videooo.authentication

import android.annotation.TargetApi
import android.net.Uri
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.wisnia.videooo.authentication.permission.PermissionInterceptor
import com.wisnia.videooo.authentication.permission.PermissionState
import com.wisnia.videooo.authentication.permission.PermissionUrl
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

class AuthenticationWebViewClient(token: String) : WebViewClient() {

    private val interceptor: PermissionInterceptor = PermissionInterceptor(token) // todo: use DI here.

    private val permissionSubject: PublishSubject<PermissionState> = PublishSubject.create()
    val permissionEvent: Flowable<PermissionState>
        get() = permissionSubject.toFlowable(BackpressureStrategy.LATEST).distinctUntilChanged()

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun shouldInterceptRequest(view: WebView, url: String): WebResourceResponse? {
        providePermissionEvent(Uri.parse(url))
        return super.shouldInterceptRequest(view, url)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldInterceptRequest(view: WebView, request: WebResourceRequest): WebResourceResponse? {
        providePermissionEvent(request.url)
        return super.shouldInterceptRequest(view, request)
    }

    private fun providePermissionEvent(uri: Uri) {
        val permissionUrl = PermissionUrl(uri.encodedPath, uri.lastPathSegment)
        val state = interceptor.interceptPermissionState(permissionUrl)
        permissionSubject.onNext(state)
    }
}
