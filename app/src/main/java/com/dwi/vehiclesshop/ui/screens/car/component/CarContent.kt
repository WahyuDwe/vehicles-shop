package com.dwi.vehiclesshop.ui.screens.car.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import java.text.NumberFormat
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarContent(
    vehiclesWithCars: List<VehiclesWithCar>,
    modifier: Modifier,
) {
    val numberFormat = NumberFormat.getNumberInstance(Locale("in", "ID"))
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val showBottomSheet = remember { mutableStateMapOf<Int, Boolean>() }

    LazyColumn(
        contentPadding = PaddingValues(bottom = 32.dp),
    ) {
        itemsIndexed(vehiclesWithCars) { index, car ->
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
                    val vehicle = car.vehicles
                    val cars = car.car

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
                    Button(
                        onClick = {
//                            showBottomSheet = true
                            showBottomSheet[index] = true
                            Log.d(
                                "CarContent",
                                "car id: ${vehicle.typeId} \n car year: ${vehicle.year}"
                            )
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(text = "Beli")
                    }

                    if (showBottomSheet[index] == true) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet[index] = false
                            },
                            sheetState = sheetState
                        ) {
                            Column(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                        bottom = 32.dp,
                                    )

                            ) {
                                Text(
                                    text = "Detail Pembelian",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                )
                                Spacer(modifier = modifier.padding(top = 16.dp))
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
                                cars?.let {
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
                            }

                        }
                    }
                }

            }
        }
    }
}