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

import java.util.Objects;

import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.GearScoreCalculator;

public class CalculatorFragment extends Fragment {

    private TextInputLayout combinedAttackPower;
    private TextInputLayout awakenedAttackPower;
    private TextInputLayout defensePower;
    private GearScoreCalculator calculator;

    private String attackInputValue = "";
    private String awakenedAttackInputValue = "";
    private String defenseInputValue = "";

    private static final String INPUT_COMBINED_ATTACK = "COMBINED_ATTACK";

    public CalculatorFragment() {
        //keep default constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            String SomeText = savedInstanceState.getString(INPUT_COMBINED_ATTACK);
            Log.d("BDO", "restored value: " + SomeText);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        restoreInput();

        return view;
    }

    private void restoreInput() {
        if (!attackInputValue.isEmpty()) {
            Objects.requireNonNull(combinedAttackPower.getEditText()).setText(attackInputValue);
        }
        if (!awakenedAttackInputValue.isEmpty()) {
            Objects.requireNonNull(awakenedAttackPower.getEditText()).setText(awakenedAttackInputValue);
        }
        if (!defenseInputValue.isEmpty()) {
            Objects.requireNonNull(defensePower.getEditText()).setText(defenseInputValue);
        }
    }

    private void setInputFields() {
        Objects.requireNonNull(combinedAttackPower.getEditText()).addTextChangedListener(attackTextWatcher);
        Objects.requireNonNull(awakenedAttackPower.getEditText()).addTextChangedListener(attackTextWatcher);
        Objects.requireNonNull(defensePower.getEditText()).addTextChangedListener(defenseTextWatcher);
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
            } finally {
                if (Objects.requireNonNull(combinedAttackPower.getEditText()).getText().hashCode() == s.hashCode()) {
                    attackInputValue = s.toString();
                    combinedAttackPower.setSuffixText("+" + bonus);
                    calculator.setCombinedAttackPower(value);
                } else if (Objects.requireNonNull(awakenedAttackPower.getEditText()).getText().hashCode() == s.hashCode()) {
                    awakenedAttackInputValue = s.toString();
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
            int value = 0;
            try {
                value = Integer.parseInt(s.toString());
                bonus = DefensePowerCalculator.calculate(value);
            } catch (NumberFormatException e) {
            } finally {
                defenseInputValue = s.toString();
                defensePower.setSuffixText("+" + bonus + "%");
                calculator.setDefensePower(value);
            }
        }
    };
}
