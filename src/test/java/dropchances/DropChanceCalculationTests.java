package dropchances;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.falgael.rpg.loottable.DropChanceTranslation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DropChanceCalculationTests implements DropChanceTranslation {

    @Test
    @DisplayName("Misc coverage")
    public void testFirst_Test() {
        assertEquals(2, translateDropChance(2.0));
        assertEquals(0, translateDropChance(-1.0));
        assertEquals(100, translateDropChance(100.0));
        assertEquals(50, translateDropChance(50.0));
    }

    @Test
    @DisplayName("Misc range coverage")
    public void simple_range_Test() {
        rangeTest(0.5);
        rangeTest(0.25);
        rangeTest(0.75);
    }

    @Test
    @DisplayName("Advanced range coverage")
    public void advanced_range_Test() {
        rangeTest(0.01,1);
        rangeTest(1000000,0.00001, 1);
    }


    private void rangeTest(int loopAmount, double dropRate, double deviationPercentage) {
        int temporaryValue = 0;
        for (int i = 0; i < loopAmount; i++) {
            temporaryValue += translateDropChance(dropRate);
        }
        assertTrue(temporaryValue / (double) loopAmount > (dropRate - dropRate / deviationPercentage)
                && temporaryValue / (double) loopAmount < (dropRate + dropRate / deviationPercentage));
    }

    private void rangeTest(double dropRate) {
        rangeTest(10000, dropRate, 10);
    }

    private void rangeTest(double dropRate, double deviationPercentage) {
        rangeTest(10000, dropRate, deviationPercentage);
    }


}
