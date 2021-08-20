package com.mkdev.retrofitpart

import android.app.Application
import com.mkdev.retrofitpart.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }
}