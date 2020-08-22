package nl.invissvenska.bdogearscorecalculator.helper;

import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GearScoreCalculator {

    private Integer combinedAttackPower;
    private Integer awakenedAttackPower;
    private Integer defensePower;
    private TextView gearScoreLabel;
    private TextView gearScoreSubLabel;

    private Map<Integer, String> subTitles = new HashMap<Integer, String>() {{
        put(499, "Oh, do not despair, someday, with due diligence, you raise the gearscore =)");
        put(539, "Already better, but there is something to strive for =)");
        put(579, "Good gearscore");
        put(999, "Ohh my, nice!");
    }};

    public void setCombinedAttackPower(Integer combinedAttackPower) {
        this.combinedAttackPower = combinedAttackPower;
        calculate();
    }

    public void setAwakenedAttackPower(Integer awakenedAttackPower) {
        this.awakenedAttackPower = awakenedAttackPower;
        calculate();
    }

    public void setDefensePower(Integer defensePower) {
        this.defensePower = defensePower;
        calculate();
    }

    public GearScoreCalculator setGearScoreLabel(TextView gearScoreLabel) {
        this.gearScoreLabel = gearScoreLabel;
        return this;
    }

    public GearScoreCalculator setGearScoreSubLabel(TextView gearScoreSubLabel) {
        this.gearScoreSubLabel = gearScoreSubLabel;
        return this;
    }

    public void calculate() {
        if (combinedAttackPower == null || awakenedAttackPower == null || defensePower == null) {
            gearScoreLabel.setText("Fill in all fields");
        } else {
            Integer gearScore = ((combinedAttackPower + awakenedAttackPower) / 2) + defensePower;
            gearScoreLabel.setText("" + gearScore);

            for (Map.Entry<Integer, String> entry : subTitles.entrySet()) {
                if (gearScore <= entry.getKey()) {
                    gearScoreSubLabel.setText(entry.getValue());
                    return;
                }
            }
        }
    }
}
