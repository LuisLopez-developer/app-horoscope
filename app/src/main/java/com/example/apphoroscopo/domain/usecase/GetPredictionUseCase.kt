package com.example.apphoroscopo.domain.usecase

import com.example.apphoroscopo.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}