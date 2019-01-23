package apps.mjn.famousquotes.di.modules

import androidx.lifecycle.ViewModelProvider
import apps.mjn.famousquotes.core.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}