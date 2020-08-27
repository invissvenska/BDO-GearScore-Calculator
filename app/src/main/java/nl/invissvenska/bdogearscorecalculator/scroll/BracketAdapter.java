package nl.invissvenska.bdogearscorecalculator.scroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nl.invissvenska.bdogearscorecalculator.R;

public class BracketAdapter extends RecyclerView.Adapter<BracketViewHolder> {

    private List<BracketItem> brackets = new ArrayList<>();

    public void addAll(List<BracketItem> brackets) {
        this.brackets.clear();
        this.brackets.addAll(brackets);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BracketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new BracketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BracketViewHolder holder, int position) {
        final BracketItem item = brackets.get(position);
        Context context = holder.fromTo.getContext();
        if (item.getTo().equals(999)) {
            holder.fromTo.setText(context.getString(R.string.bracket_value_max, item.getFrom()));
        } else {
            holder.fromTo.setText(context.getString(R.string.bracket_value, item.getFrom(), item.getTo()));
        }
        holder.bonus.setText(context.getString(R.string.bracket_bonus, item.getPrefix(), item.getBonus(), item.getSuffix()));
    }

    @Override
    public int getItemCount() {
        return brackets.size();
    }
}
