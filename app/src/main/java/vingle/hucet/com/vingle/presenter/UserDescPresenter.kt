package vingle.hucet.com.vingle.presenter

import com.google.gson.Gson
import io.reactivex.schedulers.Schedulers
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.repository.GithubRepository
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
class UserDescPresenter(
        private val view: Github.View,
        private val repository: GithubRepository
) : Github.Presenter {

    override fun getUserDesc(userName: String) {
        repository.getUserDesc(userName)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    println(Gson().toJson(it))
                })
    }
}