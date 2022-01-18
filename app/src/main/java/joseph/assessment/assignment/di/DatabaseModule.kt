package joseph.assessment.assignment.di

import androidx.room.Room
import joseph.assessment.assignment.BuildConfig
import joseph.assessment.assignment.domain.api.TandemApi
import joseph.assessment.assignment.domain.db.AppRoomDatabase
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val dbModule = module {
    single {
        Room.databaseBuilder(get(), AppRoomDatabase::class.java, "db_file")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppRoomDatabase>().getMemberDAO()
    }
}