package com.wisnia.videooo.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.wisnia.videooo.R

class FontTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs) {
    init {
        initAttributes(context, attrs)
    }

    fun initAttributes(context: Context, attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.FontTextView)
        val font = array.getString(R.styleable.FontTextView_font)
        setTypeface(context, font)
        array.recycle()
    }

    private fun setTypeface(context: Context, font: String) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/" + font)
        setTypeface(typeface)
    }
}