package apps.mjn.data.datasource

import apps.mjn.data.entity.QuoteEntityList
import io.reactivex.Single

interface QuoteRemoteDataSource {

    fun getQuote(quoteType: String): Single<QuoteEntityList>

}