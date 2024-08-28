package com.example.apphoroscopo.motherobject

import com.example.apphoroscopo.data.network.response.PredictionResponse
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Aquarius
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Aries
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Cancer
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Capricorn
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Gemini
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Leo
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Libra
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Pisces
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Sagittarius
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Scorpio
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Taurus
import com.example.apphoroscopo.domain.model.HoroscopeInfo.Virgo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        Aquarius,
        Aries,
        Cancer,
        Capricorn,
        Gemini,
        Leo,
        Libra,
        Pisces,
        Sagittarius,
        Scorpio,
        Taurus,
        Virgo
    )
}