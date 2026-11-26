# Product Explorer

Application Compose issue des TP4 et TP5.

## Écrans

- `ProductHomeScreen` — écran d'accueil (lancé au démarrage) : en-tête, barre de recherche visuelle, produit mis en avant, catégories, offre du jour.
- `ProductDetailScreen` — écran de détail d'un produit, conservé mais non lancé par défaut.

## Structure

```
productexplorer/
├── MainActivity.kt            // Point d'entrée, charge ProductHomeScreen
├── model/ProductUi.kt         // Données affichées par l'UI
├── data/SampleProducts.kt     // Produits d'exemple (local, sans réseau)
└── ui/
    ├── screen/                // Écrans assemblant les composants
    └── component/             // Un fichier par composable réutilisable
```

## Lancer

1. Ouvrir le projet dans Android Studio.
2. Sync Gradle (dépendance `material-icons-extended`).
3. Run.
