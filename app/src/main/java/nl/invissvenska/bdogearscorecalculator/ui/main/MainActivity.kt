package nl.invissvenska.bdogearscorecalculator.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.DataBindingActivity
import nl.invissvenska.bdogearscorecalculator.databinding.ActivityBracketBinding
import nl.invissvenska.bdogearscorecalculator.databinding.ActivityMainsBinding
import nl.invissvenska.bdogearscorecalculator.ui.adapter.BracketAdapter
import nl.invissvenska.bdogearscorecalculator.ui.bracket.BracketViewModel
import nl.invissvenska.bdogearscorecalculator.util.AttackPowerCalculator
import nl.invissvenska.bdogearscorecalculator.util.DefensePowerCalculator

@AndroidEntryPoint
class MainActivity : DataBindingActivity() {

    @VisibleForTesting
    val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainsBinding by binding(R.layout.activity_mains)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
    }
}