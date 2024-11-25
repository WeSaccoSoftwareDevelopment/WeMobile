package com.mobilewe.wemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.icerock.moko.geo.LocationTracker
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val locationTracker by inject<LocationTracker>()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        locationTracker.bind(lifecycle, this, supportFragmentManager)
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}