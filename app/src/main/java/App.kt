import android.app.Application
import joseph.assessment.assignment.di.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                apiModule
            )
        }
    }

}