package com.wisnia.videooo.authentication.permission

import com.wisnia.videooo.extension.EMPTY
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PermissionInterceptorTest {

    private val exampleToken = "exampleToken"
    private val pathSegmentAllow = "allow"
    private val pathSegmentDeny = "deny"

    private val incorrectUriPath = "incorrect/uri/path"
    private val correctUriPath = "/authenticate/$exampleToken"

    @Test
    fun `when intercept permission with incorrect authenticate uri path then should return none permission state`() {
        // Given
        val url = PermissionUrl(incorrectUriPath, String.EMPTY)
        val interceptor = PermissionInterceptor(exampleToken)

        // When
        val permissionState = interceptor.interceptPermissionState(url)

        // Then
        assertEquals(PermissionState.NONE, permissionState)
    }

    @Test
    fun `when intercept permission with correct authenticate uri path and allow path segment then should return allow permission state`() {
        // Given
        val url = PermissionUrl(correctUriPath, pathSegmentAllow)
        val interceptor = PermissionInterceptor(exampleToken)

        // When
        val permissionState = interceptor.interceptPermissionState(url)

        // Then
        assertEquals(PermissionState.ALLOW, permissionState)
    }

    @Test
    fun `when intercept permission with correct authenticate uri path and deny path segment then should return deny permission state`() {
        // Given
        val url = PermissionUrl(correctUriPath, pathSegmentDeny)
        val interceptor = PermissionInterceptor(exampleToken)

        // When
        val permissionState = interceptor.interceptPermissionState(url)

        // Then
        assertEquals(PermissionState.DENY, permissionState)
    }
}
