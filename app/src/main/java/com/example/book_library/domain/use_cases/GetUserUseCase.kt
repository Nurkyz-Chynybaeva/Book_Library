package com.example.book_library.domain.use_cases

import com.example.book_library.domain.models.User
//import io.reactivex.Single
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
//
//class GetUserUseCase @Inject constructor(
//    private val userRepo: UserRepo
//) {
//
//    operator fun invoke(): Single<List<User>> {
//        return userRepo.getUserFromApi()
//            .subscribeOn(Schedulers.io())
//            .map {
//                userRepo.saveUsersToDb(it.map { it.toUserEntity() })
//                it.map { it.toUser() }
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//
//    }
//}