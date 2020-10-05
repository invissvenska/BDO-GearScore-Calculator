package nl.invissvenska.bdogearscorecalculator.binding;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import nl.invissvenska.bdogearscorecalculator.R;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketAdapter;
import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

public final class ScrollViewBinding {

    private static final Integer ITEM_COUNT = 15;
    private static final Integer FLING_THRESHOLD = 1000;
    private static final Integer DEFAULT_SELECTED_INDEX = 3;

    private ScrollViewBinding() {
        // hide public constructor
    }

    @BindingAdapter("adapter")
    public static void bindAdapter(DiscreteScrollView view, BracketAdapter adapter) {
        view.setAdapter(adapter);
        view.setOffscreenItems(ITEM_COUNT);
        view.setOverScrollEnabled(false);
        view.setSlideOnFling(true);
        view.scrollToPosition(DEFAULT_SELECTED_INDEX);
        view.setSlideOnFlingThreshold(FLING_THRESHOLD);
        view.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build()
        );
    }

    @BindingAdapter("fromTo")
    public static void bindFromTo(TextView view, BracketItem item) {
        if (item.getTo().equals(999)) {
            view.setText(view.getResources().getString(R.string.bracket_value_max, item.getFrom()));
        } else {
            view.setText(view.getResources().getString(R.string.bracket_value, item.getFrom(), item.getTo()));
        }
    }

    @BindingAdapter("bonus")
    public static void bindBonus(TextView view, BracketItem item) {
        view.setText(view.getResources().getString(R.string.bracket_bonus, item.getPrefix(), item.getBonus(), item.getSuffix()));
    }
}
