package g.c.mipokedex_manjarrezluis.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import g.c.mipokedex_manjarrezluis.data.getPokemonByNumber

@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemon: Int) {
    // Una ruta con un ID inexistente muestra un mensaje en lugar de lanzar una excepción.
    val selectedPokemon = getPokemonByNumber(pokemon)
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding)
            .verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (selectedPokemon == null) {
            Text("Pokémon no encontrado (ID: $pokemon)")
        } else {
            Text(selectedPokemon.name, style = MaterialTheme.typography.headlineMedium)
            Image(
                painter = painterResource(selectedPokemon.image),
                contentDescription = selectedPokemon.name,
                modifier = Modifier.fillMaxWidth().height(220.dp),
                contentScale = ContentScale.Fit
            )
            Text("Número: ${selectedPokemon.number}")
            Text("Tipo: ${selectedPokemon.type}")
            Text(selectedPokemon.description)
            Text("Altura: ${selectedPokemon.height} m")
            Text("Peso: ${selectedPokemon.weight} kg")
            Text("Habilidad: ${selectedPokemon.ability}")
            Text(if (selectedPokemon.favorite) "Favorito" else "No es favorito")
        }
    }
}
