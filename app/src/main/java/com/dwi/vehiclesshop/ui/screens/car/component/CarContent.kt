package com.dwi.vehiclesshop.ui.screens.car.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import java.text.NumberFormat
import java.util.Locale


@Composable
fun CarContent(
    cars: List<VehiclesWithCar>,
    modifier: Modifier,
) {
    val numberFormat = NumberFormat.getNumberInstance(Locale("in", "ID"))
    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp),
    ) {
        items(cars) { car ->
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
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    ),
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    car.vehicles.let {
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
                    car.car?.let {
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
                                Text(text = "Kapasitas")
                            }
                            Text(text = ":")
                            Row(
                                modifier = modifier.weight(1f),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = "${it.capacity} penumpang")
                            }
                        }
                        Row(
                            modifier = modifier.fillMaxWidth(),
                        ) {
                            Row(
                                modifier = modifier.weight(1f),
                            ) {
                                Text(text = "Tipe")
                            }
                            Text(text = ":")
                            Row(
                                modifier = modifier.weight(1f),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = it.type)
                            }
                        }
                    }
                    Button(
                        onClick = { },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(text = "Beli")
                    }
                }
            }
        }
    }
}