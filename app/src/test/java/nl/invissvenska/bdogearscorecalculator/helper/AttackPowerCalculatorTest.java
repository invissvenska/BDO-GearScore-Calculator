package nl.invissvenska.bdogearscorecalculator.helper;

import org.junit.Test;

import java.util.List;

import nl.invissvenska.bdogearscorecalculator.scroll.BracketItem;

import static org.junit.Assert.assertEquals;

public class AttackPowerCalculatorTest {

    @Test
    public void testCalculate_99_Bonus() {
        Integer input = 99;
        Integer expected = 0;
        assertEquals(expected, AttackPowerCalculator.calculate(input));
    }

    @Test
    public void testCalculate_250_Bonus() {
        Integer input = 250;
        Integer expected = 57;
        assertEquals(expected, AttackPowerCalculator.calculate(input));
    }

    @Test
    public void testCalculate_999_Bonus() {
        Integer input = 999;
        Integer expected = 210;
        assertEquals(expected, AttackPowerCalculator.calculate(input));
    }

    @Test
    public void testIndexByAP_99() {
        Integer input = 99;
        Integer expected = 0;
        assertEquals(expected, AttackPowerCalculator.getIndexByAP(input));
    }

    @Test
    public void testIndexByAP_250() {
        Integer input = 250;
        Integer expected = 8;
        assertEquals(expected, AttackPowerCalculator.getIndexByAP(input));
    }

    @Test
    public void testIndexByAP_999() {
        Integer input = 999;
        Integer expected = 27;
        assertEquals(expected, AttackPowerCalculator.getIndexByAP(input));
    }

    @Test
    public void testGetBrackets() {
        int expectedSize = 27;
        Integer expectedFrom = 209;
        Integer expectedTo = 234;
        Integer expectedBonus = 10;
        String expectedPrefix = "+";
        String expectedSuffix = "";

        List<BracketItem> actualList = AttackPowerCalculator.getBrackets();

        assertEquals(expectedSize, actualList.size());
        assertEquals(expectedFrom, actualList.get(4).getFrom());
        assertEquals(expectedTo, actualList.get(4).getTo());
        assertEquals(expectedBonus, actualList.get(4).getBonus());
        assertEquals(expectedPrefix, actualList.get(4).getPrefix());
        assertEquals(expectedSuffix, actualList.get(4).getSuffix());
    }
}
