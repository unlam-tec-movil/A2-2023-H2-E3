package ar.edu.unlam.mobile.scaffold.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue2

@Composable
fun DaysRowButtons(onDaySelectedChanged: (String, Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Day("D") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("L") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("M") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("X") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("J") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("V") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
        Day("S") { day, isSelected ->
            // Notifica el cambio al día seleccionado
            onDaySelectedChanged(day, isSelected)
        }
    }
}

@Composable
fun Day(text: String, param: (String, Boolean) -> Unit) {
    var isButtonClicked by remember { mutableStateOf(false) }

    val buttonColor = if (isButtonClicked) {
        CustomLightBlue
    } else {
        CustomLightBlue2
    }

    Row(
        modifier = Modifier
            .width(32.dp)
            .height(32.dp)
            .background(
                color = buttonColor,
                shape = CircleShape,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(
            onClick = {
                isButtonClicked = !isButtonClicked

                param(text, isButtonClicked)
            },
            modifier = Modifier
                .background(
                    color = buttonColor,
                    shape = CircleShape,
                ),
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
            )
        }
    }
}
