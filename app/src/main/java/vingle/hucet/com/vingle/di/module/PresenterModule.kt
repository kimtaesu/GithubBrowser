package vingle.hucet.com.vingle.di.module

import android.content.Context
import com.hucet.clean.gallery.inject.scopes.PerActivity
import dagger.Module
import dagger.Provides
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.presenter.Github
import vingle.hucet.com.vingle.presenter.UserDescPresenter
import vingle.hucet.com.vingle.repository.GithubRepository
import vingle.hucet.com.vingle.view.MainActivity

/**
 * Created by taesu on 2017-11-10.
 */
@Module
class PresenterModule {
    @Provides
    @PerActivity

    fun provideUserDescPresenter(view: Github.View, repository: GithubRepository): Github.Presenter =
            UserDescPresenter(view, repository)

    @Provides
    @PerActivity
    fun provideGithubView(mainActivity: MainActivity): Github.View = mainActivity

}