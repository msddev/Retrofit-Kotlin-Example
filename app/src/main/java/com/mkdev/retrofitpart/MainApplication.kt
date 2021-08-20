package com.mkdev.retrofitpart

import android.app.Application
import com.mkdev.retrofitpart.di.appModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}