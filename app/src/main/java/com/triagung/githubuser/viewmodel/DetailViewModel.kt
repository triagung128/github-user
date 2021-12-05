package com.triagung.githubuser.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triagung.githubuser.model.User
import com.triagung.githubuser.model.UserDetail
import com.triagung.githubuser.network.ApiConfig
import com.triagung.githubuser.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(application: Application) : ViewModel() {

    companion object {
        private const val TAG = "DetailViewModel"
    }

    private val _detailUser = MutableLiveData<UserDetail>()
    val detailUser: LiveData<UserDetail> = _detailUser

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetailUser(username: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getUserDetail(username)
        client.enqueue(object : Callback<UserDetail> {
            override fun onResponse(call: Call<UserDetail>, response: Response<UserDetail>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _detailUser.value = response.body()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserDetail>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private val userRepository: UserRepository = UserRepository(application)

    fun getUserByUsername(username: String): LiveData<User> =
        userRepository.getUserByUsername(username)

    fun insert(user: User) {
        userRepository.insert(user)
    }

    fun delete(user: User) {
        userRepository.delete(user)
    }
}