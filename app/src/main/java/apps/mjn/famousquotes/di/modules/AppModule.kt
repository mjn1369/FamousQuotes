package apps.mjn.famousquotes.di.modules

import android.content.Context
import apps.mjn.domain.executor.PostExecutionThread
import apps.mjn.domain.executor.UseCaseExecutor
import apps.mjn.famousquotes.core.FamousQuotesApplication
import apps.mjn.famousquotes.executor.ExecutorThread
import apps.mjn.famousquotes.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: FamousQuotesApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor = ExecutorThread()

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread = UIThread()

}