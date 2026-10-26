package gonzalez.carlos.mipokedex_manjarrezluis

import gonzalez.carlos.mipokedex_manjarrezluis.data.PokemonData
import gonzalez.carlos.mipokedex_manjarrezluis.data.PokemonRepository
import gonzalez.carlos.mipokedex_manjarrezluis.presentation.PokedexViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PokedexViewModelTest {

    @Test
    fun initialPokemon_isCharmander() {
        val viewModel = PokedexViewModel(FakePokemonRepository())

        assertEquals("Charmander", viewModel.uiState.value.selectedPokemon?.name)
        assertEquals("Bulbasaur", viewModel.uiState.value.previousPokemon?.name)
        assertEquals("Squirtle", viewModel.uiState.value.nextPokemon?.name)
    }

    @Test
    fun navigation_wrapsAroundTheList() {
        val viewModel = PokedexViewModel(FakePokemonRepository())

        viewModel.selectNext()
        assertEquals("Squirtle", viewModel.uiState.value.selectedPokemon?.name)

        viewModel.selectNext()
        assertEquals("Bulbasaur", viewModel.uiState.value.selectedPokemon?.name)

        viewModel.selectPrevious()
        assertEquals("Squirtle", viewModel.uiState.value.selectedPokemon?.name)
    }

    @Test
    fun favorites_areStoredByPokemon() {
        val viewModel = PokedexViewModel(FakePokemonRepository())

        assertFalse(viewModel.uiState.value.isSelectedFavorite)
        viewModel.toggleFavorite()
        assertTrue(viewModel.uiState.value.isSelectedFavorite)

        viewModel.selectPokemon(1)
        assertFalse(viewModel.uiState.value.isSelectedFavorite)

        viewModel.selectPokemon(2)
        assertTrue(viewModel.uiState.value.isSelectedFavorite)
    }
}

private class FakePokemonRepository : PokemonRepository {
    override fun getPokemon(): List<PokemonData> = listOf(
        pokemon(id = 1, name = "Bulbasaur"),
        pokemon(id = 2, name = "Charmander"),
        pokemon(id = 3, name = "Squirtle"),
    )

    private fun pokemon(id: Int, name: String) = PokemonData(
        id = id,
        number = "#$id",
        name = name,
        type = "Tipo",
        imageRes = R.drawable.charmander,
        accentColor = 0xFFE53935,
        height = "1 m",
        weight = "1 kg",
        ability = "Habilidad",
        description = "Descripción",
    )
}
