package com.example.apphoroscopo.domain

import com.example.apphoroscopo.domain.model.PredictionModel

// Es la capa que servira de intermediario entre domain y data
interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}