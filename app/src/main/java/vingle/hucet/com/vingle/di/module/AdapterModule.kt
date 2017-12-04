package vingle.hucet.com.vingle.di.module

import com.hucet.clean.gallery.inject.scopes.PerActivity
import dagger.Module
import dagger.Provides
import vingle.hucet.com.vingle.glide.GlideApp
import vingle.hucet.com.vingle.glide.GlideRequests
import vingle.hucet.com.vingle.presenter.Github
import vingle.hucet.com.vingle.presenter.UserDescPresenter
import vingle.hucet.com.vingle.repository.GithubRepository
import vingle.hucet.com.vingle.view.GithubAdapter
import vingle.hucet.com.vingle.view.MainActivity

/**
 * Created by taesu on 2017-12-04.
 */
@Module
class AdapterModule {

    @PerActivity
    @Provides
    fun provideAdapter(): GithubAdapter = GithubAdapter()
}