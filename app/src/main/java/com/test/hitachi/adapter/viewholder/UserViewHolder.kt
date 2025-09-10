package com.test.hitachi.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.hitachi.databinding.ItemHolderUserBinding
import com.test.hitachi.model.User

class UserViewHolder(
    private val view: ItemHolderUserBinding,
    private val onUserClick: (String) -> Unit
): RecyclerView.ViewHolder(view.root) {

    fun bind(user: User) {
        view.apply {
            Glide.with(root.context)
                .load(user.avatar)
                .into(ivUser)
            tvUser.text = user.username
            root.setOnClickListener {
                onUserClick.invoke(user.username)
            }
        }
    }

}