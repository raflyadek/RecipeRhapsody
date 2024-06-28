package com.example.reciperhapsody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reciperhapsody.screen.homescreen.RecipeHomeScreen
import com.example.reciperhapsody.ui.theme.RecipeRhapsodyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() { 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeRhapsodyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                ) {
                    composable("home_screen") {
                        RecipeHomeScreen(navController = navController)
                    }
                    composable("detail_screen") {

                    }
                    composable("create_screen") {

                    }
                    composable("favorite_screen") {

                    }
                    composable("randomize_screen") {

                    }
                }
            }
        }
    }
}

