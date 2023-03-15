package xyz.rewired.display;

import javax.swing.*;

import xyz.rewired.core.CalculatorLogic;

import java.awt.*;

public class CalculatorBox extends JFrame {
    private final int WIDTH = 300;
    private final int HEIGHT = 250;
    JTextField output;
    JButton add;
    JButton subtract;
    JButton multiply;
    JButton divide;
    JButton clearButton;
    JButton deleteButton;
    JButton enterButton;
    JButton[] numbers;
    JPanel mainPanel;
    CalculatorLogic logic;

    public CalculatorBox() {
        super("Java Calculator");
        this.setIconImage(null);
        logic = new CalculatorLogic();
        mainPanel = new JPanel();
        numbers = new JButton[10];
        numbersPanelSetUp();
        operationsPanelSetUp();
        setUp();
        this.add(mainPanel);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setUpActionListeners();
    }

    public CalculatorLogic getLogic() {
        return logic;
    }

    public void updateDisplay() {
        output.setText(String.valueOf(logic.getResult()));
    }

    public void clearOutput() {
        output.setText("0");
    }

    private void resultsPanelSetUp() {
        output = new JTextField(16);
        output.setMaximumSize(new Dimension(290, 40));
        output.setFont(new Font("Monospaced", Font.BOLD, 27));
        output.setDisabledTextColor(new Color(0, 0, 0));
        output.setMargin(new Insets(0, 5, 0, 0));
        output.setText("0");
        mainPanel.add(output);
    }

    private void numbersPanelSetUp() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].setFont(new Font("Monospaced", Font.BOLD, 22));
        }
    }

    private void operationsPanelSetUp() {
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        clearButton = new JButton("clear");
        deleteButton = new JButton("delete");
        enterButton = new JButton("=");
        // Style other buttons
        enterButton.setFont(new Font("Monospaced", Font.BOLD, 22));
        add.setFont(new Font("Monospaced", Font.BOLD, 22));
        subtract.setFont(new Font("Monospaced", Font.BOLD, 22));
        divide.setFont(new Font("Monospaced", Font.BOLD, 22));
        multiply.setFont(new Font("Monospaced", Font.BOLD, 22));
        clearButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        deleteButton.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    private void setUpActionListeners() {
        NumberButtonListener numActionListner = new NumberButtonListener(this);
        for (JButton btn : numbers) {
            btn.addActionListener(numActionListner);
        }
        OtherButtonListener otherActionListener = new OtherButtonListener(this);
        clearButton.addActionListener(otherActionListener);
        enterButton.addActionListener(otherActionListener);

        OperationButtonListener operationButtonListeners = new OperationButtonListener(this);
        add.addActionListener(operationButtonListeners);
        subtract.addActionListener(operationButtonListeners);
        multiply.addActionListener(operationButtonListeners);
        divide.addActionListener(operationButtonListeners);
    }

    private void setUp() {
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        JPanel row4 = new JPanel();
        JPanel row5 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
        row2.setLayout(new BoxLayout(row2, BoxLayout.LINE_AXIS));
        row3.setLayout(new BoxLayout(row3, BoxLayout.LINE_AXIS));
        row4.setLayout(new BoxLayout(row4, BoxLayout.LINE_AXIS));
        row5.setLayout(new BoxLayout(row5, BoxLayout.LINE_AXIS));
        row1.add(Box.createHorizontalGlue());
        row1.add(clearButton);
        row1.add(deleteButton);
        row2.add(numbers[1]);
        row2.add(numbers[2]);
        row2.add(numbers[3]);
        row2.add(add);
        row3.add(numbers[4]);
        row3.add(numbers[5]);
        row3.add(numbers[6]);
        row3.add(subtract);
        row4.add(numbers[7]);
        row4.add(numbers[8]);
        row4.add(numbers[9]);
        row4.add(divide);
        row5.add(Box.createHorizontalGlue());
        row5.add(numbers[0]);
        row5.add(multiply);
        row5.add(enterButton);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        resultsPanelSetUp();
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(row1);
        mainPanel.add(row2);
        mainPanel.add(row3);
        mainPanel.add(row4);
        mainPanel.add(row5);
    }
}
