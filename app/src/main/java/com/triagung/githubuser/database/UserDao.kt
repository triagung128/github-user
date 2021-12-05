package com.triagung.githubuser.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.triagung.githubuser.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE login = :login LIMIT 1")
    fun getUserByUsername(login: String): LiveData<User>
}