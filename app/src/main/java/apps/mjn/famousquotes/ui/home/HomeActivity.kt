package apps.mjn.famousquotes.ui.home

import android.os.Bundle
import apps.mjn.famousquotes.R
import apps.mjn.famousquotes.extensions.inTransaction
import apps.mjn.famousquotes.ui.quote.QuoteFragment
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager.inTransaction {
            replace(
                R.id.contentFrame,
                QuoteFragment.getInstance()
            )
        }
    }
}
