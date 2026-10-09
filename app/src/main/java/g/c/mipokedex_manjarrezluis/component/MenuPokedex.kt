package g.c.mipokedex_manjarrezluis.component

import g.c.mipokedex_manjarrezluis.domain.Pokemon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuPokedex(
    pokemonList: List<Pokemon>,
    innerPadding: PaddingValues,
    onNavigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, contentPadding = innerPadding) {
        items(pokemonList, key = { it.number }) { pokemon ->
            PokemonRow(pokemon, Modifier.clickable { onNavigateToDetail(pokemon.number) })
        }
    }
}

@Composable
fun FavoritesRow(favoritesList: List<Pokemon>, onNavigateToDetail: (Int) -> Unit) {
    LazyRow {
        items(favoritesList, key = { it.number }) { pokemon ->
            FavoritePokemon(pokemon, onNavigateToDetail)
        }
    }
}

@Composable
fun PokedexGrid(
    pokemonList: List<Pokemon>,
    onNavigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(pokemonList, key = { it.number }) { pokemon ->
            PokemonCell(pokemon, Modifier.clickable { onNavigateToDetail(pokemon.number) })
        }
    }
}
