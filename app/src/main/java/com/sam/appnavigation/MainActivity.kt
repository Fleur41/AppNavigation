package com.sam.appnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sam.appnavigation.navigation.AppNavigation
import com.sam.appnavigation.ui.theme.AppNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigationTheme {
                AppNavigation()
            }
        }
    }
}

