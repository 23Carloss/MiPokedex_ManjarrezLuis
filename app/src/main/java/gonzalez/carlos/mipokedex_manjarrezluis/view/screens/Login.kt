package gonzalez.carlos.mipokedex_manjarrezluis.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import gonzalez.carlos.mipokedex_manjarrezluis.viewModel.UserViewModel

@Composable
fun LoginScreen(innerPadding: PaddingValues,
                onNavigateToMenu: () -> Unit,
                viewModel: UserViewModel = viewModel(),
                setSuccesfulLogin: (username: String, mail: String) -> Unit
               ){
    var user by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }

    Column(){

        TextField(value= user,label = Text("Correo Electronico"),
            onValueChange = {it-> user = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        TextField(value = password, onValueChange = {it-> password = it},
            label = Text("Correo Electronico"),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Button(onClick={}){
            Text("Iniciar Sesion")
        }
    }
}

