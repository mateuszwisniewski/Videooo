package com.wisnia.videooo.common.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wisnia.videooo.common.view.BindableRecyclerViewAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> RecyclerView.bindDataToRecyclerAdapter(data: List<T>?) {
    val adapter = adapter as BindableRecyclerViewAdapter<T>
    data?.let { adapter.updateData(it) }
}
