package gonzalez.carlos.mipokedex_manjarrezluis.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import g.c.mipokedex_manjarrezluis.domain.Pokemon
import gonzalez.carlos.mipokedex_manjarrezluis.model.data.pokemonList

class PokemonViewModel : ViewModel() {

    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set
    var capturedPokemon by mutableStateOf(listOf<Pokemon>())
        private set
    var gonePokemon by mutableStateOf(false)
        private set
    var isPokemonCaptured by mutableStateOf(false)
        private set
    fun searchPokemon(){
        wildPokemon = pokemonList.random()
        isPokemonCaptured = false
    }


    fun capturePokemon(){
        wildPokemon?.let {
            var isCaptured = (1..2).random()
            if(isCaptured == 1){
                capturedPokemon = capturedPokemon + it
                gonePokemon = false
                wildPokemon = null
                isPokemonCaptured = true
        }
        else{
                gonePokemon = true
                wildPokemon = null
                isPokemonCaptured = false

            }
        }
    }
}