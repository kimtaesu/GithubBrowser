package vingle.hucet.com.vingle.di.module

import com.hucet.clean.gallery.inject.scopes.PerActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import vingle.hucet.com.vingle.glide.GlideApp
import vingle.hucet.com.vingle.glide.GlideRequests
import vingle.hucet.com.vingle.view.GithubAdapter
import vingle.hucet.com.vingle.view.MainActivity

/**
 * Created by taesu on 2017-10-30.
 */
@Module
abstract class MainAcitivtyModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModule::class,
            AdapterModule::class
    ))
    abstract fun bindMainActivity(): MainActivity


}