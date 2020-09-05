package nl.invissvenska.bdogearscorecalculator.helper;

import java.util.ArrayList;
import java.util.List;

import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

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
            {301, 307, 14},
            {308, 314, 15},
            {315, 321, 16},
            {322, 328, 17},
            {329, 334, 18},
            {335, 340, 19},
            {341, 346, 20},
            {347, 352, 21},
            {353, 358, 22},
            {359, 364, 23},
            {365, 370, 24},
            {371, 376, 25},
            {377, 382, 26},
            {383, 388, 27},
            {389, 394, 28},
            {395, 400, 29},
            {401, 999, 30}
    };

    public static Integer calculate(Integer defense) {
        int currentDpBonus = 0;

        for (int[] ints : dp) {
            if (defense >= ints[0] && defense <= ints[1]) {
                currentDpBonus = ints[2];
                break;
            }
        }
        return currentDpBonus;
    }

    public static List<BracketItem> getBrackets() {
        List<BracketItem> brackets = new ArrayList<>();
        for (int[] ints : dp) {
            brackets.add(new BracketItem(ints[0], ints[1], ints[2], "+", "%"));
        }
        //remove first bracket
        brackets.remove(0);
        return brackets;
    }

    public static Integer getIndexByDP(Integer defense) {
        for (int i = 0; i < dp.length; i++) {
            if (defense >= dp[i][0] && defense <= dp[i][1]) {
                return i;
            }
        }
        return 0;
    }
}
