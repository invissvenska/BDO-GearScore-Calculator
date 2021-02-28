package nl.invissvenska.bdogearscorecalculator.ui.bracket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.DataBindingFragment
import nl.invissvenska.bdogearscorecalculator.databinding.FragmentBracketBinding
import nl.invissvenska.bdogearscorecalculator.ui.adapter.BracketAdapter
import nl.invissvenska.bdogearscorecalculator.util.AttackPowerCalculator
import nl.invissvenska.bdogearscorecalculator.util.DefensePowerCalculator

@AndroidEntryPoint
class BracketFragment : DataBindingFragment() {

    private val binding: FragmentBracketBinding by binding(R.layout.fragment_bracket)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lifecycleOwner = this@BracketFragment
            attackAdapter = BracketAdapter()
            defenseAdapter = BracketAdapter()
            attackBracket = AttackPowerCalculator
            defenseBracket = DefensePowerCalculator
        }

        return binding.root
    }
}