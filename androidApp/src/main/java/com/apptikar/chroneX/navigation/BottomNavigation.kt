package com.apptikar.chroneX.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apptikar.designSystem.chroneXGray500
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite
import com.apptikar.utils.navigation.navigateBottomNavigation


@Composable
fun ChroneBottomNavigation(
    navController: NavHostController,
    screens: List<BottomBarScreen>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val density = LocalDensity.current

    BottomNavigation(
        modifier = Modifier.height(with(density) {
            WindowInsets.navigationBars.getBottom(density).toDp()
        } + 50.dp),
        backgroundColor = MaterialTheme.colorScheme.chroneXWhite,
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navBackStackEntry = navBackStackEntry,
                onClick = {
                    navController.navigateBottomNavigation(screen.route)
                }
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navBackStackEntry: NavBackStackEntry?,
    onClick: () -> Unit,
) {

    val selected by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route?.contains(screen.route.toString()) == true
        }
    }

    BottomNavigationItem(
        selectedContentColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
        onClick = onClick,
        label = {
            Text(
                text = stringResource(screen.title),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.chroneXGray500
                )
            )
        },
        icon = {
            Icon(
                painter = painterResource(screen.icon),
                contentDescription = screen.route.toString(),
            )
        },
        selected = selected,
    )
}