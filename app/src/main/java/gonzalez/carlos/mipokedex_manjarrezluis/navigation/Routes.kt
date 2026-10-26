package gonzalez.carlos.mipokedex_manjarrezluis.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val pokemon: Int)

@Serializable
object PokemonHunt

@Serializable
object login

