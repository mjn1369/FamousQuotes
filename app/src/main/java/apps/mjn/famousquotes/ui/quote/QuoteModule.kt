package apps.mjn.famousquotes.ui.quote

import androidx.lifecycle.ViewModel
import apps.mjn.data.datasource.QuoteRemoteDataSource
import apps.mjn.data.repository.QuoteRepositoryImpl
import apps.mjn.domain.repository.QuoteRepository
import apps.mjn.remote.datasource.QuoteRemoteDataSourceImpl
import apps.mjn.famousquotes.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class QuoteModule {

    @ContributesAndroidInjector
    internal abstract fun quoteFragment(): QuoteFragment

    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun bindQuoteViewModel(quoteViewModel: QuoteViewModel): ViewModel

    @Binds
    abstract fun bindQuoteRemoteDataSource(quoteRemoteDataSourceImpl: QuoteRemoteDataSourceImpl): QuoteRemoteDataSource

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl): QuoteRepository
}