package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onSelectionChanged: (String) -> Unit,
){
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var konsentrasi by rememberSaveable { mutableStateOf("") }
    var judul by remember { mutableStateOf("") }
    var dospem1 by remember { mutableStateOf("")}
    var listData: MutableList<String> = mutableListOf(nama,nim,konsentrasi,judul)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text(text = "Nama Mahasiswa") }
        )
        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text(text = "NIM") }
        )
        OutlinedTextField(
            value = konsentrasi,
            onValueChange = { konsentrasi = it },
            label = { Text(text = "Konsentrasi") }
        )
        OutlinedTextField(
            value = judul,
            onValueChange = { judul = it },
            label = { Text(text = "Judul Skripsi") }
        )

        Spacer(
            modifier = Modifier.padding(16.dp)
        )
        Row (modifier = Modifier.selectable(selected = dospem1 == item,
            onClick = {
                dospem1 = item
                onSelectionChanged(item)
            }
        ),
            verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = dospem1 == item,
                onClick = {
                    dospem1 = item
                    onSelectionChanged(item)}
            )
            Text(item)
        Button(onClick = { onSubmitButtonClicked(listData) }) {
            Text(text = stringResource(id = R.string.btn_submit)
            )
        }
    }
}