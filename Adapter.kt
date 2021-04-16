package com.android.usergithub

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.usergithub.databinding.ItemListBinding
import com.bumptech.glide.Glide

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val userList = ArrayList<UserList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewList = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(viewList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(userList[position])
    }

    override fun getItemCount() = userList.size

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun binding(user: UserList){
            binding.apply {
                Glide.with(itemView)
                        .load(user.avatar_url)
                        .into(imageView)
                username.text = user.login
            }
        }
    }

}