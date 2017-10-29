package com.wisnia.videooo.authentication.permission

class PermissionInterceptor(token: String) {

    private val allowPathSegment = "allow"
    private val authenticatePath = "/authenticate/$token"

    fun interceptPermissionState(url: PermissionUrl) =
            if (url.encodedPath.contains(authenticatePath)) {
                providePermissionState(url)
            } else {
                PermissionState.NONE
            }

    private fun providePermissionState(url: PermissionUrl) =
            if (url.lastPathSegment.contains(allowPathSegment)) {
                PermissionState.ALLOW
            } else {
                PermissionState.DENY
            }
}
