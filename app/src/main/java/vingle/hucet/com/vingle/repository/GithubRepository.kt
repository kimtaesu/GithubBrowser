package vingle.hucet.com.vingle.repository

import io.reactivex.Flowable
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.model.Basic

/**
 * Created by taesu on 2017-12-04.
 */
class GithubRepository(private val githubDatasource: GithubDataSource) {
    fun getUserDesc(userName: String): Flowable<List<Basic>> {
        return githubDatasource.getUser(userName)
                .concatMap { userInfo ->
                    githubDatasource.getRepos(userName)
                            .map {
                                it.sortedByDescending { it.stargazers_count }
                            }
                            .map { repos ->
                                val list = ArrayList<Basic>()
                                list.add(userInfo)
                                list.addAll(repos)
                                list
                            }
                }
    }
}