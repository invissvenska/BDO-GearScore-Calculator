package nl.invissvenska.bdogearscorecalculator.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.base.DataBindingFragment
import nl.invissvenska.bdogearscorecalculator.databinding.ActivityBracketBinding
import nl.invissvenska.bdogearscorecalculator.databinding.FragmentHomeBinding
import nl.invissvenska.bdogearscorecalculator.databinding.ItemBracketBinding
import nl.invissvenska.bdogearscorecalculator.ui.adapter.BracketAdapter
import nl.invissvenska.bdogearscorecalculator.ui.bracket.BracketViewModel
import nl.invissvenska.bdogearscorecalculator.util.AttackPowerCalculator
import nl.invissvenska.bdogearscorecalculator.util.DefensePowerCalculator

//@AndroidEntryPoint
class CalculatorActivity : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BracketAdapter.BracketViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = DataBindingUtil.inflate<ItemBracketBinding>(inflater, R.layout.item_bracket, parent, false)
//        return BracketAdapter.BracketViewHolder(binding)
//    }

//    val viewModel: HomeViewModel by viewModels()
////    private val binding: FragmentHomeBinding by binding(R.layout.fragment_home)
//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View {
////        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.activity_bracket, container, false)
//
//        binding.apply {
//            lifecycleOwner = this@CalculatorActivity
//            viewModel = homeViewModel
//        }
//
//        return binding.root
//    }
}