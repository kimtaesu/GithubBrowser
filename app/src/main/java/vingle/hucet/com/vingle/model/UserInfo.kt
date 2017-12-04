package vingle.hucet.com.vingle.model

/**
 * Created by taesu on 2017-12-04.
 */
data class UserInfo(
        val login: String,
        val avatar_url: String
) : Basic() {
    override val viewType: ViewType
        get() = ViewType.USER
}
