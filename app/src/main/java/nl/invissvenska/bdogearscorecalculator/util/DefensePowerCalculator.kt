package nl.invissvenska.bdogearscorecalculator.util

import nl.invissvenska.bdogearscorecalculator.model.Bracket
import java.util.*

object DefensePowerCalculator {
    private val dp = arrayOf(
            intArrayOf(0, 202, 0),
            intArrayOf(203, 210, 1),
            intArrayOf(211, 217, 2),
            intArrayOf(218, 225, 3),
            intArrayOf(226, 232, 4),
            intArrayOf(233, 240, 5),
            intArrayOf(241, 247, 6),
            intArrayOf(248, 255, 7),
            intArrayOf(256, 262, 8),
            intArrayOf(263, 270, 9),
            intArrayOf(271, 277, 10),
            intArrayOf(278, 285, 11),
            intArrayOf(286, 292, 12),
            intArrayOf(293, 300, 13),
            intArrayOf(301, 307, 14),
            intArrayOf(308, 314, 15),
            intArrayOf(315, 321, 16),
            intArrayOf(322, 328, 17),
            intArrayOf(329, 334, 18),
            intArrayOf(335, 340, 19),
            intArrayOf(341, 346, 20),
            intArrayOf(347, 352, 21),
            intArrayOf(353, 358, 22),
            intArrayOf(359, 364, 23),
            intArrayOf(365, 370, 24),
            intArrayOf(371, 376, 25),
            intArrayOf(377, 382, 26),
            intArrayOf(383, 388, 27),
            intArrayOf(389, 394, 28),
            intArrayOf(395, 400, 29),
            intArrayOf(401, 999, 30)
    )

    fun calculate(defense: Int): Int {
        var currentDpBonus = 0
        for (ints in dp) {
            if (defense >= ints[0] && defense <= ints[1]) {
                currentDpBonus = ints[2]
                break
            }
        }
        return currentDpBonus
    }

    val brackets: MutableList<Bracket>
        get() {
            val brackets: MutableList<Bracket> = ArrayList()
            for (ints in dp) {
                brackets.add(Bracket(ints[0], ints[1], ints[2], "+", "%"))
            }
            //remove first bracket
            brackets.removeAt(0)
            return brackets
        }

    fun getIndexByDP(defense: Int): Int {
        for (i in dp.indices) {
            if (defense >= dp[i][0] && defense <= dp[i][1]) {
                return i
            }
        }
        return 0
    }
}