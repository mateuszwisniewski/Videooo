package com.wisnia.videooo.extension

import android.support.design.widget.TextInputLayout

fun TextInputLayout.text(): String = editText?.text.toString()