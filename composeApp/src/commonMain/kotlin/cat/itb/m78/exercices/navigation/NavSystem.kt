package cat.itb.m78.exercices.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.screens.Screen1
import cat.itb.m78.exercices.screens.Screen2
import kotlinx.serialization.Serializable

sealed class Destination()
{
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
    @Serializable
    data object Screen3
}

@Composable
fun NavSystem()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Screen1)
    {
        composable<Destination.Screen1>
        {
            Screen1(
                navigateToScreen2 = {navController.navigate(Destination.Screen2)}
            )
        }
        composable<Destination.Screen2>
        {
            Screen2(
                navigateToScreen1 = {navController.navigate(Destination.Screen1)}
            )
        }
    }
}