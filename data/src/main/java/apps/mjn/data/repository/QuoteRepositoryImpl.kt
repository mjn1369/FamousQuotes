package apps.mjn.data.repository

import apps.mjn.data.datasource.QuoteRemoteDataSource
import apps.mjn.data.toQuoteList
import apps.mjn.domain.entity.QuoteList
import apps.mjn.domain.repository.QuoteRepository
import io.reactivex.Single
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteRemoteDataSource: QuoteRemoteDataSource
) : QuoteRepository {
    override fun getQuote(quoteType: String): Single<QuoteList> {
        return quoteRemoteDataSource.getQuote(quoteType).map { it.toQuoteList() }
    }

}