package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme

/*

* ######## Réponses aux questions :
*
* ### 1. Pour être réutilisable.
* ProductTitle ne connaît aucun produit en particulier,
* il affiche le nom qu'on lui transmet.
* On peut donc l'appeler avec « Sac à dos », « Casque audio »
* ou n'importe quel autre nom.
*
* ### 2. Chaque composable a une responsabilité claire et limitée.
* Le code devient plus lisible, plus facile à maintenir et à tester.
* On peut aussi réutiliser les composants à plusieurs endroits.
*
* ### 3. Il décrit et assemble la carte produit.
* Il organise verticalement, dans une Surface et une Column,
* le titre, le prix, la disponibilité et le bouton favori,
* à partir des données qu'il reçoit en paramètres.
*
* ### 4. Le texte affiché passe de « Produit disponible »
* à « Produit indisponible ».
* L'interface change uniquement parce que la donnée transmise change,
* donnée différente, interface différente.
*
* ### 5. Pour respecter le principe « state down, events up ».
* Le bouton ne possède pas l'état, il se contente de l'afficher.
* C'est le parent qui le détient et le contrôle,
* ce qui rend le composant sans état (stateless),
* réutilisable et simple à prévisualiser dans différents états.
* (Le principe du MVC)
*
* ### 6. C'est un événement (un callback de type () -> Unit).
* Il permet au bouton de signaler le clic au parent sans décider
* lui-même comment le traiter.
*
* ### 7. name, price, isAvailable et isFavorite.
*
* ### 8. onFavoriteClick, déclenché lors du clic sur le bouton favori.
*
* ### 9. Le lambda onFavoriteClick passé dans ProductDemoScreen est vide,
* et isFavorite est une valeur fixe (false), pas un état observable.
*
* ### 10. Elles permettent de visualiser rapidement plusieurs états
* de l'interface (disponible ou indisponible, favori ou non) sans lancer
* l'application.
* On vérifie ainsi aussi les variantes, et pas seulement le cas idéal.
*
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductDemoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProductDemoScreen(modifier: Modifier = Modifier) {
    ProductCard(
        name = "Sac à dos",
        price = 49.99,
        isAvailable = true,
        isFavorite = false,
        onFavoriteClick = {
            // Pour l’instant, nous ne modifions pas encore l’état.
            // Nous verrons cela dans la séance sur la gestion d’état.
        },
        modifier = modifier.padding(24.dp)
    )
}
@Composable
fun ProductCard(
    name: String,
    price: Double,
    isAvailable: Boolean,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProductTitle(name = name)
            ProductPrice(price = price)
            ProductAvailability(isAvailable = isAvailable)
            FavoriteButton(
                isFavorite = isFavorite,
                onFavoriteClick = onFavoriteClick
            )
        }
    }
}
@Composable
fun ProductTitle(name: String) {
    Text(text = name)
}
@Composable
fun ProductPrice(price: Double) {
    Text(text = "$price €")
}
@Composable
fun ProductAvailability(isAvailable: Boolean) {
    Text(
        text = if (isAvailable) {
            "Produit disponible"
        } else {
            "Produit indisponible"
        }
    )
}
@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Button(onClick = onFavoriteClick) {
        Text(
            text = if (isFavorite) {
                "★ Favori"
            } else {
                "☆ Ajouter aux favoris"
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ProductDemoScreenPreview() {
    GreetingCardTheme {
        ProductDemoScreen()
    }
}
@Preview(showBackground = true)
@Composable
fun ProductCardAvailablePreview() {
    GreetingCardTheme {
        ProductCard(
            name = "Sac à dos",
            price = 49.99,
            isAvailable = true,
            isFavorite = false,
            onFavoriteClick = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ProductCardUnavailableFavoritePreview() {
    GreetingCardTheme {
        ProductCard(
            name = "Casque audio",
            price = 89.99,
            isAvailable = false,
            isFavorite = true,
            onFavoriteClick = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}