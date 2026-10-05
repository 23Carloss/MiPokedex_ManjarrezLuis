package gonzalez.carlos.mipokedex_manjarrezluis.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gonzalez.carlos.mipokedex_manjarrezluis.data.pokemonList

@Composable
fun MenuPokedex(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text("Pokédex", style = MaterialTheme.typography.headlineLarge)
            }
            items(pokemonList, key = { it.number }) { pokemon ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Image(
                                painter = painterResource(pokemon.image),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text("#${pokemon.number} ${pokemon.name}", style = MaterialTheme.typography.titleLarge)
                                Text(pokemon.type, style = MaterialTheme.typography.bodyMedium)
                            }
                            if (pokemon.favorite) {
                                Text("★", color = MaterialTheme.colorScheme.primary)
                            }
                        }
                        Text(pokemon.description)
                        Text("Altura: ${pokemon.height} m · Peso: ${pokemon.weight} kg")
                        Text("Habilidad: ${pokemon.ability}")
                        if (pokemon.favorite) Text("Favorito", style = MaterialTheme.typography.labelMedium)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    MaterialTheme {
        MenuPokedex()
    }
}
