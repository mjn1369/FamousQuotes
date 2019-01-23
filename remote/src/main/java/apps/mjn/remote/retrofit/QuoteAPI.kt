package apps.mjn.remote.retrofit

import apps.mjn.remote.dto.QuoteListDTO
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface QuoteAPI {
    @POST(".")
    fun getQuote(@Query("cat") cat: String): Call<QuoteListDTO>
}