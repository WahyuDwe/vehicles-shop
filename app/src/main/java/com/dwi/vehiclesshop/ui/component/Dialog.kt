package com.dwi.vehiclesshop.ui.component


import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogContent: String,
    icon: ImageVector,
) {
    AlertDialog(icon = {
        Icon(
            modifier = modifier.size(
                48.dp
            ), imageVector = icon, contentDescription = null
        )
    },
        title = { Text(text = dialogTitle) },
        onDismissRequest = { onDismissRequest() },
        text = { Text(text = dialogContent) },
        confirmButton = {
            TextButton(onClick = { onConfirmation() }) {
                Text(text = "OK")
            }
        })
}