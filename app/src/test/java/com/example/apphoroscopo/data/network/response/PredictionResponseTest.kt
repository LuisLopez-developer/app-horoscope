package com.example.apphoroscopo.data.network.response

import com.example.apphoroscopo.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest{

    @Test
    fun `toDomain Should Return a Correct PredictionModel`(){
        //Given
        val horoscopeResponse = anyResponse.copy("libra")

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope

    }
}