package calculator.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(calculator.add(3, 4), 7);
    }

    @Test
    public void subtract() {
        assertEquals(calculator.subtract(4, 3), 1);
    }

}