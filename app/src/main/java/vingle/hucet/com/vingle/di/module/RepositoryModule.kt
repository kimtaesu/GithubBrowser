package vingle.hucet.com.vingle.di.module

import android.content.Context
import com.hucet.clean.gallery.inject.scopes.PerActivity
import dagger.Module
import dagger.Provides
import vingle.hucet.com.vingle.api.GithubDataSource
import vingle.hucet.com.vingle.repository.GithubRepository
import javax.inject.Singleton

/**
 * Created by taesu on 2017-11-10.
 */
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideGithubRepository(dataSource: GithubDataSource): GithubRepository {
        return GithubRepository(dataSource)
    }
}