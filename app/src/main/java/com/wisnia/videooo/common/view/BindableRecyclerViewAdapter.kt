package com.wisnia.videooo.common.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.wisnia.videooo.BR
import com.wisnia.videooo.common.viewmodel.LifecycleViewModel

abstract class BindableRecyclerViewAdapter<T> : RecyclerView.Adapter<BindingViewHolder<T>>() {

    private val data: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: BindingViewHolder<T>, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(newData: List<T>?) {
        newData?.let { refreshData(it) }
    }

    private fun refreshData(newData: List<T>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}

class BindingViewHolder<T>(
    private val binding: ViewDataBinding,
    private val viewModel: LifecycleViewModel? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        viewModel?.let {
            binding.setVariable(BR.viewModel, it)
        }
        binding.executePendingBindings()
    }
}
