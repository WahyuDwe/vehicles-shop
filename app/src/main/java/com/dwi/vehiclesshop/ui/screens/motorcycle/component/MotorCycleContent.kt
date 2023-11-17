package com.dwi.vehiclesshop.ui.screens.motorcycle.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import java.text.NumberFormat
import java.util.Locale

@Composable
fun MotorCycleContent(
    motorCycles: List<VehiclesWithMotorCycle>,
    modifier: Modifier,
    navigateToDetail: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        items(motorCycles) { motorCycle ->
            val numberFormat = NumberFormat.getNumberInstance(Locale("id", "ID"))
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(
                    1.dp,
                    Color.Black
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    ),
            ) {
                Box(
                    modifier = modifier.clickable {

                    }
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        motorCycle.vehicles.let {
                            Row(
                                modifier = modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
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
                                horizontalArrangement = Arrangement.Center
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
                        motorCycle.motorCycle?.let {
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = "Mesin")
                                }
                                Text(text = ":")
                                Row(
                                    modifier = modifier.weight(1f),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = it.engine)
                                }
                            }
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = "Tipe Suspensi")
                                }
                                Text(text = ":")
                                Row(
                                    modifier = modifier.weight(1f),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = it.suspensionType)
                                }
                            }
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = "Tipe Transmisi")
                                }
                                Text(text = ":")
                                Row(
                                    modifier = modifier.weight(1f),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = it.transmissionType)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}