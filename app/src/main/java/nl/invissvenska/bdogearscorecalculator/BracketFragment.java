package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketAdapter;

public class BracketFragment extends Fragment {

    private static final Integer ITEM_COUNT = 15;
    private static final Integer FLING_THRESHOLD = 1000;
    private static final Integer DEFAULT_SELECTED_INDEX = 3;

    private DiscreteScrollView combinedApBrackets;
    private DiscreteScrollView defenseDpBrackets;

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
        apSelectedIndex = combinedApBrackets.getCurrentItem();
        dpSelectedIndex = defenseDpBrackets.getCurrentItem();
    }

    private void setCombinedApBrackets() {
        BracketAdapter apAdapter = new BracketAdapter();
        apAdapter.addAll(AttackPowerCalculator.getBrackets());
        setBrackets(combinedApBrackets, apAdapter);
    }

    private void setDefenseDpBrackets() {
        BracketAdapter dpAdapter = new BracketAdapter();
        dpAdapter.addAll(DefensePowerCalculator.getBrackets());
        setBrackets(defenseDpBrackets, dpAdapter);
    }

    private void setBrackets(DiscreteScrollView scrollView, BracketAdapter adapter) {
        scrollView.setOffscreenItems(ITEM_COUNT);
        scrollView.setOverScrollEnabled(false);
        scrollView.setSlideOnFling(true);
        scrollView.setSlideOnFlingThreshold(FLING_THRESHOLD);
        adapter.addAll(AttackPowerCalculator.getBrackets());
        scrollView.setAdapter(adapter);
        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build()
        );
    }
}
