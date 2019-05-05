package com.wisnia.videooo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class LiveDataTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()
}