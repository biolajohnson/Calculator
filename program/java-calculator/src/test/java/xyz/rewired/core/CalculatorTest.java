package xyz.rewired.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void twoPlusTwoShouldBeFour() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void twoMinusTwoShouldBeZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.substract(2, 2));
    }

    @Test
    public void twoTimesThreeShouldBeSix() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void ZeroDivideTwoShouldBeZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.divide(0, 2));
    }

    @Test
    public void twoTimesZeroShouldBeZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.multiply(2, 0));
    }

    @Test
    public void anythingDividedZeroShouldThrowException() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(3, 0);
        });
    }

    @Test
    public void tenDivide3ShouldBeThree() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.divide(10, 3));
    }
}
