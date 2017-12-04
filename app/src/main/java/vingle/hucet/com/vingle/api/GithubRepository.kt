package vingle.hucet.com.vingle.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import vingle.hucet.com.vingle.model.Repos
import vingle.hucet.com.vingle.model.UserInfo

/**
 * Created by taesu on 2017-12-04.
 */
interface GithubRepository {
    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Flowable<UserInfo>

    @GET("users/{username}/repos")
    fun getRepos(@Path("username") login: String): Flowable<Repos>
}

