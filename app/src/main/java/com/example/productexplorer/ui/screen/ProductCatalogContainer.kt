package com.example.productexplorer.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.productexplorer.model.ProductUi

@Composable
fun ProductCatalogContainer(
    onProductClick: (ProductUi) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductCatalogViewModel = viewModel()
) {
    ProductCatalogScreen(
        products = viewModel.filteredProducts,
        categories = viewModel.categories,
        searchQuery = viewModel.searchQuery,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        showOnlyInStock = viewModel.showOnlyInStock,
        onToggleStockFilter = viewModel::onToggleStockFilter,
        favoriteProductIds = viewModel.favoriteProductIds,
        onFavoriteClick = viewModel::onFavoriteClick,
        onProductClick = onProductClick,
        modifier = modifier
    )
}
