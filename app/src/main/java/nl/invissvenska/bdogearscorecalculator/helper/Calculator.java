package nl.invissvenska.bdogearscorecalculator.helper;

import java.util.List;

import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

public abstract class Calculator {

    public abstract Integer calculate(Integer attack);

    public abstract List<BracketItem> getBrackets();
}
