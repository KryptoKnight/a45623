package joseph.assessment.assignment.di

import joseph.assessment.assignment.BuildConfig
import joseph.assessment.assignment.domain.api.TandemApi
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val apiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://tandem2019.web.app")
            .client(get()).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        OkHttpClient.Builder().apply {
             readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)

        }.build()
    }

    single { get<Retrofit>().create(TandemApi::class.java) }

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BODY
            }

        }
    } bind Interceptor::class

    single { Dispatchers.IO }
}

