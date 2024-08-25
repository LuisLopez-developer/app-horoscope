package com.example.apphoroscopo.ui.detail

import com.example.apphoroscopo.domain.model.HoroscopeModel
import com.example.apphoroscopo.domain.model.PredictionModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val data:PredictionModel, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}