package g.c.mipokedex_manjarrezluis.viewmodel

import g.c.mipokedex_manjarrezluis.domain.Pokemon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PokemonViewModel : ViewModel(){

    var wildPokemon by mutableStateOf<Pokemon?>(null)

    fun capturePokemon(){

    }
}