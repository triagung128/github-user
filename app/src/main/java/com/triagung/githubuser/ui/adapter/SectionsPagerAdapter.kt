package com.triagung.githubuser.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.triagung.githubuser.ui.fragment.FollowFragment

class SectionsPagerAdapter(activity: AppCompatActivity, private val username: String) :
    FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment =
        FollowFragment.newInstance(position, username)

    override fun getItemCount(): Int = 2
}