package com.wisnia.videooo.authentication.permission

data class PermissionUrl(
    val encodedPath: String?,
    val lastPathSegment: String?
)