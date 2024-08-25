package com.example.apphoroscopo.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apphoroscopo.domain.model.HoroscopeModel
import com.example.apphoroscopo.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state:StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel){
        horoscope = sign
        // Nota si no pones un dispacher, de forma automatica usa el hilo principal
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val predictionResult = withContext(Dispatchers.IO){ getPredictionUseCase(sign.name) } //Hilo secundario
            if (predictionResult != null){
                _state.value = HoroscopeDetailState.Success(predictionResult, horoscope)
            }else {
                _state.value = HoroscopeDetailState.Error("A ocurrido un erro, intentelo mas tarde")
            }
            //Hilo principal

        }
    }
}