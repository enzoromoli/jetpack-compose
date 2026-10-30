package com.example.tp4.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.tp4.data.sampleProduct
import com.example.tp4.model.ProductUi
import com.example.tp4.ui.component.ProductHeader
import com.example.tp4.ui.component.ProductImage
import com.example.tp4.ui.component.ProductPriceCard
import com.example.tp4.ui.component.ProductRating

@Composable
fun ProductDetailScreen(
    product: ProductUi,
    onAddToCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProductImage(
            productTitle = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        ProductHeader(
            title = product.title,
            brand = product.brand,
            category = product.category
        )
        ProductPriceCard(
            price = product.price,
            discountPercentage = product.discountPercentage,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        ProductRating(
            rating = product.rating,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = product.description)

        Button(onClick = onAddToCartClick) {
            Text(text = "Ajouter au panier")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    GreetingCardTheme {
        ProductDetailScreen(
            product = sampleProduct(),
            onAddToCartClick = {}
        )
    }
}
