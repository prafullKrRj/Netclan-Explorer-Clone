package com.prafull.netclanexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.prafull.netclanexplorer.ui.theme.NetClanExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetClanExplorerTheme {
                Surface(Modifier.fillMaxSize()) {
                    NavGraph()
                }
            }
        }
    }
}
fun NavController.navigateAndPopBackStack(route: String) {
    popBackStack()
    navigate(route)
}