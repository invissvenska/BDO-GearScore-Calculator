package nl.invissvenska.bdogearscorecalculator.ui.main

import android.view.MenuItem
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.LiveCoroutinesViewModel
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
        @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel() {

//    lateinit var navHostFragment: NavHostFragment
//    var navController: NavController = navHostFragment.navController


//    fun onBottomMenuClicked(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_calculator -> {
//                Timber.e("calculator")
//
//                return true
//            }
//            R.id.action_brackets -> {
//                Timber.e("brakcets")
//
////                NavHostFragment.findNavController(f)
//                navHostFragment.findNavController()
//                        .navigate(R.id.bracket)
//                return true
//            }
//        }
//        return false
//    }


}