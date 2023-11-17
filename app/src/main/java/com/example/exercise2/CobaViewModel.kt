package com.example.exercise2

import androidx.lifecycle.ViewModel
import com.example.exercise2.Data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CobaViewModel : ViewModel() {
    private val _stateui = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateui.asStateFlow()

    fun setBiodata(nama: String,nim: String, alamat: String, konsentrasi: String, judul: String){
        _stateui.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = nama,
                nim = nim,
                konsentrasi = konsentrasi,
                judul = judul
            )
        }
    }

}