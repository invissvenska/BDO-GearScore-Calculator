package nl.invissvenska.bdogearscorecalculator.util

import nl.invissvenska.bdogearscorecalculator.model.Bracket
import java.util.*

object AttackPowerCalculator {
    private val ap = arrayOf(
            intArrayOf(0, 99, 0),
            intArrayOf(100, 139, 5),
            intArrayOf(140, 169, 5),
            intArrayOf(170, 183, 5),
            intArrayOf(184, 208, 5),
            intArrayOf(209, 234, 10),
            intArrayOf(235, 244, 10),
            intArrayOf(245, 248, 8),
            intArrayOf(249, 252, 9),
            intArrayOf(253, 256, 12),
            intArrayOf(257, 260, 14),
            intArrayOf(261, 264, 18),
            intArrayOf(265, 268, 21),
            intArrayOf(269, 272, 15),
            intArrayOf(273, 276, 5),
            intArrayOf(277, 280, 6),
            intArrayOf(281, 284, 6),
            intArrayOf(285, 288, 6),
            intArrayOf(289, 292, 7),
            intArrayOf(293, 296, 7),
            intArrayOf(297, 300, 7),
            intArrayOf(301, 304, 7),
            intArrayOf(305, 308, 8),
            intArrayOf(309, 315, 4),
            intArrayOf(316, 322, 3),
            intArrayOf(323, 329, 2),
            intArrayOf(330, 339, 2),
            intArrayOf(340, 999, 3)
    )

    fun calculate(attack: Int): Int {
        val currentBracket = getIndexByAP(attack)
        var currentApBonus = 0
        for (i in 0..currentBracket) {
            currentApBonus += ap[i][2]
        }
        return currentApBonus
    }

    val brackets: MutableList<Bracket>
        get() {
            val brackets: MutableList<Bracket> = ArrayList()
            for (ints in ap) {
                brackets.add(Bracket(ints[0], ints[1], ints[2], "+", ""))
            }
            //remove first bracket
            brackets.removeAt(0)
            return brackets
        }

    fun getIndexByAP(attack: Int): Int {
        for (i in ap.indices) {
            if (attack >= ap[i][0] && attack <= ap[i][1]) {
                return i
            }
        }
        return 0
    }
}