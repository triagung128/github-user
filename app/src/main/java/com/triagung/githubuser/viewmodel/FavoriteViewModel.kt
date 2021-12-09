package com.triagung.githubuser.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.triagung.githubuser.model.UserDetail
import com.triagung.githubuser.repository.UserRepository

class FavoriteViewModel(application: Application) : ViewModel() {
    private var userRepository: UserRepository = UserRepository(application)

    fun getAllUser(): LiveData<List<UserDetail>> = userRepository.getAllUser()
}