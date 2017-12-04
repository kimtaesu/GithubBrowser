package vingle.hucet.com.vingle.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import vingle.hucet.com.vingle.R
import vingle.hucet.com.vingle.presenter.Github
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, Github.View {

    @Inject lateinit var presenter: Github.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         TODO Remove Test code
        presenter.getUserDesc("kimtaesu")
    }

    override fun showProgress() {
//        TODO
    }

    override fun hideProgress() {
        //        TODO
    }

    override fun showError() {
        //        TODO
    }

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}