package com.example.book_library.data.repo

import com.example.book_library.data.local.UserDao
import com.example.book_library.data.models.UserEntity
import com.example.book_library.data.network.UserApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepo @Inject constructor(
    private var userDao: UserDao,
    private var userApi: UserApi
) {

    fun getUserFromApi() = userApi.getUsers()
        .subscribeOn(Schedulers.io())

}