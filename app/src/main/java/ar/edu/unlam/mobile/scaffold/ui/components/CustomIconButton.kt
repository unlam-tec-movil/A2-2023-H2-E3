package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomIconButton(controller: NavHostController, route: String, icon: ImageVector) {
    IconButton(
        modifier = Modifier
            .padding(6.dp)
            .background(
                color = Color.Red,
                shape = CircleShape,
            ),
        onClick = { controller.navigate(route) },
    ) {
        Icon(icon, contentDescription = null)
    }
}