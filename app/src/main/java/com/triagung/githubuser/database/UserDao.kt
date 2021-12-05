package com.triagung.githubuser.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.triagung.githubuser.model.UserDetail

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserDetail)

    @Delete
    fun delete(user: UserDetail)

    @Query("SELECT * FROM userdetail WHERE login = :login LIMIT 1")
    fun getUserByUsername(login: String): LiveData<UserDetail>
}