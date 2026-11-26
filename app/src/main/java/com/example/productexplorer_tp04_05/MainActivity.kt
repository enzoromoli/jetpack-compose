package com.example.productexplorer_tp04_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.productexplorer_tp04_05.data.sampleProduct
import com.example.productexplorer_tp04_05.ui.screen.ProductHomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductHomeScreen(
                        featuredProduct = sampleProduct(),
                        onFeaturedProductClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
