package br.fiap.spacenauts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.fiap.spacenauts.navigation.AppNavigation
import br.fiap.spacenauts.ui.theme.SpacenautTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpacenautTheme {
                AppNavigation()
            }
        }
    }
}




