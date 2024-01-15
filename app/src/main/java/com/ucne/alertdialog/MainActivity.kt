package com.ucne.alertdialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucne.alertdialog.ui.theme.AlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAlertDialog()
                }
            }
        }
    }
}


@Composable
fun MyAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    if(showDialog)
    {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Dialogo de Alerta")},
            text = { Text(text = "Dialogo de Alerta de Jetpack Compose") },
            confirmButton =
            {
                Button(onClick = { showDialog = false }) {
                    Text(text = "Ok")
                }
            },

            dismissButton =
            {
                Button(onClick = { showDialog = false }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
    else
    {
        Column(modifier = Modifier.fillMaxSize().padding(25.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
        {
            Button(onClick = { showDialog = true }) {
                Text(text = "Mostrar alerta")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlertDialogTheme {
        MyAlertDialog()
    }
}