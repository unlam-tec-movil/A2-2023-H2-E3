package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomLightBlue
import ar.edu.unlam.mobile.scaffold.ui.theme.CustomRed

@Composable
fun TimerScreen(viewModel: TimerViewModel = hiltViewModel(), habitViewModel: HabitViewModel) {
    val activities by habitViewModel.activities
    var selectedActivity by remember { mutableStateOf<Activity?>(null) }

//    val now: LocalDateTime = LocalDateTime.now()
//    val startActivity = ActivityStart(id = 0, date = now, activityId = activity!!.id)

    val uiState: TimerUIState by viewModel.uiState.collectAsState()

    var isStarted by remember { mutableStateOf(false) }
    val color by remember { mutableStateOf(CustomRed) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        ActivitySpinner(
            items = activities,
            selectedItem = selectedActivity,
            onItemSelected = { habit ->
                selectedActivity = habit
            },
        )
        if (selectedActivity != null) {
            Text(text = "Meta diaria: ${selectedActivity!!.dailyGoal} horas")
        }

        Row {
            if (!isStarted) {
                TextButton(
                    onClick = {
//                        viewModel.insertStart(ActivityStart(0, date = LocalDateTime.,selectedActivity!!.id))
                        isStarted = true
                    },
                    modifier = Modifier
                        .background(color = CustomLightBlue),
                    shape = CircleShape,
                ) {
                    Text(
                        text = "Iniciar",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            } else {
                TextButton(
                    onClick = {
//                        viewModel.insertEnd(ActivityEnd(0, date = now, startActivity.id))
                        isStarted = false
                    },
                    modifier = Modifier
                        .background(color = color),
                    shape = CircleShape,
                ) {
                    Text(
                        text = "Detener",
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        ),
                    )
                }
            }
        }

        when (
            val jokeState = uiState.jokeState
        ) {
            is JokeUIState.Loading -> {
                CircularProgressIndicator()
            }

            is JokeUIState.Success -> {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(
                            color = Color.LightGray,
                        )
                        .border(4.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                ) {
                    Text("Frase recompensa de Chuck Norris: \n ${jokeState.joke.value}")
                }
                Log.i("CHUCK NORRIS", jokeState.joke.value)
            }

            is JokeUIState.Error -> {
            }
        }
    }
}

@Composable
fun ActivitySpinner(
    items: List<Activity>,
    selectedItem: Activity?,
    onItemSelected: (Activity) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.clickable { expanded.value = !expanded.value },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(selectedItem?.name ?: "Seleccione una actividad:")
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)

            DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
                items.forEach { item ->
                    DropdownMenuItem({ Text(text = item.name) }, {
                        onItemSelected(item)
                        expanded.value = false
                    })
                }
            }

            Log.i("SPINNER", items.toString())
        }
    }
}
