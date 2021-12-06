package com.triagung.githubuser.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ActivityFavoriteBinding
import com.triagung.githubuser.model.UserDetail
import com.triagung.githubuser.ui.adapter.FavoriteAdapter
import com.triagung.githubuser.viewmodel.FavoriteViewModel
import com.triagung.githubuser.utils.ViewModelFactory

class FavoriteActivity : AppCompatActivity(), FavoriteAdapter.Listener {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        favoriteViewModel = obtainViewModel(this)

        favoriteAdapter = FavoriteAdapter(this)

        setupRecyclerView()

        favoriteViewModel.getAllUser().observe(this, { listUser ->
            if (listUser.isNotEmpty()) {
                favoriteAdapter.setData(listUser)
                binding.tvNoFavorite.visibility = View.GONE
                binding.rvFavorite.visibility = View.VISIBLE
            } else {
                binding.tvNoFavorite.visibility = View.VISIBLE
                binding.rvFavorite.visibility = View.GONE
            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }

    private fun setToolbar() {
        binding.toolbar.setNavigationIcon(R.drawable.ic_round_arrow_back_24)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupRecyclerView() {
        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = favoriteAdapter
        }
    }

    override fun onItemClickListener(data: UserDetail) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_USERNAME, data.login)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}