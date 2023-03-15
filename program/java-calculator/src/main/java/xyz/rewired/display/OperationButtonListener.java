package xyz.rewired.display;

import java.awt.event.*;

import javax.swing.JButton;

import xyz.rewired.core.Operation;

public class OperationButtonListener implements ActionListener {
    CalculatorBox box;

    public OperationButtonListener(CalculatorBox calculatorBox) {
        this.box = calculatorBox;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton btn = (JButton) event.getSource();
        String operation = btn.getText();
        switch (operation) {
            case "+":
                box.getLogic().setOperation(Operation.ADD);
                break;
            case "*":
                box.getLogic().setOperation(Operation.MULTIPLY);
                break;
            case "/":
                box.getLogic().setOperation(Operation.DIVIDE);
                break;
            case "-":
                box.getLogic().setOperation(Operation.SUBTRACT);
                break;
            default:
                return;
        }
    }

}

class NumberButtonListener implements ActionListener {
    CalculatorBox box;

    public NumberButtonListener(CalculatorBox calculatorBox) {
        this.box = calculatorBox;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton btn = (JButton) event.getSource();
        String num = btn.getText();
        box.getLogic().setNumFromUser(num);
    }

}

class OtherButtonListener implements ActionListener {
    CalculatorBox box;

    public OtherButtonListener(CalculatorBox calculatorBox) {
        this.box = calculatorBox;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton btn = (JButton) event.getSource();
        String action = btn.getText();
        if (action.equals("clear")) {
            box.clearOutput();
        } else if (action.equals("=")) {
            box.getLogic().calculate();
            box.updateDisplay();
        }
    }

}
