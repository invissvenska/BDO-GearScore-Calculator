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

    private DiscreteScrollView combinedApBrackets;
    private DiscreteScrollView defenseDpBrackets;


    public BracketFragment() {
        //keep default constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_brackets, container, false);

        combinedApBrackets = view.findViewById(R.id.combinedApBrackets);
        defenseDpBrackets = view.findViewById(R.id.defenseDpBrackets);

        setCombinedApBrackets();
        setDefenseDpBrackets();

        return view;
    }

    private void setCombinedApBrackets() {
        combinedApBrackets.setOffscreenItems(ITEM_COUNT);
        combinedApBrackets.setOverScrollEnabled(false);
        combinedApBrackets.setSlideOnFling(true);
        combinedApBrackets.setSlideOnFlingThreshold(FLING_THRESHOLD);
        BracketAdapter apAdapter = new BracketAdapter();
        apAdapter.addAll(AttackPowerCalculator.getBrackets());
        combinedApBrackets.setAdapter(apAdapter);
        combinedApBrackets.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build()
        );
    }

    private void setDefenseDpBrackets() {
        defenseDpBrackets.setOffscreenItems(ITEM_COUNT);
        defenseDpBrackets.setOverScrollEnabled(false);
        defenseDpBrackets.setSlideOnFling(true);
        defenseDpBrackets.setSlideOnFlingThreshold(FLING_THRESHOLD);
        BracketAdapter apAdapter = new BracketAdapter();
        apAdapter.addAll(DefensePowerCalculator.getBrackets());
        defenseDpBrackets.setAdapter(apAdapter);
        defenseDpBrackets.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build()
        );
    }
}
