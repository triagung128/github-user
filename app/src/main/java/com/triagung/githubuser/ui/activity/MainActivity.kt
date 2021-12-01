package com.triagung.githubuser.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ActivityMainBinding
import com.triagung.githubuser.model.User
import com.triagung.githubuser.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity(), UserAdapter.Listener {

    private lateinit var binding: ActivityMainBinding

    private var listUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        initData()

        setRecyclerView()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F
    }

    private fun initData() {
        listUser.clear()

        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val company = resources.getStringArray(R.array.company)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getIntArray(R.array.repository)
        val follower = resources.getIntArray(R.array.followers)
        val following = resources.getIntArray(R.array.following)

        for (i in username.indices) {
            listUser.add(
                User(
                    username = username[i],
                    name = name[i],
                    avatar = avatar.getResourceId(i, -1),
                    company = company[i],
                    location = location[i],
                    repository = repository[i],
                    follower = follower[i],
                    following = following[i]
                )
            )
        }
    }

    private fun setRecyclerView() {
        val userAdapter = UserAdapter(listUser, this)

        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUser.adapter = userAdapter
        }
    }

    override fun onItemClickListener(data: User) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }
}