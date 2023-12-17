import math.MathOp;
import math.prompt.Prompt;

public class Main {
    public static void main(String[] args) {
        MathOp op = new MathOp();

        op.fillMathElements(Prompt.getUserPrompt());
        op.process();
        op.showResult();
    }
}
