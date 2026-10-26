package gonzalez.carlos.mipokedex_manjarrezluis.utilities

import androidx.compose.ui.graphics.Color
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Bug
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.DarkGray
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Electric
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Fairy
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Fight
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Fire
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Flying
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Ghost
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Grass
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Ground
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Normal
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.OffWhite
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Poison
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Psych
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Rock
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.Water

fun getColorByType(type: String): Pair<Color,Color>{
    var color: Color
    var dark = true
    when{
        type.lowercase().contains("normal") -> color = Normal;
        type.lowercase().contains("electric") -> {
            color = Electric
            dark= false
        }
        type.lowercase().contains("water") -> {
            color = Water
        }
        type.lowercase().contains("fire") -> color = Fire
        type.lowercase().contains("fairy") -> {
            color = Fairy
            dark= false
        }
        type.lowercase().contains("grass") -> {
            color = Grass
        }
        type.lowercase().contains("psychic") -> {
            color = Psych
        }
        type.lowercase().contains("fighting") -> {
            color = Fight
            dark= false
        }
        type.lowercase().contains("ghost") -> color = Ghost
        type.lowercase().contains("bug") -> color = Bug
        type.lowercase().contains("poison") -> color = Poison
        type.lowercase().contains("ground") -> color = Ground
        type.lowercase().contains("rock") -> color = Rock
        type.lowercase().contains("flying") -> {
            color = Flying
            dark= false
        }
        else -> color=Normal
    }

    return Pair(color, if(dark) OffWhite else DarkGray)
}