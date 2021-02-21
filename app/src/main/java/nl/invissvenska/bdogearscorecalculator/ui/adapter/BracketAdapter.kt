package nl.invissvenska.bdogearscorecalculator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import nl.invissvenska.bdogearscorecalculator.R
import nl.invissvenska.bdogearscorecalculator.databinding.ItemBracketBinding
import nl.invissvenska.bdogearscorecalculator.model.Bracket

class BracketAdapter : RecyclerView.Adapter<BracketAdapter.BracketViewHolder>() {

    private val items: MutableList<Bracket> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BracketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemBracketBinding>(inflater, R.layout.item_bracket, parent, false)
        return BracketViewHolder(binding)
    }

    fun addBracketList(bracketList: List<Bracket>) {
        val previous = items.size
        items.addAll(bracketList)
        notifyItemRangeChanged(previous, bracketList.size)
    }

    override fun onBindViewHolder(holder: BracketViewHolder, position: Int) {
        holder.binding.apply {
            bracket = items[position]
            executePendingBindings()
        }
    }

    override fun getItemCount() = items.size

    class BracketViewHolder(val binding: ItemBracketBinding) : RecyclerView.ViewHolder(binding.root)
}