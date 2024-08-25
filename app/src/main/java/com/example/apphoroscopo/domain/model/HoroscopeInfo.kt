package com.example.apphoroscopo.domain.model

import com.example.apphoroscopo.R

sealed class HoroscopeInfo(
    val img: Int,
    val name: Int,
){
    data object Aquarius:HoroscopeInfo(R.drawable.aquarius, R.string.aquarius)
    data object Aries:HoroscopeInfo(R.drawable.aries, R.string.aries)
    data object Cancer:HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    data object Capricorn:HoroscopeInfo(R.drawable.capricorn, R.string.capricorn)
    data object Gemini:HoroscopeInfo(R.drawable.gemini, R.string.gemini)
    data object Leo:HoroscopeInfo(R.drawable.leo, R.string.leo)
    data object Libra:HoroscopeInfo(R.drawable.libra, R.string.libra)
    data object Pisces:HoroscopeInfo(R.drawable.pisces, R.string.pisces)
    data object Sagittarius:HoroscopeInfo(R.drawable.sagittarius, R.string.sagittarius)
    data object Scorpio:HoroscopeInfo(R.drawable.scorpio, R.string.scorpio)
    data object Taurus:HoroscopeInfo(R.drawable.taurus, R.string.taurus)
    data object Virgo:HoroscopeInfo(R.drawable.virgo, R.string.virgo)
}