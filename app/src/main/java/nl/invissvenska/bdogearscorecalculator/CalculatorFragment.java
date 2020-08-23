package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.GearScoreCalculator;

public class CalculatorFragment extends Fragment {

    private TextInputLayout combinedAttackPower;
    private TextInputLayout awakenedAttackPower;
    private TextInputLayout defensePower;
    private GearScoreCalculator calculator;

    private String attackInputValue;
//    private String awakenedAttackInputValue;
//    private String defenseInputValue;

    private static final String INPUT_COMBINED_ATTACK = "COMBINED_ATTACK";


    public CalculatorFragment() {
        //keep default constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putString(INPUT_COMBINED_ATTACK, "200");
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        onRestoreInstanceState(savedInstanceState);
    }

    private void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String SomeText = savedInstanceState.getString(INPUT_COMBINED_ATTACK);
            Log.d("BDO", "restored value: " + SomeText);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        if (savedInstanceState != null) {
            String SomeText = savedInstanceState.getString(INPUT_COMBINED_ATTACK);
            Log.d("BDO", "restored value: " + SomeText);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);

        calculator = new GearScoreCalculator();
        calculator.setGearScoreLabel((TextView) view.findViewById(R.id.gearScore));
        calculator.setGearScoreSubLabel((TextView) view.findViewById(R.id.gearScoreSub));
        combinedAttackPower = view.findViewById(R.id.combinedAttackPower);
        awakenedAttackPower = view.findViewById(R.id.awakenedAttackPower);
        defensePower = view.findViewById(R.id.defensePower);
        setInputFields();

        onRestoreInstanceState(savedInstanceState);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onRestoreInstanceState(savedInstanceState);
    }

    private void setInputFields() {
        combinedAttackPower.getEditText().addTextChangedListener(attackTextWatcher);

        awakenedAttackPower.getEditText().addTextChangedListener(attackTextWatcher);

        defensePower.getEditText().addTextChangedListener(defenseTextWatcher);
    }

    private TextWatcher attackTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            Integer bonus = 0;
            Integer value = 0;
            try {
                value = Integer.parseInt(s.toString());
                bonus = AttackPowerCalculator.calculate(value);
            } catch (NumberFormatException e) {
                Log.e("BDO", e.getMessage());
            } finally {
                if (combinedAttackPower.getEditText().getText().hashCode() == s.hashCode()) {
                    combinedAttackPower.setSuffixText("+" + bonus);
                    calculator.setCombinedAttackPower(value);
                } else if (awakenedAttackPower.getEditText().getText().hashCode() == s.hashCode()) {
                    awakenedAttackPower.setSuffixText("+" + bonus);
                    calculator.setAwakenedAttackPower(value);
                }
            }
        }
    };

    private TextWatcher defenseTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            Integer bonus = 0;
            Integer value = 0;
            try {
                value = Integer.parseInt(s.toString());
                bonus = DefensePowerCalculator.calculate(value);
            } catch (NumberFormatException e) {
                Log.e("BDO", e.getMessage());
            } finally {
                defensePower.setSuffixText("+" + bonus + "%");
                calculator.setDefensePower(value);
            }
        }
    };
}
