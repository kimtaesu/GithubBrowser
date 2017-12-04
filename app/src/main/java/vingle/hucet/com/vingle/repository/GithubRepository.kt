package vingle.hucet.com.vingle.repository

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.model.UserDesc
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
class GithubRepository(private val githubDatasource: GithubDataSource) {
    fun getUserDesc(userName: String): Flowable<UserDesc> {
        return githubDatasource.getUser(userName)
                .concatMap { userInfo ->
                    githubDatasource.getRepos(userName)
                            .map { repos ->
                                UserDesc(userInfo, repos)
                            }
                }
    }
}