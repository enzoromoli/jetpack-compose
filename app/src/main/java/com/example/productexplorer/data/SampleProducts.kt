package com.example.productexplorer.data

import com.example.productexplorer.model.ProductUi

fun sampleProduct(): ProductUi {
    return ProductUi(
        id = 1,
        title = "Smartphone Toto X",
        brand = "TotoTech",
        category = "Smartphones",
        description = "Un smartphone léger avec un écran lumineux, une bonne autonomie et un design moderne.",
        price = 699.99,
        discountPercentage = 12.5,
        rating = 4.6,
        stock = 34,
        warrantyInformation = "Garantie constructeur : 2 ans",
        shippingInformation = "Livraison estimée : 3 à 5 jours ouvrés"
    )
}

fun sampleProductOutOfStock(): ProductUi {
    return ProductUi(
        id = 2,
        title = "Casque Audio Pulse",
        brand = "SoundPeak",
        category = "Audio",
        description = "Un casque confortable conçu pour écouter de la musique, " +
                "suivre des cours en ligne et travailler dans de bonnes conditions.",
        price = 129.99,
        discountPercentage = 8.0,
        rating = 4.2,
        stock = 0,
        warrantyInformation = "Garantie constructeur : 1 an",
        shippingInformation = "Produit temporairement indisponible"
    )
}

fun sampleProducts(): List<ProductUi> {
    return listOf(
        sampleProduct(),
        sampleProductOutOfStock(),
        ProductUi(
            id = 3,
            title = "Ordinateur Portable Air 14",
            brand = "NovaBook",
            category = "Ordinateurs",
            description = "Un ordinateur fin et léger pour les cours et le développement.",
            price = 999.00,
            discountPercentage = 5.0,
            rating = 4.5,
            stock = 12,
            warrantyInformation = "Garantie constructeur : 2 ans",
            shippingInformation = "Livraison estimée : 2 à 4 jours ouvrés"
        ),
        ProductUi(
            id = 4,
            title = "Montre Connectée Fit",
            brand = "TotoTech",
            category = "Accessoires",
            description = "Une montre connectée pour suivre son activité au quotidien.",
            price = 199.90,
            discountPercentage = 10.0,
            rating = 4.1,
            stock = 0,
            warrantyInformation = "Garantie constructeur : 1 an",
            shippingInformation = "Produit temporairement indisponible"
        ),
        ProductUi(
            id = 5,
            title = "Enceinte Bluetooth Mini",
            brand = "SoundPeak",
            category = "Audio",
            description = "Une petite enceinte portable avec un son clair.",
            price = 49.99,
            discountPercentage = 0.0,
            rating = 4.3,
            stock = 58,
            warrantyInformation = "Garantie constructeur : 1 an",
            shippingInformation = "Livraison estimée : 3 à 5 jours ouvrés"
        )
    )
}

fun sampleCategories(): List<String> {
    return listOf("Smartphones", "Audio", "Ordinateurs", "Accessoires")
}
