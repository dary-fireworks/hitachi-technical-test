package com.test.hitachi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.test.hitachi.adapter.viewholder.UserViewHolder
import com.test.hitachi.databinding.ItemHolderUserBinding
import com.test.hitachi.model.User

class UserAdapter(private val onUserClick:(String) -> Unit): ListAdapter<User, UserViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val binding = ItemHolderUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding, onUserClick)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem.userId == newItem.userId
            }
        }
    }
}