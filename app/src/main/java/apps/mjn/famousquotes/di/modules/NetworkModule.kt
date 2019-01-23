package apps.mjn.famousquotes.di.modules

import apps.mjn.famousquotes.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if(BuildConfig.DEBUG){
                level = HttpLoggingInterceptor.Level.BASIC
            }
        }
    }

    @Singleton
    @Provides
    fun provideAuthorizationInterceptor(): Interceptor {
        return Interceptor{
            val request = it.request().newBuilder().addHeader("X-RapidAPI-Key", "75ea69d4damsh68652e803b1b61cp1788c8jsne247dd0e4d41").build()
            it.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authorizationInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authorizationInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
}