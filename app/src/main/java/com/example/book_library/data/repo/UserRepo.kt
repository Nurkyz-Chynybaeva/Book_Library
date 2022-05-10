package com.example.book_library.data.repo

import com.example.book_library.data.local.UserDao
import com.example.book_library.data.models.UserEntity
import com.example.book_library.data.network.UserApi
import javax.inject.Inject

class UserRepo @Inject constructor(
    private var userDao: UserDao,
    private var userApi: UserApi
) {

    fun getUserFromApi() = userApi.getUsers()

    fun saveUsersToDb(users: List<UserEntity>) = userDao.insertUsers(users)
}