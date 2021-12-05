package com.triagung.githubuser.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ActivityDetailBinding
import com.triagung.githubuser.model.UserDetail
import com.triagung.githubuser.ui.adapter.SectionsPagerAdapter
import com.triagung.githubuser.viewmodel.DetailViewModel
import com.triagung.githubuser.viewmodel.ViewModelFactory
import kotlin.math.abs

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"

        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    private var username: String = ""
    private var isFavorite = false
    private var userDetail = UserDetail()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra(EXTRA_USERNAME) as String

        detailViewModel = obtainViewModel(this)

        detailViewModel.getUserByUsername(username).observe(this, { data ->
            isFavorite = data != null
            setIconFavorite(isFavorite)
        })
        detailViewModel.isLoading.observe(this, { state -> isLoading(state) })
        detailViewModel.detailUser.observe(this, { data ->
            userDetail = data
            setData(data)
        })

        setToolbar()
        getDetailUser()
        initView()
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[DetailViewModel::class.java]
    }

    private fun setToolbar() {
        binding.toolbar.setNavigationIcon(R.drawable.ic_round_arrow_back_24)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = ""
    }

    private fun getDetailUser() {
        detailViewModel.getDetailUser(username)
    }

    private fun setData(data: UserDetail) {
        // Set title toolbar when scrolling
        binding.appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                    // Collapsed
                    supportActionBar?.title = data.login
                } else {
                    // Expanded
                    supportActionBar?.title = ""
                }
            }
        )

        binding.tvName.text = data.name
        binding.tvUsername.text = data.login

        Glide.with(this)
            .setDefaultRequestOptions(
                RequestOptions()
                    .error(R.drawable.ic_baseline_broken_image_24)
                    .placeholder(R.drawable.ic_baseline_replay_24)
            )
            .load(data.avatarUrl)
            .into(binding.ivUser)
    }

    private fun initView() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, username)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.fabFavorite.setOnClickListener {
            if (!isFavorite) {
                detailViewModel.insert(userDetail)
                showToast(getString(R.string.add_favorite))
                isFavorite = true
                setIconFavorite(isFavorite)
            } else {
                detailViewModel.delete(userDetail)
                showToast(getString(R.string.delete_favorite))
                isFavorite = false
                setIconFavorite(isFavorite)
            }
        }
    }

    private fun setIconFavorite(state: Boolean) {
        if (state) {
            binding.fabFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.fabFavorite.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.ivUser.visibility = View.INVISIBLE
            binding.tvName.visibility = View.INVISIBLE
            binding.tvUsername.visibility = View.INVISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.ivUser.visibility = View.VISIBLE
            binding.tvName.visibility = View.VISIBLE
            binding.tvUsername.visibility = View.VISIBLE
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}