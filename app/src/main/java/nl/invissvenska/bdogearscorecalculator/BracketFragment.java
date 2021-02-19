package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapRecyclerView;

import java.util.List;

import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketAdapter;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

public class BracketFragment extends Fragment {

    private static final Integer DEFAULT_SELECTED_INDEX = 0;

    private GravitySnapRecyclerView combinedApBrackets;
    private GravitySnapRecyclerView defenseDpBrackets;

    private Integer apSelectedIndex;
    private Integer dpSelectedIndex;

    public BracketFragment() {
        //keep default constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_brackets, container, false);

        combinedApBrackets = view.findViewById(R.id.combinedApBrackets);
        defenseDpBrackets = view.findViewById(R.id.defenseDpBrackets);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setCombinedApBrackets();
        setDefenseDpBrackets();
        if (apSelectedIndex != null) {
            combinedApBrackets.scrollToPosition(apSelectedIndex);
        } else {
            combinedApBrackets.scrollToPosition(DEFAULT_SELECTED_INDEX);
        }
        if (dpSelectedIndex != null) {
            defenseDpBrackets.scrollToPosition(dpSelectedIndex);
        } else {
            defenseDpBrackets.scrollToPosition(DEFAULT_SELECTED_INDEX);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        apSelectedIndex = combinedApBrackets.getCurrentSnappedPosition();
        dpSelectedIndex = defenseDpBrackets.getCurrentSnappedPosition();
    }

    private void setCombinedApBrackets() {
        BracketAdapter apAdapter = new BracketAdapter();
        apAdapter.addAll(AttackPowerCalculator.getBrackets());
        setBrackets(combinedApBrackets, apAdapter, AttackPowerCalculator.getBrackets());
    }

    private void setDefenseDpBrackets() {
        BracketAdapter dpAdapter = new BracketAdapter();
        dpAdapter.addAll(DefensePowerCalculator.getBrackets());
        setBrackets(defenseDpBrackets, dpAdapter, DefensePowerCalculator.getBrackets());
    }

    private void setBrackets(GravitySnapRecyclerView scrollView, BracketAdapter adapter, List<BracketItem> items) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        scrollView.setLayoutManager(layoutManager);
        adapter.addAll(items);
        scrollView.setAdapter(adapter);
    }
}
