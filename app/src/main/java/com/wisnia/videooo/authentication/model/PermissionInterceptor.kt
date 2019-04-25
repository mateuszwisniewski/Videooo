package com.wisnia.videooo.authentication.model

class PermissionInterceptor(token: String) {

    private val allowPathSegment = "allow"
    private val authenticatePath = "/authenticate/$token"

    fun interceptPermissionState(url: PermissionUrl) =
        url.encodedPath?.let {
            if (url.encodedPath.contains(authenticatePath)) {
                providePermissionState(url)
            } else {
                PermissionState.NONE
            }
        } ?: PermissionState.NONE

    private fun providePermissionState(url: PermissionUrl) =
        url.lastPathSegment?.let {
            if (url.lastPathSegment.contains(allowPathSegment)) {
                PermissionState.ALLOW
            } else {
                PermissionState.DENY
            }
        } ?: PermissionState.DENY
}
