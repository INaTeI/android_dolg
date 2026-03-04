package com.example.android_dolg.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            PeopleScreen(
                onClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")!!
            DetailScreen(id = id)
        }
    }
}