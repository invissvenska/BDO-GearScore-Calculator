package nl.invissvenska.bdogearscorecalculator.ui.main

import android.view.MenuItem
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.LiveCoroutinesViewModel
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel() {

    fun onBottomMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_calculator -> {
                Timber.e("calculator")
                return true
            }
            R.id.action_brackets -> {
                Timber.e("brakcets")
                return true
            }
        }
        return false
    }


}