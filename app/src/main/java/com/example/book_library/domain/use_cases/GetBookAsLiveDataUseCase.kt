package com.example.book_library.domain.use_cases

import com.example.book_library.data.local.BooksDao
import javax.inject.Inject

//class GetUserAsLiveDataUseCase @Inject constructor(
//    private val  repo: UserRepo
//) {
//    operator fun invoke(): LiveData<List<UserEntity>> {
//        return repo.getCharactersAsLive()
//    }
    class GetBookAsLiveDataUseCase @Inject constructor(private val booksDao: BooksDao) {
        operator fun invoke() = booksDao.getAll()
    }
//}