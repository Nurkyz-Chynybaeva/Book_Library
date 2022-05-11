package com.example.book_library.domain.use_cases

import com.example.book_library.data.models.UserDto
import com.example.book_library.data.repo.UserRepo
import com.example.book_library.domain.models.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepo: UserRepo
) {
    operator fun invoke(): Single<List<UserDto>> {
        return userRepo.getUserFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}