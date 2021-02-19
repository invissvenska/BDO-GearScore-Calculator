package nl.invissvenska.bdogearscorecalculator.ui.bracket

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import dagger.hilt.android.AndroidEntryPoint
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.DataBindingActivity
import nl.invissvenska.bdogearscorecalculator.databinding.ActivityBracketBinding
import timber.log.Timber

@AndroidEntryPoint
class BracketActivity : DataBindingActivity() {

    @VisibleForTesting
    val viewModel: BracketViewModel by viewModels()
    private val binding: ActivityBracketBinding by binding(R.layout.activity_bracket)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("ID to show in view")
        binding.apply {
            lifecycleOwner = this@BracketActivity
            vm = viewModel.apply {
                // setVideoId(youTubeId)
            }
        }
    }
}