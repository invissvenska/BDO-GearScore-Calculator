package nl.invissvenska.bdogearscorecalculator.scroll;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nl.invissvenska.bdogearscorecalculator.R;

public class BracketViewHolder extends RecyclerView.ViewHolder {

    TextView fromTo;
    TextView bonus;

    public BracketViewHolder(@NonNull View itemView) {
        super(itemView);
        fromTo = itemView.findViewById(R.id.bracket_fromTo);
        bonus = itemView.findViewById(R.id.bracket_bonus);
    }
}
