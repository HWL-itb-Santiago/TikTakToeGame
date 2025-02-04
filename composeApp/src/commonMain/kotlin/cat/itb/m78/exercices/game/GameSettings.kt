package cat.itb.m78.exercices.game

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GameMatrix() : ViewModel()
{
    private val myMatrix = (
        listOf(
        listOf(0, 0, 0),
        listOf(0, 0, 0),
        listOf(0, 0, 0)
        )
    )

    val gameMatrix = myMatrix.toMutableMatrix()
    var playerTurn = mutableStateOf(1)


    fun changeMatrix(posX: Int, posY: Int)
    {
        if (gameMatrix[posX][posY] == 0)
        {
            gameMatrix[posX][posY] = playerTurn.value
            changePlayer()
        }
    }

    private fun changePlayer()
    {
        playerTurn.value = (playerTurn.value % 2) + 1
    }
}

fun List<List<Int?>>.toMutableMatrix(): List<MutableList<Int?>> {
    return map { it.toMutableList() }
}