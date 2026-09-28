package gonzalez.carlos.mipokedex_manjarrezluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import gonzalez.carlos.mipokedex_manjarrezluis.ui.PokedexRoute
import gonzalez.carlos.mipokedex_manjarrezluis.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PokedexTheme {
                PokedexRoute()
            }
        }
    }
}
