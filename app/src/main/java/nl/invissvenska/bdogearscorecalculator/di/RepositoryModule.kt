package nl.invissvenska.bdogearscorecalculator.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

//    @Provides
//    @ActivityRetainedScoped
//    fun provideMainRepository(): BracketRepository {
//        Timber.d("init repository")
//        return BracketRepository()
//    }
}