package nl.invissvenska.bdogearscorecalculator.ui.bracket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.DataBindingFragment
import nl.invissvenska.bdogearscorecalculator.databinding.ActivityBracketBinding
import nl.invissvenska.bdogearscorecalculator.ui.adapter.BracketAdapter
import nl.invissvenska.bdogearscorecalculator.util.AttackPowerCalculator
import nl.invissvenska.bdogearscorecalculator.util.DefensePowerCalculator

@AndroidEntryPoint
class BracketActivity : DataBindingFragment() {

    @VisibleForTesting
    val viewModel: BracketViewModel by viewModels()
    private val binding: ActivityBracketBinding by binding(R.layout.activity_bracket)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lifecycleOwner = this@BracketActivity
            attackAdapter = BracketAdapter()
            defenseAdapter = BracketAdapter()
            attackBracket = AttackPowerCalculator
            defenseBracket = DefensePowerCalculator
            vm = viewModel
        }

        return binding.root
    }
}