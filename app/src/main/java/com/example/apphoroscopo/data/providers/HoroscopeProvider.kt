package com.example.apphoroscopo.data.providers

import com.example.apphoroscopo.domain.model.HoroscopeInfo
import com.example.apphoroscopo.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscope():List<HoroscopeInfo>{
        return listOf(
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
}