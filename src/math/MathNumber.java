package math;

public class MathNumber implements MathElement {
    private final int value;

    public MathNumber(int value) {
        this.value = value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public String toChar() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }
}
