package gonzalez.carlos.mipokedex_manjarrezluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, PokedexList::class.java))
        finish()
    }
}
