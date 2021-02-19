package nl.invissvenska.bdogearscorecalculator.model

data class Bracket(
        var from: Int,
        var to: Int,
        var bonus: Int,
        var prefix: String,
        var suffix: String
)