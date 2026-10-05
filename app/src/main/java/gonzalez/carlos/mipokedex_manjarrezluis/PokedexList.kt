package gonzalez.carlos.mipokedex_manjarrezluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import gonzalez.carlos.mipokedex_manjarrezluis.components.MenuPokedex

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MenuPokedex()
            }
        }
    }
}
