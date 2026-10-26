package gonzalez.carlos.mipokedex_manjarrezluis.model.preferences.domain

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lastCaptured: Pokemon? = null

)
