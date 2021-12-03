package com.triagung.githubuser.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.triagung.githubuser.R
import com.triagung.githubuser.databinding.FragmentFollowBinding
import com.triagung.githubuser.model.User
import com.triagung.githubuser.ui.activity.DetailActivity
import com.triagung.githubuser.ui.adapter.UserAdapter
import com.triagung.githubuser.viewmodel.FollowMainModel

class FollowFragment : Fragment(), UserAdapter.Listener {
    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_USERNAME = "username"

        fun newInstance(index: Int, username: String) = FollowFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_SECTION_NUMBER, index)
                putString(ARG_USERNAME, username)
            }
        }
    }

    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!

    private lateinit var userAdapter: UserAdapter

    private var emptyMessage: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followMainModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(FollowMainModel::class.java)

        followMainModel.listFollowers.observe(
            viewLifecycleOwner, { listFollowers -> setDataFollowers(listFollowers) }
        )

        followMainModel.listFollowing.observe(
            viewLifecycleOwner, { listFollowing -> setDataFollowing(listFollowing) }
        )

        followMainModel.isLoading.observe(viewLifecycleOwner, { state -> isLoading(state) })

        val username = arguments?.getString(ARG_USERNAME) as String
        when (arguments?.getInt(ARG_SECTION_NUMBER, 0)) {
            0 -> {
                followMainModel.getFollowers(username)
                emptyMessage = getString(R.string.no_followers)
            }
            1 -> {
                followMainModel.getFollowing(username)
                emptyMessage = getString(R.string.no_following)
            }
        }

        userAdapter = UserAdapter(this)
        binding.apply {
            rvFollow.layoutManager = LinearLayoutManager(requireContext())
            rvFollow.setHasFixedSize(true)
            rvFollow.adapter = userAdapter
        }
    }

    private fun setDataFollowers(listFollowers: List<User>) {
        if (listFollowers.isNotEmpty()) {
            userAdapter.setData(listFollowers)
        } else {
            showEmptyMessage(emptyMessage)
        }
    }

    private fun setDataFollowing(listFollowing: List<User>) {
        if (listFollowing.isNotEmpty()) {
            userAdapter.setData(listFollowing)
        } else {
            showEmptyMessage(emptyMessage)
        }
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showEmptyMessage(message: String) {
        binding.tvMessage.visibility = View.VISIBLE
        binding.tvMessage.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClickListener(data: User) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_USERNAME, data.login)
        startActivity(intent)
    }
}