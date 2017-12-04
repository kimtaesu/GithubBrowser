package vingle.hucet.com.vingle.fixture

import vingle.hucet.com.vingle.model.Repo
import vingle.hucet.com.vingle.model.UserDesc
import vingle.hucet.com.vingle.model.UserInfo

/**
 * Created by taesu on 2017-12-04.
 */
object GithubFixture {

    fun userInfo(
            login: String = "",
            avatar_url: String = ""
    ): UserInfo = UserInfo(login, avatar_url)

    fun userDesc(
            userInfo: UserInfo = userInfo(),
            repo: List<Repo> = listOf()
    ): UserDesc {
        return UserDesc(userInfo, repo)
    }
}