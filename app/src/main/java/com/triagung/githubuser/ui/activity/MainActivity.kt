package com.triagung.githubuser.ui.activity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.ActivityMainBinding
import com.triagung.githubuser.model.User
import com.triagung.githubuser.ui.adapter.UserAdapter
import com.triagung.githubuser.utils.Helpers
import com.triagung.githubuser.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), UserAdapter.Listener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        initView()
    }

    private fun initView() {
        val mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        mainViewModel.listUser.observe(this, { listUser -> setListData(listUser) })
        mainViewModel.isLoading.observe(this, { state -> showLoading(state) })
        mainViewModel.isEmpty.observe(this, { state -> showEmptyMessage(state) })

        userAdapter = UserAdapter(this)
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }

        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    val searchText = binding.etSearch.text.toString()
                    if (searchText.trim().isEmpty()) {
                        showAlertMessage()
                    } else {
                        mainViewModel.searchUser(binding.etSearch.text.toString())
                    }
                    Helpers.hideKeyboard(this)
                    true
                }
                else -> false
            }
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F
    }

    private fun setListData(listUser: List<User>) {
        userAdapter.setData(listUser)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.tvMessage.visibility = View.GONE
            binding.rvUser.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showEmptyMessage(isEmpty: Boolean) {
        if (isEmpty) {
            binding.tvMessage.text = getString(R.string.empty_message)
            binding.tvMessage.visibility = View.VISIBLE
            binding.rvUser.visibility = View.GONE
        } else {
            binding.tvMessage.visibility = View.GONE
            binding.rvUser.visibility = View.VISIBLE
        }
    }

    private fun showAlertMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Search field cannot be empty!")
        builder.setPositiveButton("Okay") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    override fun onItemClickListener(data: User) {
        Toast.makeText(this, data.login, Toast.LENGTH_SHORT).show()
    }
}