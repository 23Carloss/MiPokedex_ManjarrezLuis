package g.c.mipokedex_manjarrezluis.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import g.c.mipokedex_manjarrezluis.R
import g.c.mipokedex_manjarrezluis.component.FavoritesRow
import g.c.mipokedex_manjarrezluis.component.MenuPokedex
import g.c.mipokedex_manjarrezluis.component.PokedexGrid
import g.c.mipokedex_manjarrezluis.data.getFavoritePokemons
import g.c.mipokedex_manjarrezluis.data.pokemonList
import g.c.mipokedex_manjarrezluis.theme.Blue
import g.c.mipokedex_manjarrezluis.theme.Green
import g.c.mipokedex_manjarrezluis.theme.LightBlue
import g.c.mipokedex_manjarrezluis.theme.LightGreen

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (Int) -> Unit) {
    var grid by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        Text("Pokémon favoritos")
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        Spacer(Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(if (grid) "Todos los Pokémon: cuadrícula" else "Todos los Pokémon: lista")
            Switch(
                checked = grid,
                onCheckedChange = { grid = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Color.Transparent
                ),
                thumbContent = {
                    Icon(
                        painter = painterResource(if (grid) R.drawable.grid else R.drawable.list),
                        contentDescription = if (grid) "Vista en cuadrícula" else "Vista en lista",
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
        }
        // Ambas vistas ocupan el espacio restante y comparten la navegación por ID.
        if (grid) {
            PokedexGrid(pokemonList, onNavigateToDetail, Modifier.weight(1f))
        } else {
            MenuPokedex(pokemonList, PaddingValues(0.dp), onNavigateToDetail, Modifier.weight(1f))
        }
    }
}
