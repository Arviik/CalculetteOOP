package math.operator;

import math.MathElement;

public class Divide implements MathElement, MathOperator {
    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public String toChar() {
        return "/";
    }

    @Override
    public int process(int number1, int number2) {
        return number1 / number2;
    }
}
