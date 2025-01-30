package cat.itb.m78.exercices.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.game.GameMatrix

@Composable
fun Screen2(navigateToScreen1 : () -> Unit)
{
    val gameMatrixViewModel = viewModel{ GameMatrix() }
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            DisplayGrill(gameMatrixViewModel)
            Button(
                onClick = navigateToScreen1
            )
            {
                Text(text = "Back to Menu")
            }
            println(gameMatrixViewModel.playerTurn.value)
            for (i in 0..2)
            {
                for (j in 0..2)
                {
                    print(gameMatrixViewModel.gameMatrix[i][j])
                }
                println()
            }
        }
    }
}

@Composable
fun DisplayGrill(gameMatrixViewModel: GameMatrix)
{
    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
    )
    {
        Row {
            ActionButton({gameMatrixViewModel.changeMatrix(0, 0)}, gameMatrixViewModel.gameMatrix[0][0])
            ActionButton ({gameMatrixViewModel.changeMatrix(0, 1)}, gameMatrixViewModel.gameMatrix[0][1])
            ActionButton ({gameMatrixViewModel.changeMatrix(0, 2)}, gameMatrixViewModel.gameMatrix[0][2])
        }
        Row {
            ActionButton({gameMatrixViewModel.changeMatrix(1, 0)}, gameMatrixViewModel.gameMatrix[1][0])
            ActionButton ({gameMatrixViewModel.changeMatrix(1, 1)}, gameMatrixViewModel.gameMatrix[1][1])
            ActionButton ({gameMatrixViewModel.changeMatrix(1, 2)}, gameMatrixViewModel.gameMatrix[1][2])
        }
        Row {
            ActionButton({gameMatrixViewModel.changeMatrix(2, 0)}, gameMatrixViewModel.gameMatrix[2][0])
            ActionButton ({gameMatrixViewModel.changeMatrix(2, 1)}, gameMatrixViewModel.gameMatrix[2][1])
            ActionButton ({gameMatrixViewModel.changeMatrix(2, 2)}, gameMatrixViewModel.gameMatrix[2][2])
        }
    }
}

@Composable
fun ActionButton(inputActionPlayer : () -> Unit, grillValue: Int?)
{
    Button(
        modifier = Modifier
            .background(color = Color.White, shape = RectangleShape)
            .size(150.dp)
            .border(1.dp, color = Color.Gray),
        onClick = inputActionPlayer,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    )
    {
        PlayerIcon(grillValue)
    }
}

@Composable
fun PlayerIcon(grillValue: Int?)
{
    if (grillValue == 1)
        Icon(
            Icons.Filled.Close,
            contentDescription = "Player 1",
        )
    else if (grillValue == 2)
        Icon(
            Icons.Filled.Add,
            contentDescription = "Player 2",
        )
}