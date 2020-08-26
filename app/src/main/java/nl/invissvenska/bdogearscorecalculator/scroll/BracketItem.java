package nl.invissvenska.bdogearscorecalculator.scroll;

public class BracketItem {
    private Integer from;
    private Integer to;
    private Integer bonus;
    private String prefix;
    private String suffix;

    public BracketItem(Integer from, Integer to, Integer bonus, String prefix, String suffix) {
        this.from = from;
        this.to = to;
        this.bonus = bonus;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getBonus() {
        return bonus;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
