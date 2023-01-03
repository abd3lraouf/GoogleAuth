package dev.abd3lraouf.learn.googleauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.abd3lraouf.learn.googleauth.ui.navigation.SetupNavGraph
import dev.abd3lraouf.learn.googleauth.ui.theme.GoogleAuthTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GoogleAuthTheme {
        val navHostController = rememberNavController()
        SetupNavGraph(navHostController)
      }
    }
  }
}
