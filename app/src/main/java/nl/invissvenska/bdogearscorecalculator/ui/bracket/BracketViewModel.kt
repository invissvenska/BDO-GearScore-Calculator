package nl.invissvenska.bdogearscorecalculator.ui.bracket

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import nl.invissvenska.bdogearscorecalculator.base.LiveCoroutinesViewModel
import nl.invissvenska.bdogearscorecalculator.repository.BracketRepository

class BracketViewModel @ViewModelInject constructor(
        private val repository: BracketRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel()