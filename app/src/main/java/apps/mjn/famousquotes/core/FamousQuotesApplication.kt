package apps.mjn.famousquotes.core

import apps.mjn.famousquotes.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FamousQuotesApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}