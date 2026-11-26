# Product Explorer

Application Compose de catalogue de produits avec des données locales.

## Écrans

- `ProductCatalogContainer` / `ProductCatalogScreen` — catalogue interactif (lancé au démarrage) : recherche, filtre « en stock », favoris. Le container possède l'état, l'écran est stateless.
- `ProductHomeScreen` — écran d'accueil : en-tête, barre de recherche visuelle, produit mis en avant, catégories, offre du jour.
- `ProductDetailScreen` — écran de détail d'un produit.

## Structure

```
productexplorer/
├── MainActivity.kt            // Point d'entrée, charge ProductCatalogContainer
├── model/ProductUi.kt         // Données affichées par l'UI
├── data/SampleProducts.kt     // Produits et catégories d'exemple (local, sans réseau)
└── ui/
    ├── screen/                // Écrans assemblant les composants
    └── component/             // Un fichier par composable réutilisable
```

## Lancer

1. Ouvrir le projet dans Android Studio.
2. Sync Gradle (dépendance `material-icons-extended`).
3. Run.
