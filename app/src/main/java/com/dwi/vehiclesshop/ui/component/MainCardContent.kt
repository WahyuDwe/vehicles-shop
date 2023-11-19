package com.dwi.vehiclesshop.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dwi.vehiclesshop.R
import com.dwi.vehiclesshop.data.local.model.Vehicles
import com.dwi.vehiclesshop.ui.common.UiState
import com.dwi.vehiclesshop.ui.screens.car.CarViewModel
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCyclesViewModel
import java.text.NumberFormat
import java.util.Locale

val numberFormat: NumberFormat = NumberFormat.getNumberInstance(Locale("in", "ID"))

@Composable
fun <T> MainCardContent(
    modifier: Modifier,
    vehicle: Vehicles,
    index: Int,
    showBottomSheet: MutableMap<Int, Boolean>,
    viewModel: T,
) {
    val openInfoDialog = remember { mutableStateOf(false) }
    val openEmptyStockDialog = remember { mutableStateOf(false) }

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(
            1.dp, Color.Black
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
                        Text(text = stringResource(R.string.tahun))
                    }
                    Text(text = stringResource(R.string.colon))
                    Row(
                        modifier = modifier.weight(1f), horizontalArrangement = Arrangement.End
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
                        Text(text = stringResource(R.string.harga))
                    }
                    Text(text = stringResource(R.string.colon))
                    Row(
                        modifier = modifier.weight(1f), horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = stringResource(R.string.rp, numberFormat.format(it.price)))
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = modifier.weight(1f),
                    ) {
                        Text(text = stringResource(R.string.warna))
                    }
                    Text(text = stringResource(R.string.colon))
                    Row(
                        modifier = modifier.weight(1f), horizontalArrangement = Arrangement.End
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
                        Text(text = stringResource(R.string.stok))
                    }
                    Text(text = stringResource(R.string.colon))
                    Row(
                        modifier = modifier.weight(1f), horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = stringResource(R.string.unit, it.stock))
                    }
                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(
                    onClick = {
                        openInfoDialog.value = true

                    }, modifier = modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.info))
                }
                Spacer(modifier = modifier.padding(horizontal = 8.dp))

                Button(
                    onClick = {
                        if (vehicle.stock > 0) {
                            showBottomSheet[index] = true
                        } else {
                            openEmptyStockDialog.value = true
                        }
                    }, modifier = modifier.weight(1f)
                ) {
                    Text(text = stringResource(R.string.beli))
                }
            }
        }
    }

    when {
        openInfoDialog.value -> {
            when (viewModel) {
                is CarViewModel -> {
                    viewModel.purchaseState.collectAsState(
                        initial = UiState.Loading
                    ).value.let {
                        when (it) {
                            is UiState.Loading -> {
                                viewModel.getPurchasesById(vehicle.idVehicles)
                            }

                            is UiState.Success -> {
                                var total = 0
                                var totalRevenue = 0
                                for (i in it.data.indices) {
                                    total += it.data[i].total
                                    totalRevenue += it.data[i].totalPrice
                                }
                                HandleInfoDialog(total, totalRevenue, openInfoDialog)
                            }

                            is UiState.Error -> {
                                // TODO: do nothing
                            }
                        }
                    }
                }

                is MotorCyclesViewModel -> {
                    viewModel.purchaseState.collectAsState(
                        initial = UiState.Loading
                    ).value.let {
                        when (it) {
                            is UiState.Loading -> {
                                viewModel.getPurchasesById(vehicle.idVehicles)
                            }

                            is UiState.Success -> {
                                var total = 0
                                var totalRevenue = 0
                                for (i in it.data.indices) {
                                    total += it.data[i].total
                                    totalRevenue += it.data[i].totalPrice
                                }
                                HandleInfoDialog(total, totalRevenue, openInfoDialog)
                            }

                            is UiState.Error -> {
                                // TODO: do nothing
                            }
                        }
                    }
                }
            }
        }

        openEmptyStockDialog.value -> {
            Dialog(
                onDismissRequest = {
                    openEmptyStockDialog.value = false
                },
                onConfirmation = {
                    openEmptyStockDialog.value = false
                },
                dialogTitle = stringResource(R.string.info),
                dialogContent = stringResource(R.string.stok_kendaraan_ini_kosong_silahkan_pilih_kendaraan_lain),
                icon = Icons.Default.Error
            )
        }
    }

}

@Composable
private fun HandleInfoDialog(
    totalPurchases: Int,
    totalPrice: Int,
    openInfoDialog: MutableState<Boolean>
) {
    if (totalPurchases != 0) {
        Dialog(
            onDismissRequest = {
                openInfoDialog.value = false
            },
            onConfirmation = {
                openInfoDialog.value = false
            },
            dialogTitle = stringResource(R.string.info),
            dialogContent = stringResource(
                R.string.kendaraan_ini_terjual_sebanyak_unit_dengan_total_penjualan_rp,
                totalPurchases,
                numberFormat.format(
                    totalPrice
                )
            ),
            icon = Icons.Default.Info
        )
    } else {
        Dialog(
            onDismissRequest = {
                openInfoDialog.value = false
            },
            onConfirmation = {
                openInfoDialog.value = false
            },
            dialogTitle = stringResource(R.string.info),
            dialogContent = stringResource(R.string.kendaraan_ini_belum_ada_yang_terjual),
            icon = Icons.Default.Info
        )
    }
}