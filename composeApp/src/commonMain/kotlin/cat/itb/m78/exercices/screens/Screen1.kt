package cat.itb.m78.exercices.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Screen1(navigateToScreen2 : () -> Unit)
{
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .fillMaxSize(),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = navigateToScreen2
            )
            {
                Text(text = "Play")
            }
        }
    }
}