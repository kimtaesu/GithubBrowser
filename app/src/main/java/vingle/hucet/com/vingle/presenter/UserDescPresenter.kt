package vingle.hucet.com.vingle.presenter

import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.repository.GithubRepository
import vingle.hucet.com.vingle.view.GithubAdapter
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
class UserDescPresenter(
        private val view: Github.View,
        private val repository: GithubRepository,
        private val adapter: GithubAdapter
) : Github.Presenter {

    override fun getUserDesc(userName: String) {
        repository.getUserDesc(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.update(it)
                })
    }
}