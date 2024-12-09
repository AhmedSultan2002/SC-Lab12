package com.example;

public class RecursiveExpressionParser {

    private int currentIndex;
    private String expression;

    /**
     * Evaluates a mathematical expression recursively.
     *
     * @param expr the input mathematical expression as a string
     * @return the calculated result as a double
     */
    public double evaluateExpression(String expr) {
        if (expr == null || expr.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        expression = expr.replaceAll("\\s", ""); // Remove whitespaces
        currentIndex = 0;
        return parseExpression();
    }

    /**
     * Parses the full expression, handling addition and subtraction.
     *
     * @return the result of the parsed expression
     */
    private double parseExpression() {
        double result = parseTerm();
    
        while (currentIndex < expression.length()) {
            char operator = expression.charAt(currentIndex);
    
            if (operator == '+' || operator == '-') {
                currentIndex++;
                double nextTerm = parseTerm();
                if (operator == '+') {
                    result += nextTerm;
                } else {
                    result -= nextTerm;
                }
            } else {
                break;
            }
        }
    
        return result;
    }

    /**
     * Parses a term, handling multiplication and division.
     *
     * @return the result of the parsed term
     */
    private double parseTerm() {
        double result = parseFactor();

        while (currentIndex < expression.length()) {
            char operator = expression.charAt(currentIndex);

            if (operator == '*' || operator == '/') {
                currentIndex++;
                double nextFactor = parseFactor();
                if (operator == '*') {
                    result *= nextFactor;
                } else {
                    if (nextFactor == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    result /= nextFactor;
                }
            } else {
                break;
            }
        }

        return result;
    }

    /**
     * Parses a factor, handling numbers and parentheses.
     *
     * @return the result of the parsed factor
     */
    private double parseFactor() {
        if (currentIndex >= expression.length()) {
            throw new IllegalArgumentException("Unexpected end of expression");
        }

        char currentChar = expression.charAt(currentIndex);

        // Handle parentheses
        if (currentChar == '(') {
            currentIndex++;
            double result = parseExpression();
            if (currentIndex >= expression.length() || expression.charAt(currentIndex) != ')') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            currentIndex++;
            return result;
        }

        // Parse numbers
        StringBuilder number = new StringBuilder();
        boolean hasDecimal = false;

        while (currentIndex < expression.length()) {
            currentChar = expression.charAt(currentIndex);

            if (Character.isDigit(currentChar)) {
                number.append(currentChar);
            } else if (currentChar == '.' && !hasDecimal) {
                hasDecimal = true;
                number.append(currentChar);
            } else {
                break;
            }
            currentIndex++;
        }

        if (number.length() == 0) {
            throw new IllegalArgumentException("Invalid number format");
        }

        return Double.parseDouble(number.toString());
    }
}
