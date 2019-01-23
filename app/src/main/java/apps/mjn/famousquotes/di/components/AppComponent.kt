package apps.mjn.famousquotes.di.components

import apps.mjn.famousquotes.core.FamousQuotesApplication
import apps.mjn.famousquotes.di.modules.AppModule
import apps.mjn.famousquotes.di.modules.NetworkModule
import apps.mjn.famousquotes.di.modules.ViewModelModule
import apps.mjn.famousquotes.ui.home.HomeModule
import apps.mjn.famousquotes.ui.quote.QuoteModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        QuoteModule::class,
        HomeModule::class
    ]
)

interface AppComponent: AndroidInjector<FamousQuotesApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<FamousQuotesApplication>()
}