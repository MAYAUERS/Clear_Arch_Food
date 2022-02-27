package com.example.cleararch27feb

import android.app.Application
import com.example.cleararch27feb.di.dataModule
import com.example.cleararch27feb.di.domainModule
import com.example.cleararch27feb.di.presentationModule
import com.example.cleararch27feb.di.restrofitModule
import org.koin.core.context.startKoin

class BaseApplication :Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(restrofitModule, dataModule, domainModule, presentationModule))
        }
    }


}