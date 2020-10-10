package com.pado.machinetest

import android.app.Application
import com.pado.machinetest.Utils.Preferencemanager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp :Application() {
    override fun onCreate() {
        super.onCreate()
        Preferencemanager(this)
    }
}