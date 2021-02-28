package nl.invissvenska.bdogearscorecalculator.ui.calculator

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import nl.invissvenska.bdogearscorecalculator.base.LiveCoroutinesViewModel

class CalculatorViewModel @ViewModelInject constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel()