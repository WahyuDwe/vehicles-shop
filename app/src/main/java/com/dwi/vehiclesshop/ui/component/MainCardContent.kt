package com.dwi.vehiclesshop.ui.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.data.local.model.Vehicles
import java.text.NumberFormat
import java.util.Locale

@Composable
fun MainCardContent(
    modifier: Modifier,
    vehicle: Vehicles,
    index: Int,
    showBottomSheet: MutableMap<Int, Boolean>
) {
    val numberFormat = NumberFormat.getNumberInstance(Locale("in", "ID"))
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(
            1.dp,
            Color.Black
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp, end = 16.dp, top = 16.dp
            ),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            vehicle.let {
                Row(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = modifier.weight(1f),
                    ) {
                        Text(text = "Tahun")
                    }
                    Text(text = ":")
                    Row(
                        modifier = modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = it.year)
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = modifier.weight(1f),
                    ) {
                        Text(text = "Harga")
                    }
                    Text(text = ":")
                    Row(
                        modifier = modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = "Rp ${numberFormat.format(it.price)}")
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = modifier.weight(1f),
                    ) {
                        Text(text = "Warna")
                    }
                    Text(text = ":")
                    Row(
                        modifier = modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = it.color)
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = modifier.weight(1f),
                    ) {
                        Text(text = "Stok")
                    }
                    Text(text = ":")
                    Row(
                        modifier = modifier.weight(1f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = "${it.stock} unit")
                    }
                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(onClick = { /*TODO*/ }, modifier = modifier.weight(1f)) {
                    Text(text = "Info")
                }
                Spacer(modifier = modifier.padding(horizontal = 8.dp))
                Button(
                    onClick = {
                        showBottomSheet[index] = true
                        Log.d(
                            "CarContent",
                            "car id: ${vehicle.typeId} \n car year: ${vehicle.year}"
                        )
                    }, modifier = modifier.weight(1f)
                ) {
                    Text(text = "Beli")
                }
            }
        }

    }
}