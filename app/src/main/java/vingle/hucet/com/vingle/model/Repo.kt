package vingle.hucet.com.vingle.model

/**
 * Created by taesu on 2017-12-04.
 */
data class Repo(
        val name: String,
        val description: String,
        val stargazers_count: Long
) : Basic()