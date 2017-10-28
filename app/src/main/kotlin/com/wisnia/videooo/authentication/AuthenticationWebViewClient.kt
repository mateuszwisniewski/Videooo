package com.wisnia.videooo.authentication

import android.annotation.TargetApi
import android.net.Uri
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

class AuthenticationWebViewClient(token: String) : WebViewClient() {

    private val allowPathSegment = "allow"
    private val authenticatePath = "/authenticate/$token"

    private val permissionSubject: PublishSubject<PermissionState> = PublishSubject.create()
    val permissionEvent: Flowable<PermissionState>
        get() = permissionSubject.toFlowable(BackpressureStrategy.LATEST)

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun shouldInterceptRequest(view: WebView, url: String): WebResourceResponse? {
        interceptPermissionState(Uri.parse(url))
        return super.shouldInterceptRequest(view, url)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldInterceptRequest(view: WebView, request: WebResourceRequest): WebResourceResponse? {
        interceptPermissionState(request.url)
        return super.shouldInterceptRequest(view, request)
    }

    private fun interceptPermissionState(uri: Uri) {
        if (uri.encodedPath.contains(authenticatePath)) {
            if (uri.lastPathSegment.contains(allowPathSegment)) {
                permissionSubject.onNext(PermissionState.ALLOW)
            } else {
                permissionSubject.onNext(PermissionState.DENY)
            }
        }
    }
}
