package com.example.madarsofttask.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.madarsofttask.data.local.entity.User
import com.example.madarsofttask.databinding.ItemUserBinding
import kotlin.properties.Delegates

class UserAdapter(
    list: List<User> = emptyList()

) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var list: List<User> by Delegates.observable(list) { _, old, new ->
        DiffUtil.calculateDiff(
            object : DiffUtil.Callback() {
                override fun getOldListSize() = old.size

                override fun getNewListSize() = new.size

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    old[oldItemPosition].id == new[newItemPosition].id

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    old[oldItemPosition] == new[newItemPosition]

            }
        ).also { result ->
            result.dispatchUpdatesTo(this@UserAdapter)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(newList: List<User>) {
        list = newList
    }

    class ViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                binding.tvName.text = user.name
                binding.tvAge.text = "Age: ${user.age}"
                binding.tvJob.text = "Job: ${user.jobTitle}"
                binding.tvGender.text = "Gender: ${user.gender}"
            }
        }
    }
}
