package vingle.hucet.com.vingle.presenter

import android.arch.lifecycle.LifecycleObserver

/**
 * Created by taesu on 2017-12-04.
 */
interface Github {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showError()
    }

    interface Presenter : LifecycleObserver {
        fun getUserDesc(userName: String)
    }
}
