package com.triagung.githubuser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ItemUserBinding
import com.triagung.githubuser.model.User

class UserAdapter(private val listener: Listener) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val listData = ArrayList<User>()

    fun setData(listData: List<User>) {
        this.listData.clear()
        this.listData.addAll(listData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User) {
            binding.apply {
                tvUsername.text = data.login
                tvType.text = data.type
                Glide.with(itemView.context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .error(R.drawable.ic_baseline_broken_image_24)
                            .placeholder(R.drawable.ic_baseline_replay_24)
                    )
                    .load(data.avatarUrl)
                    .into(ivUser)
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