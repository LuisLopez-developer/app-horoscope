package com.example.apphoroscopo.data

import android.util.Log
import com.example.apphoroscopo.data.network.HoroscopeApiService
import com.example.apphoroscopo.domain.Repository
import com.example.apphoroscopo.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) :Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Luis", "Ha ocurrido un error ${it.message}") }

        return null
    }
}