package nl.invissvenska.bdogearscorecalculator.helper;

public class DefensePowerCalculator {

    private DefensePowerCalculator() {
        //hide constructor
    }

    private static int[][] dp = {
            {0, 202, 0},
            {203, 210, 1},
            {211, 217, 2},
            {218, 225, 3},
            {226, 232, 4},
            {233, 240, 5},
            {241, 247, 6},
            {248, 255, 7},
            {256, 262, 8},
            {263, 270, 9},
            {271, 277, 10},
            {278, 285, 11},
            {286, 292, 12},
            {293, 300, 13},
            {301, 308, 14},
            {309, 315, 15},
            {316, 323, 16},
            {324, 330, 17},
            {331, 338, 18},
            {339, 435, 19},
            {346, 999, 20}
    };

    public static Integer calculate(Integer attack) {
        int currentDpBonus = 0;

        for (int[] ints : dp) {
            if (attack >= ints[0] && attack <= ints[1]) {
                currentDpBonus = ints[2];
                break;
            }
        }
        return currentDpBonus;
    }
}
