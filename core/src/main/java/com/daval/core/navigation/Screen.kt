package com.daval.core.navigation

sealed class Screen(val route: String) {
    object CharacterListScreen : Screen("character_list_screen")
    object DetailCharacterScreen : Screen("detail_character_screen")
}
