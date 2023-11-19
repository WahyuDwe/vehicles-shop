package com.dwi.vehiclesshop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwi.vehiclesshop.R
import com.dwi.vehiclesshop.data.local.model.Purchases
import com.dwi.vehiclesshop.data.local.model.Vehicles
import com.dwi.vehiclesshop.data.local.model.VehiclesWithCar
import com.dwi.vehiclesshop.data.local.model.VehiclesWithMotorCycle
import com.dwi.vehiclesshop.ui.screens.car.CarViewModel
import com.dwi.vehiclesshop.ui.screens.motorcycle.MotorCyclesViewModel
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> BottomSheet(
    modifier: Modifier,
    showBottomSheet: MutableMap<Int, Boolean>,
    index: Int,
    vehicle: Vehicles,
    typeOfVehicle: T,
    viewModel: T,
) {
    val numberFormat = NumberFormat.getNumberInstance(Locale("in", "ID"))
    val sheetState = rememberModalBottomSheetState()
    val expandedDropDownMenu = remember { mutableStateMapOf<Int, Boolean>() }
    val selectedStock = remember { mutableStateMapOf<Int, Int>() }
    val openSuccessDialog = remember { mutableStateOf(false) }
    val openEmptyAmountDialog = remember { mutableStateOf(false) }

    selectedStock[index] = selectedStock[index] ?: 0
    expandedDropDownMenu[index] = expandedDropDownMenu[index] ?: false

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
                    text = stringResource(R.string.detail_pembelian),
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
                            Text(text = stringResource(R.string.tahun))
                        }
                        Text(text = stringResource(R.string.colon))
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
                            Text(text = stringResource(R.string.harga))
                        }
                        Text(text = stringResource(R.string.colon))
                        Row(
                            modifier = modifier.weight(1f),
                            horizontalArrangement = Arrangement.End
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
                            Text(text = stringResource(R.string.stok))
                        }
                        Text(text = stringResource(R.string.colon))
                        Row(
                            modifier = modifier.weight(1f),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = stringResource(R.string.unit, it.stock))
                        }
                    }
                }
                when (typeOfVehicle) {
                    is VehiclesWithMotorCycle -> {
                        val motorCycle = typeOfVehicle as VehiclesWithMotorCycle
                        motorCycle.motorCycle?.let {
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = stringResource(R.string.mesin))
                                }
                                Text(text = stringResource(R.string.colon))
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
                                    Text(text = stringResource(R.string.tipe_suspensi))
                                }
                                Text(text = stringResource(R.string.colon))
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
                                    Text(text = stringResource(R.string.tipe_transmisi))
                                }
                                Text(text = stringResource(R.string.colon))
                                Row(
                                    modifier = modifier.weight(1f),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = it.transmissionType)
                                }
                            }
                        }
                    }

                    is VehiclesWithCar -> {
                        val car = typeOfVehicle as VehiclesWithCar
                        car.car?.let {
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = stringResource(R.string.mesin))
                                }
                                Text(text = stringResource(R.string.colon))
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
                                    Text(text = stringResource(R.string.kapasitas))
                                }
                                Text(text = stringResource(R.string.colon))
                                Row(
                                    modifier = modifier.weight(1f),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(text = stringResource(R.string.penumpang, it.capacity))
                                }
                            }
                            Row(
                                modifier = modifier.fillMaxWidth(),
                            ) {
                                Row(
                                    modifier = modifier.weight(1f),
                                ) {
                                    Text(text = stringResource(R.string.tipe))
                                }
                                Text(text = stringResource(R.string.colon))
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
                Spacer(modifier = modifier.padding(top = 16.dp))
                ExposedDropdownMenuBox(
                    expanded = expandedDropDownMenu[index] ?: false,
                    onExpandedChange = {
                        expandedDropDownMenu[index] =
                            !expandedDropDownMenu[index]!!
                    },
                    modifier = modifier.align(Alignment.End)
                ) {
                    OutlinedTextField(
                        label = { Text(text = stringResource(R.string.jumlah)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        readOnly = true,
                        shape = RoundedCornerShape(12.dp),
                        value = selectedStock[index]?.toString() ?: "",
                        onValueChange = {},
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expandedDropDownMenu[index] ?: false
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    )

                    ExposedDropdownMenu(
                        expanded = expandedDropDownMenu[index] ?: false,
                        onDismissRequest = {
                            expandedDropDownMenu[index] = false
                        },
                        modifier = Modifier
                            .heightIn(min = 56.dp, max = 300.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        when (typeOfVehicle) {
                            is VehiclesWithMotorCycle -> {
                                val motorCycles = typeOfVehicle as VehiclesWithMotorCycle
                                (1..motorCycles.vehicles.stock).forEach { selectionOptions ->
                                    DropdownMenuItem(
                                        text = { Text(text = selectionOptions.toString()) },
                                        onClick = {
                                            selectedStock[index] = selectionOptions
                                            expandedDropDownMenu[index] = false
                                        })
                                }

                            }

                            is VehiclesWithCar -> {
                                val cars = typeOfVehicle as VehiclesWithCar
                                (1..cars.vehicles.stock).forEach { selectionOptions ->
                                    DropdownMenuItem(
                                        text = { Text(text = selectionOptions.toString()) },
                                        onClick = {
                                            selectedStock[index] = selectionOptions
                                            expandedDropDownMenu[index] = false
                                        }
                                    )

                                }
                            }
                        }
                    }

                }
                Spacer(modifier = modifier.padding(top = 12.dp))
                Button(
                    enabled = vehicle.stock > 0,
                    onClick = {
                        if (selectedStock[index]!! > 0) {
                            when (viewModel) {
                                is CarViewModel -> {
                                    val carViewModel = viewModel as CarViewModel
                                    carViewModel.purchaseVehicle(
                                        Purchases(
                                            idVehicle = vehicle.idVehicles,
                                            total = selectedStock[index] ?: 1,
                                            idTypeOfVehicle = vehicle.typeId,
                                            totalPrice = vehicle.price * (selectedStock[index] ?: 1)
                                        )
                                    )
                                    carViewModel.updateStock(
                                        vehicleId = vehicle.idVehicles,
                                        quantity = selectedStock[index] ?: 1
                                    )
                                }

                                is MotorCyclesViewModel -> {
                                    val motorCyclesViewModel = viewModel as MotorCyclesViewModel
                                    motorCyclesViewModel.purchaseVehicle(
                                        Purchases(
                                            idVehicle = vehicle.idVehicles,
                                            total = selectedStock[index] ?: 1,
                                            idTypeOfVehicle = vehicle.typeId,
                                            totalPrice = vehicle.price * (selectedStock[index] ?: 1)
                                        )
                                    )
                                    motorCyclesViewModel.updateStock(
                                        vehicleId = vehicle.idVehicles,
                                        quantity = selectedStock[index] ?: 1
                                    )
                                }
                            }

                            showBottomSheet[index] = false

                            openSuccessDialog.value = true
                        } else {
                            openEmptyAmountDialog.value = true
                        }

                    },
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Text(text = stringResource(R.string.beli))
                }
            }

        }
    }

    when {
        openSuccessDialog.value -> {
            Dialog(
                onDismissRequest = { openSuccessDialog.value = false },
                onConfirmation = { openSuccessDialog.value = false },
                dialogTitle = stringResource(R.string.pembelian_berhasil),
                dialogContent = stringResource(
                    R.string.pembelian_berhasil_dilakukan_sebanyak_unit_dengan_total_harga_rp,
                    selectedStock[index]!!,
                    numberFormat.format(
                        vehicle.price * (selectedStock[index] ?: 1)
                    )
                ),
                icon = Icons.Filled.Verified,
            )
        }

        openEmptyAmountDialog.value -> {
            Dialog(
                onDismissRequest = { openEmptyAmountDialog.value = false },
                onConfirmation = { openEmptyAmountDialog.value = false },
                dialogTitle = stringResource(R.string.info),
                dialogContent = stringResource(R.string.jumlah_pembelian_tidak_boleh_kosong),
                icon = Icons.Default.Error,
            )
        }


    }
}