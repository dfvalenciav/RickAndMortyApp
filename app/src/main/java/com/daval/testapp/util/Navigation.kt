package com.daval.rickandmarti.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.daval.character.presentation.RecipeListScreen
import com.daval.character_detail.presentation.DetailRecipeScreen
import com.daval.core.navigation.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CharacterListScreen.route
    ) {
        composable(Screen.CharacterListScreen.route) {
            RecipeListScreen(navController)
        }
        composable(Screen.DetailCharacterScreen.route) {
            DetailRecipeScreen(navController)
        }
    }
}