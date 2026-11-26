package com.example.productexplorer_tp08.data

import com.example.productexplorer_tp08.model.ProductUi

fun sampleProducts(): List<ProductUi> {
    return listOf(
        ProductUi(id = 1, title = "Smartphone Toto X", brand = "TotoTech", category = "Smartphones", price = 699.99, stock = 34),
        ProductUi(id = 2, title = "Casque Audio Pulse", brand = "SoundPeak", category = "Audio", price = 129.99, stock = 0),
        ProductUi(id = 3, title = "Ordinateur Portable Air 14", brand = "NovaBook", category = "Ordinateurs", price = 999.00, stock = 12),
        ProductUi(id = 4, title = "Montre Connectée Fit", brand = "TotoTech", category = "Accessoires", price = 199.90, stock = 0),
        ProductUi(id = 5, title = "Enceinte Bluetooth Mini", brand = "SoundPeak", category = "Audio", price = 49.99, stock = 58)
    )
}

fun sampleCategories(): List<String> {
    return listOf("Smartphones", "Audio", "Ordinateurs", "Accessoires")
}
