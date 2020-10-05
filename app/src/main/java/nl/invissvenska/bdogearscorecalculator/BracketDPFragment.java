package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import nl.invissvenska.bdogearscorecalculator.databinding.ContentBracketsBinding;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketAdapter;

public class BracketDPFragment extends Fragment {

    private static final Integer DEFAULT_SELECTED_INDEX = 3;

    private Integer selectedIndex;

    private ContentBracketsBinding binding;

    public BracketDPFragment() {
        //keep default constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.content_brackets, container, false);
        View view = binding.getRoot();
        binding.setAdapter(new BracketAdapter(new DefensePowerCalculator(), getResources().getString(R.string.bracket_label_defense)));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (selectedIndex != null) {
            binding.combinedBrackets.scrollToPosition(selectedIndex);
        } else {
            binding.combinedBrackets.scrollToPosition(DEFAULT_SELECTED_INDEX);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        selectedIndex = binding.combinedBrackets.getCurrentItem();
    }
}
