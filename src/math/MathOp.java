package math;

import math.operator.MathOperator;

import java.util.ArrayList;
import java.util.List;

public class MathOp {
    private final List<MathElement> mathElementsList;

    private int result;

    public MathOp() {
        this.mathElementsList = new ArrayList<>();
    }

    public void process() {
        System.out.println("\nProcess :");
        result = findResult(new ArrayList<>(mathElementsList));
    }

    private int findResult(List<MathElement> mathElementsListBuffer) {
        MathElement mathOperator = mathElementsListBuffer.get(1);
        MathOperator operator = (MathOperator) mathOperator;
        int number1 = ((MathNumber) mathElementsListBuffer.get(0)).getValue();
        int number2 = ((MathNumber) mathElementsListBuffer.get(2)).getValue();

        int opResult = operator.process(number1, number2);
        System.out.println(number1 + " " + mathOperator.toChar() + " " + number2 + " = " + opResult);

        mathElementsListBuffer.set(1, new MathNumber(opResult));
        mathElementsListBuffer.remove(2);
        mathElementsListBuffer.remove(0);

        if (mathElementsListBuffer.size() > 1) {
            return findResult(new ArrayList<>(mathElementsListBuffer));
        }
        return opResult;
    }

    public void fillMathElements(List<MathElement> userPrompt) {
        mathElementsList.addAll(userPrompt);
    }

    public void showResult() {
        System.out.println("\nResult :");
        for (MathElement mathElement : mathElementsList) {
            System.out.print(mathElement.toChar() + " ");
        }
        System.out.print("= " + result);
    }
}
