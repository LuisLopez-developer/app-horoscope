package com.example.apphoroscopo.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.apphoroscopo.R
import com.example.apphoroscopo.databinding.ActivityHoroscopeDetailBinding
import com.example.apphoroscopo.domain.model.HoroscopeModel.*
import com.example.apphoroscopo.ui.detail.HoroscopeDetailState.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel:HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        Loading -> loadingState()
                        is Error -> errorState()
                        is Success -> SuccessState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pbLoading.isVisible = true
    }

    private fun errorState() {
        binding.pbLoading.isVisible = false
    }

    private fun SuccessState(horoscopeDetailState: Success) {
        binding.pbLoading.isVisible = false
        binding.twTitle.text = horoscopeDetailState.data.sign
        binding.tvBody.text = horoscopeDetailState.data.horoscope

        val image = when(horoscopeDetailState.horoscopeModel){
            Aquarius -> R.drawable.detail_aquarius
            Aries -> R.drawable.detail_aries
            Cancer -> R.drawable.detail_cancer
            Capricorn -> R.drawable.detail_capricorn
            Gemini -> R.drawable.detail_gemini
            Leo -> R.drawable.detail_leo
            Libra -> R.drawable.detail_libra
            Pisces -> R.drawable.detail_pisces
            Sagittarius -> R.drawable.detail_sagittarius
            Scorpio -> R.drawable.detail_scorpio
            Taurus -> R.drawable.detail_taurus
            Virgo -> R.drawable.detail_virgo
        }

        binding.ivDetail.setImageResource(image)
    }
}