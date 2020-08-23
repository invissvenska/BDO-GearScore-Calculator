package nl.invissvenska.bdogearscorecalculator.helper;

import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

import nl.invissvenska.bdogearscorecalculator.R;

public class GearScoreCalculator {

    private static final String DEFAULT_GS = "0";

    private BigDecimal combinedAttackPower;
    private BigDecimal awakenedAttackPower;
    private BigDecimal defensePower;
    private TextView gearScoreLabel;
    private TextView gearScoreSubLabel;

    private int[][] labels = {
            {0, 499, R.string.gs_low},
            {500, 539, R.string.gs_medium},
            {540, 579, R.string.gs_high},
            {580, 999, R.string.gs_endgame}
    };

    public void setCombinedAttackPower(Integer combinedAttackPower) {
        this.combinedAttackPower = new BigDecimal(combinedAttackPower);
        calculate();
    }

    public void setAwakenedAttackPower(Integer awakenedAttackPower) {
        this.awakenedAttackPower = new BigDecimal(awakenedAttackPower);
        calculate();
    }

    public void setDefensePower(Integer defensePower) {
        this.defensePower = new BigDecimal(defensePower);
        calculate();
    }

    public void setGearScoreLabel(TextView gearScoreLabel) {
        this.gearScoreLabel = gearScoreLabel;
        this.gearScoreLabel.setText(DEFAULT_GS);
    }

    public void setGearScoreSubLabel(TextView gearScoreSubLabel) {
        this.gearScoreSubLabel = gearScoreSubLabel;
    }

    public void calculate() {
        if (combinedAttackPower == null || awakenedAttackPower == null || defensePower == null) {
            gearScoreLabel.setText(DEFAULT_GS);
        } else {

            BigDecimal gearScore = (combinedAttackPower.add(awakenedAttackPower)).divide(new BigDecimal(2)).add(defensePower);
            gearScoreLabel.setText(String.valueOf(gearScore.setScale(0, RoundingMode.UP)));

            for (int[] label : labels) {
                if (gearScore.intValue() >= label[0] && gearScore.intValue() <= label[1]) {
                    gearScoreSubLabel.setText(label[2]);
                }
            }
        }
    }
}
