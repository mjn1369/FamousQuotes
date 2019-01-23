package apps.mjn.remote.datasource

import apps.mjn.data.datasource.QuoteRemoteDataSource
import apps.mjn.data.entity.QuoteEntityList
import apps.mjn.remote.RemoteConstants
import apps.mjn.remote.extension.toRxSingle
import apps.mjn.remote.retrofit.QuoteAPI
import apps.mjn.remote.toQuoteListEntity
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class QuoteRemoteDataSourceImpl @Inject constructor(private val okHttpClient: OkHttpClient) : QuoteRemoteDataSource {

    private val api: QuoteAPI = Retrofit.Builder().baseUrl(RemoteConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(QuoteAPI::class.java)

    override fun getQuote(quoteType: String): Single<QuoteEntityList> {
        return api.getQuote(quoteType).toRxSingle().map { it.toQuoteListEntity() }
    }
}