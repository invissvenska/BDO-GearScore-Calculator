package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BracketContainerFragment extends Fragment {

    private static final String BRACKET_AP = "APBrackets";

    private BracketAPFragment bracketAPFragment;

    public BracketContainerFragment() {
        // keep default public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.brackets_container, container, false);

//        bracketAPFragment = (BracketAPFragment) getActivity().getSupportFragmentManager().findFragmentByTag(BRACKET_AP);
//
//        if (bracketAPFragment == null) {
//            bracketAPFragment = new BracketAPFragment();
//        }
//        setFragment(bracketAPFragment, R.id.bracketsAP, BRACKET_AP);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bracketAPFragment = (BracketAPFragment) getActivity().getSupportFragmentManager().findFragmentByTag(BRACKET_AP);

        if (bracketAPFragment == null) {
            bracketAPFragment = new BracketAPFragment();
        }
        setFragment(bracketAPFragment, R.id.bracketsAP, BRACKET_AP);
    }

    private void setFragment(Fragment fragment, int container, String tag) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, tag)
                .commit();
    }
}
