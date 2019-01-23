package apps.mjn.famousquotes.ui.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {
    @ContributesAndroidInjector
    internal abstract fun homeActivity(): HomeActivity
}