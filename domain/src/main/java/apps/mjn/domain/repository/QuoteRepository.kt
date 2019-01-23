package apps.mjn.domain.repository

import apps.mjn.domain.entity.QuoteList
import io.reactivex.Single

interface QuoteRepository {
    fun getQuote(quoteType: String): Single<QuoteList>
}