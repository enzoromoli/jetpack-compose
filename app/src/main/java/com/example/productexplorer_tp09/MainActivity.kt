package com.example.productexplorer_tp09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.productexplorer_tp09.data.sampleProducts
import com.example.productexplorer_tp09.ui.screen.ProductCatalogScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductCatalogScreen(
                        products = sampleProducts(),
                        onProductClick = {
                            // Plus tard : ouvrir le détail du produit
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
