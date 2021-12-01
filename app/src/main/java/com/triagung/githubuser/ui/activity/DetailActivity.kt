package com.triagung.githubuser.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ActivityDetailBinding
import com.triagung.githubuser.model.User

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityDetailBinding

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        getDataDetail()
        initView()
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_round_arrow_back_ios_24)
            setNavigationOnClickListener { onBackPressed() }
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F
    }

    private fun getDataDetail() {
        user = intent.getParcelableExtra(EXTRA_USER) as User?
    }

    private fun initView() {
        binding.apply {
            user?.let { data ->
                ivUser.setImageResource(data.avatar)
                tvName.text = data.name
                tvUsername.text = data.username
                tvFollower.text = getString(R.string.followers, data.follower)
                tvFollowing.text = getString(R.string.following, data.following)
                tvLocation.text = data.location
                tvCompany.text = data.company
                tvRepository.text = getString(R.string.repository, data.repository)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}