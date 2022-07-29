package com.sevban.profilewithsplasscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sevban.profilewithsplasscreen.composables.HeadCardView
import com.sevban.profilewithsplasscreen.model.Portfolio
import com.sevban.profilewithsplasscreen.ui.theme.ProfileWithSplasScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ProfileWithSplasScreenTheme {

                val portfolioList = arrayListOf<Portfolio>(
                    Portfolio("Project 1", "TradeJournal app."),
                    Portfolio("Project 2", "Cv app."),
                    Portfolio("Project 3", "FoodBook app."),
                    Portfolio("Project 4", "journal app."),
                    Portfolio("Project 5", "İngredients app.")
                )
                    HeadCardView(portfolioList)
            }
        }
    }
}
