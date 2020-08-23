package nl.invissvenska.bdogearscorecalculator.helper;

import java.util.ArrayList;
import java.util.List;

import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

public class AttackPowerCalculator {

    private AttackPowerCalculator() {
        //hide constructor
    }

    private static int[][] ap = {
            {0, 99, 0},
            {100, 139, 5},
            {140, 169, 5},
            {170, 183, 5},
            {184, 208, 5},
            {209, 234, 10},
            {235, 244, 10},
            {245, 248, 8},
            {249, 252, 9},
            {253, 256, 12},
            {257, 260, 14},
            {261, 264, 18},
            {265, 268, 21},
            {269, 272, 15},
            {273, 276, 5},
            {277, 280, 6},
            {281, 284, 6},
            {285, 288, 6},
            {289, 292, 7},
            {293, 296, 7},
            {297, 300, 7},
            {301, 304, 7},
            {305, 308, 8},
            {309, 999, 4},
    };

    public static Integer calculate(Integer attack) {
        int currentBracket = getIndexByAP(attack);
        int currentApBonus = 0;

        for (int i = 0; i <= currentBracket; i++) {
            currentApBonus += ap[i][2];
        }
        return currentApBonus;
    }

    public static List<BracketItem> getBrackets() {
        List<BracketItem> brackets = new ArrayList<>();
        for (int[] ints : ap) {
            brackets.add(new BracketItem(ints[0], ints[1], ints[2], "+", ""));
        }
        return brackets;
    }

    public static Integer getIndexByAP(Integer attack) {
        for (int i = 0; i < ap.length; i++) {
            if (attack >= ap[i][0] && attack <= ap[i][1]) {
                return i;
            }
        }
        return 0;
    }
}
