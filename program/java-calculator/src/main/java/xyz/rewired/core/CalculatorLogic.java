package xyz.rewired.core;

public class CalculatorLogic {
    private String num1;
    private String num2;
    private Operation operation;
    private Calculator calculator;
    private int result;

    public CalculatorLogic() {
        num1 = "";
        num2 = "";
        calculator = new Calculator();
        operation = null;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setNumFromUser(String num) {
        if (operation == null) {
            num1 += num;
        } else {
            num2 += num;
        }
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num) {
        this.num1 = num;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num) {
        this.num2 = num;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void calculate() {
        switch (operation) {
            case ADD:
                operation = null;
                result = calculator.add(num1.equals("") ? result : Integer.parseInt(num1), Integer.parseInt(num2));
                setNum1("");
                setNum2("");
                break;
            case SUBTRACT:
                operation = null;
                result = calculator.substract(num1.equals("") ? result : Integer.parseInt(num1),
                        Integer.parseInt(num2));
                setNum1("");
                setNum2("");
                break;
            case MULTIPLY:
                operation = null;
                result = calculator.multiply(num1.equals("") ? result : Integer.parseInt(num1), Integer.parseInt(num2));
                setNum1("");
                setNum2("");
                break;
            case DIVIDE:
                operation = null;
                result = calculator.divide(num1.equals("") ? result : Integer.parseInt(num1), Integer.parseInt(num2));
                setNum1("");
                setNum2("");
                break;
            default:
                return;
        }
    }

    public void reset() {
        this.result = 0;
        this.num1 = "";
        this.num2 = "";
        this.operation = null;
    }

}
