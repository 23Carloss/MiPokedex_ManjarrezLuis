package gonzalez.carlos.mipokedex_manjarrezluis.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gonzalez.carlos.mipokedex_manjarrezluis.view.screens.MenuPokedexScreen
import g.c.mipokedex_manjarrezluis.screens.PokemonDetailScreen
import g.c.mipokedex_manjarrezluis.screens.PokemonHuntScreen
import gonzalez.carlos.mipokedex_manjarrezluis.model.data.getPokemonByNumber
import gonzalez.carlos.mipokedex_manjarrezluis.view.screens.LoginScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    val navigateToDetail = {id: Int -> navController.navigate(route = PokemonDetail(id))}
    val navigateToMenu = {
        navController.navigate(PokemonList)
    }

    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding,
                onNavigateToDetail =
                    {id-> navController.navigate(route = PokemonDetail(id))
                },
                onNavigateToHunt= {navController.navigate(route = PokemonHunt)}
                )
        }
        composable<PokemonDetail>(){
            val pokemon = it.arguments?.getInt("pokemon")?: -1
            PokemonDetailScreen(innerPadding, pokemon)
        }
        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding)
        }
        composable<login> {
            LoginScreen(innerPadding, navigateToMenu)
        }
    }
}