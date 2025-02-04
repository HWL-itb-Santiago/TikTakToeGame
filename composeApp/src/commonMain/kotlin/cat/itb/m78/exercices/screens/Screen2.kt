package cat.itb.m78.exercices.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.game.GameMatrix

data class Player1(val list: List<List<Int>>)
data class Player2(val list: List<List<Int>>)
@Composable
fun Screen2(navigateToScreen1 : () -> Unit)
{
    val player1 = Player1(listOf())
    val player2 = Player2(listOf())
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
        for (i in 0..<gameMatrixViewModel.gameMatrix.size)
        {
            Row{
                for (j in 0..<gameMatrixViewModel.gameMatrix[0].size)
                {
                    ActionButton(gameMatrixViewModel, i, j)
                }
            }
        }
    }
}

@Composable
fun ActionButton(gameMatrixViewModel: GameMatrix, posX : Int, posY : Int)
{
    val state =  remember {mutableStateOf(gameMatrixViewModel.gameMatrix[posX][posY])}
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource. collectIsHoveredAsState()
    var enabledButton = remember { mutableStateOf(false) }
    val icon by remember { mutableStateOf(Icons.Filled)}
    var newIcon = remember {mutableStateOf(icon.AddCircle)}
    Button(
        modifier = Modifier
            .background(color = Color.White, shape = RectangleShape)
            .size(150.dp)
            .border(1.dp, color = Color.Gray)
            .hoverable(interactionSource = interactionSource)
            ,
        enabled = enabledButton.value,
        onClick = {
            gameMatrixViewModel.changeMatrix(posX, posY)
            state.value = gameMatrixViewModel.gameMatrix[posX][posY]
            if (state.value == 1)
                newIcon.value = Icons.Filled.Close
            else
                newIcon.value = Icons.Filled.Add
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, disabledContainerColor = Color.Transparent)
    )
    {
        if (state.value == 0)
        {
            enabledButton.value = isHovered
        }
        else
        {
            Icon(
                newIcon.value,
                ""
            )
            enabledButton.value = false
        }
    }
}

fun CheckWinner(gameMatrixViewModel: GameMatrix, player1 : Player1, player2: Player2)
{
    var counter = 0
    var player = gameMatrixViewModel.playerTurn.value
    for (i in 0..<gameMatrixViewModel.gameMatrix.size)
    {
        for (j in 0..<gameMatrixViewModel.gameMatrix[0].size)
        {
            if (gameMatrixViewModel.gameMatrix[i][j] == player)
            {

            }
        }
    }
}