package vingle.hucet.com.vingle.di.module

import com.hucet.clean.gallery.inject.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vingle.hucet.com.vingle.view.MainActivity

/**
 * Created by taesu on 2017-10-30.
 */
@Module
abstract class MainAcitivtyModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
    ))
    abstract fun bindMainActivity(): MainActivity
}