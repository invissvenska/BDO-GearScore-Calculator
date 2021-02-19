package nl.invissvenska.bdogearscorecalculator.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.whatif.whatIfNotNullOrEmpty
import nl.invissvenska.bdogearscorecalculator.model.Bracket
import nl.invissvenska.bdogearscorecalculator.ui.adapter.BracketAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("adapterBracketList")
fun bindAdapterBracketList(view: RecyclerView, bracketList: List<Bracket>?) {
  bracketList.whatIfNotNullOrEmpty {
    (view.adapter as? BracketAdapter)?.addBracketList(it)
  }
}
