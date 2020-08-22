package nl.invissvenska.bdogearscorecalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import nl.invissvenska.bdogearscorecalculator.helper.AttackPowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.DefensePowerCalculator;
import nl.invissvenska.bdogearscorecalculator.helper.GearScoreCalculator;

public class MainActivity extends AppCompatActivity {

    TextInputLayout combinedAttackPower;
    TextInputLayout awakenedAttackPower;
    TextInputLayout defensePower;

    GearScoreCalculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new GearScoreCalculator();
        calculator.setGearScoreLabel((TextView)findViewById(R.id.gearScore));
        calculator.setGearScoreSubLabel((TextView)findViewById(R.id.gearScoreSub));

        combinedAttackPower = findViewById(R.id.combinedAttackPower);
        combinedAttackPower.getEditText().addTextChangedListener(attackTextWatcher);

        awakenedAttackPower = findViewById(R.id.awakenedAttackPower);
        awakenedAttackPower.getEditText().addTextChangedListener(attackTextWatcher);

        defensePower = findViewById(R.id.defensePower);
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
            try {value = Integer.parseInt(s.toString());
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