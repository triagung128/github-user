package com.triagung.githubuser.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.triagung.githubuser.database.UserDao
import com.triagung.githubuser.database.UserRoomDatabase
import com.triagung.githubuser.model.UserDetail
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepository(application: Application) {
    private val userDao: UserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = UserRoomDatabase.getDatabase(application)
        userDao = db.userDao()
    }

    fun getAllUser() : LiveData<List<UserDetail>> = userDao.getAllUser()

    fun getUserByUsername(username: String): LiveData<UserDetail> =
        userDao.getUserByUsername(username)

    fun insert(user: UserDetail) {
        executorService.execute { userDao.insert(user) }
    }

    fun delete(user: UserDetail) {
        executorService.execute { userDao.delete(user) }
    }
}