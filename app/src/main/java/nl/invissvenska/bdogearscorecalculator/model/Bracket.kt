package nl.invissvenska.bdogearscorecalculator.model

data class Bracket(
        var from: Int,
        var to: Int,
        var bonus: Int,
        var prefix: String,
        var suffix: String
) {
    fun range(): String {
        val builder = StringBuilder()
        builder.append(from)
        if (to == 999) {
            builder.append("+")
        } else {
            builder.append(" - ")
                    .append(to)
        }
        return builder.toString()
    }

    fun bonusValue(): String {
        val builder = StringBuilder()
        builder.append(prefix)
                .append(bonus)
                .append(suffix)
        return builder.toString()
    }
}