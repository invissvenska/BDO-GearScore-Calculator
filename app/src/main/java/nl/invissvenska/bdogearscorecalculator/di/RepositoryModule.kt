package nl.invissvenska.bdogearscorecalculator.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import nl.invissvenska.bdogearscorecalculator.repository.BracketRepository
import timber.log.Timber

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(): BracketRepository {
        Timber.d("init repository")
        return BracketRepository()
    }
}