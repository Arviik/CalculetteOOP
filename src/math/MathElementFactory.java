package math;

import math.operator.Divide;
import math.operator.Minus;
import math.operator.Multiply;
import math.operator.Plus;

public final class MathElementFactory {

    private MathElementFactory() {
    }

    public static MathElement newMathElements(String stringElements) {
        switch (stringElements) {
            case "+" -> {
                return new Plus();
            }
            case "-" -> {
                return new Minus();
            }
            case "*" -> {
                return new Multiply();
            }
            case "/" -> {
                return new Divide();
            }
            default -> {
                return new MathNumber(Integer.parseInt(stringElements));
            }
        }
    }
}
