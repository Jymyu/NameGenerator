package com.example.namegenerator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.namegenerator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BabyNameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.uiStateData.observe(this, Observer(::performViewState))

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.femaleButton.setOnClickListener {
            viewModel.invokeAction(BabyNameViewModelContract.Action.FetchFemaleName)
        }
        binding.maleButton.setOnClickListener {
            viewModel.invokeAction(BabyNameViewModelContract.Action.FetchMaleName)
        }
    }

    private fun performViewState(state: BabyNameViewModelContract.State) {
        when (state) {
            is BabyNameViewModelContract.State.ErrorState -> {
                Toast.makeText(this, state.errorMessage, Toast.LENGTH_SHORT).show()
                binding.pbBabyName.isVisible = false
                binding.nameCard.isVisible = true

            }
            BabyNameViewModelContract.State.LoadingState -> {
                binding.pbBabyName.isVisible = true
                binding.nameCard.isVisible = false
            }
            is BabyNameViewModelContract.State.SuccessState -> {
                binding.babyName.text = state.name.name
                binding.pbBabyName.isVisible = false
                binding.nameCard.isVisible = true

            }
        }
    }
}