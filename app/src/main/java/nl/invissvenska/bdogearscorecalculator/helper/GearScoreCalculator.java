package nl.invissvenska.bdogearscorecalculator.helper;

import android.widget.TextView;

import nl.invissvenska.bdogearscorecalculator.R;

public class GearScoreCalculator {

    private static final String DEFAULT_GS = "0";

    private Integer combinedAttackPower;
    private Integer awakenedAttackPower;
    private Integer defensePower;
    private TextView gearScoreLabel;
    private TextView gearScoreSubLabel;

    private int[][] labels = {
            {0, 499, R.string.gs_low},
            {500, 539, R.string.gs_medium},
            {540, 579, R.string.gs_high},
            {580, 999, R.string.gs_endgame}
    };

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
            int gearScore = ((combinedAttackPower + awakenedAttackPower) / 2) + defensePower;
            gearScoreLabel.setText(String.valueOf(gearScore));

            for (int[] label : labels) {
                if (gearScore >= label[0] && gearScore <= label[1]) {
                    gearScoreSubLabel.setText(label[2]);
                }
            }
        }
    }
}
