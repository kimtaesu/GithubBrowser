package vingle.hucet.com.vingle.view

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.airbnb.deeplinkdispatch.DeepLink
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import vingle.hucet.com.vingle.R
import vingle.hucet.com.vingle.glide.GlideApp
import vingle.hucet.com.vingle.presenter.Github
import javax.inject.Inject

/**
 * Created by taesu on 2017-12-04.
 */
@DeepLink("testapp://repos/{userName}")
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, Github.View {

    @Inject lateinit var presenter: Github.Presenter

    @Inject lateinit var adapter: GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName = intent?.getStringExtra("userName")
        initRecycler()
        requestFetch(userName)
    }

    private fun initRecycler() {
        this.adapter.setGlideRequest(GlideApp.with(this))
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
        }
    }

    private fun requestFetch(userName: String?) {
        val param = userName ?: "jakewharton"
        presenter.getUserDesc(param)
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