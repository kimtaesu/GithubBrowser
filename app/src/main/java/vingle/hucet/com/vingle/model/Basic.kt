package vingle.hucet.com.vingle.model

/**
 * Created by taesu on 2017-12-04.
 */

enum class ViewType(val type: Int) {
    USER(0), REPO(1)
}

abstract class Basic {
    abstract val viewType: ViewType
}