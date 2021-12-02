package com.triagung.githubuser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.triagung.githubuser.databinding.ItemUserBinding

class UserAdapter(private val dataList: List<User>, private val listener: Listener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User) {
            binding.apply {
                tvName.text = data.name
                tvUsername.text = data.username
                ivUser.setImageResource(data.avatar)
            }

            itemView.setOnClickListener {
                listener.onItemClickListener(data)
            }
        }
    }

    interface Listener {
        fun onItemClickListener(data: User)
    }
}