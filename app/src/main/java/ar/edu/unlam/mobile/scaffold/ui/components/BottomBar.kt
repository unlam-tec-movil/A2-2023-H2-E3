package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ar.edu.unlam.mobile.scaffold.R

@Composable
fun BottomBar(controller: NavHostController) {
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    NavigationBar {
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "home" } == true,
            onClick = { controller.navigate("home") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Borrar Tarea",
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "segundo" } == true,
            onClick = { controller.navigate("segundo/667867895") },
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Borrar Tarea",
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "segundo" } == true,
            onClick = { controller.navigate("segundo/667867895") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_zen_mode),
                    contentDescription = "Borrar Tarea",
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
        )
        NavigationBarItem(
            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == "habit" } == true,
            onClick = { controller.navigate("habit") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_equalizer),
                    contentDescription = "Borrar Tarea",
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
        )
    }
}
