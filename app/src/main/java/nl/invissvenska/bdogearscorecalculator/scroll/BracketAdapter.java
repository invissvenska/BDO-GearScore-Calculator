package nl.invissvenska.bdogearscorecalculator.scroll;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nl.invissvenska.bdogearscorecalculator.databinding.ItemBracketBinding;
import nl.invissvenska.bdogearscorecalculator.helper.Calculator;

public class BracketAdapter extends RecyclerView.Adapter<BracketAdapter.BracketItemViewHolder> {

    private List<BracketItem> brackets = new ArrayList<>();

    private String title;

    public BracketAdapter(Calculator calculator, final String title) {
        this.title = title;
        this.brackets.clear();
        this.brackets.addAll(calculator.getBrackets());
        notifyDataSetChanged();
    }

    public String getTitle() {
        return title;
    }

    @NonNull
    @Override
    public BracketItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBracketBinding itemBinding = ItemBracketBinding.inflate(layoutInflater, parent, false);
        return new BracketItemViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BracketItemViewHolder holder, int position) {
        BracketItem item = this.brackets.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return brackets.size();
    }

    static class BracketItemViewHolder extends RecyclerView.ViewHolder {

        public final ItemBracketBinding binding;

        public BracketItemViewHolder(@NonNull ItemBracketBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BracketItem item) {
            binding.setBracket(item);
            binding.executePendingBindings();
        }
    }
}
