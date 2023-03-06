package com.example.pagingappv3

import android.app.Application
import android.net.Uri
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    companion object{
        public var count = 0;
    }
}