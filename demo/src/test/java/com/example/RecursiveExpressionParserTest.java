package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecursiveExpressionParserTest {

    @Test
    void testBasicOperations() {
        RecursiveExpressionParser parser = new RecursiveExpressionParser();
        assertEquals(13.0, parser.evaluateExpression("3 + 5 * 2"), 0.0001);
        assertEquals(8.5, parser.evaluateExpression("10 / 2 + 3.5"), 0.0001);
        assertEquals(25.0, parser.evaluateExpression("5 * (2 + 3)"), 0.0001);
    }

    @Test
    void testParenthesesHandling() {
        RecursiveExpressionParser parser = new RecursiveExpressionParser();
        assertEquals(16.0, parser.evaluateExpression("(3 + 5) * 2"), 0.0001);
        assertEquals(11.0, parser.evaluateExpression("(1 + 2) * 3 + 4 / 2"), 0.0001);
    }

    @Test
    void testFloatingPointNumbers() {
        RecursiveExpressionParser parser = new RecursiveExpressionParser();
        assertEquals(7.35, parser.evaluateExpression("3.5 + 3.85"), 0.0001);
        assertEquals(12.5, parser.evaluateExpression("5.0 * 2.5"), 0.0001);
    }

    @Test
    void testDivisionByZero() {
        RecursiveExpressionParser parser = new RecursiveExpressionParser();
        assertThrows(ArithmeticException.class, () -> parser.evaluateExpression("10 / 0"));
    }

    @Test
    void testInvalidExpressions() {
        RecursiveExpressionParser parser = new RecursiveExpressionParser();
        assertThrows(IllegalArgumentException.class, () -> parser.evaluateExpression("(3 + 5"));
        assertThrows(IllegalArgumentException.class, () -> parser.evaluateExpression("3 + * 2"));
        assertThrows(IllegalArgumentException.class, () -> parser.evaluateExpression(""));
    }
}
