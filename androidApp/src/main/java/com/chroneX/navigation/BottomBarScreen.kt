package com.chroneX.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


sealed class BottomBarScreen(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
//
//    data object Home : BottomBarScreen(
//        route = HomeFlow.HomeScreen,
//        title = R.string.main,
//        icon = Res.drawable.home_unselected
//    )
//
//    data object MyAccount : BottomBarScreen(
//        route = AccountFlow.MyAccount,
//        title = Res.string.my_account,
//        icon = Res.drawable.user
//    )
//
//    data object Community : BottomBarScreen(
//        route = CommunityFlow.Community,
//        title = Res.string.community,
//        icon = Res.drawable.book
//    )
//
//    data object Products : BottomBarScreen(
//        route = ProductsFlow.Products,
//        title = Res.string.products,
//        icon = Res.drawable.bag
//    )

}