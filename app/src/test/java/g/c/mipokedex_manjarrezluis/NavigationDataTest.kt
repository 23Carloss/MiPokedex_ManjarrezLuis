package g.c.mipokedex_manjarrezluis

import g.c.mipokedex_manjarrezluis.data.getPokemonByNumber
import g.c.mipokedex_manjarrezluis.data.pokemonList
import g.c.mipokedex_manjarrezluis.navigation.PokemonDetail
import g.c.mipokedex_manjarrezluis.navigation.PokemonList
import org.junit.Assert.*
import org.junit.Test

@OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
class NavigationDataTest {
    @Test
    fun navigationRoutesHaveGeneratedSerializers() {
        assertEquals("g.c.mipokedex_manjarrezluis.navigation.PokemonList",
            PokemonList.serializer().descriptor.serialName)
        assertEquals("pokemon", PokemonDetail.serializer().descriptor.getElementName(0))
    }

    @Test
    fun unknownPokemonDoesNotThrow() {
        assertNull(getPokemonByNumber(-1))
        assertNull(getPokemonByNumber(Int.MAX_VALUE))
    }

    @Test
    fun everyDisplayedPokemonCanBeResolvedByUniqueId() {
        assertEquals(pokemonList.size, pokemonList.map { it.number }.distinct().size)
        pokemonList.forEach { assertEquals(it, getPokemonByNumber(it.number)) }
    }
}
