package nl.invissvenska.bdogearscorecalculator.ui.bracket

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.hilt.Assisted
import nl.invissvenska.bdogearscorecalculator.base.LiveCoroutinesViewModel
import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator
import nl.invissvenska.bdogearscorecalculator.repository.BracketRepository
import timber.log.Timber

class BracketViewModel @ViewModelInject constructor(
        private val repository: BracketRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel() {

//    val list: AttackPowerCalculator.getBrackets();

    init {
        Timber.d("init BracketViewModel")
    }
}