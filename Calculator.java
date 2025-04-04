import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class Calculator {
    int boarderWidth=360;
    int boarderHeight=540;
    Color customLightGray= new Color(212,212,210);
    Color customDrakeGray= new Color(80,80,80);
    Color customBlack= new Color(28,28,28);
    Color customOrange= new Color(255,149,0);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "=",
            "<","CE","",""
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};
    String[] bottomSymbols={"<","CE"};

    // This is a window this will have the panel
    JFrame frame=new JFrame("Calculator");
    // Put the text inside the label
    JLabel displayLabel=new JLabel();
    // Then put the Label in the panel
    JPanel displayPanel=new JPanel();
    // Fpr buttons
    JPanel buttonsPanel=new JPanel();

    // This will store the values and operator
    String A="0";
    String operator=null;
    String B=null;
    // Function to clear
    void clearAll(){
        A="0";
        operator=null;
        B=null;
    }
    // This function remove decimal if number is hole
    double numDisplay;
    String removeZeroDecimal(double numDisplay){
        if(numDisplay%1==0){
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);
    }
    Calculator(){
        frame.setSize(boarderWidth,boarderHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Label section
        // This will set the colour of the background in the label
        displayLabel.setBackground(customBlack);
        // This will set the colour of the text of the label
        displayLabel.setForeground(Color.white);
        // Setting the font
        displayLabel.setFont(new Font("Arial",Font.PLAIN,80));
        // This will set the location of the label in the window
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        //Panel section
        // This is the layout
        displayPanel.setLayout(new BorderLayout());
        // Putting thr text label into the panel
        displayPanel.add(displayLabel);
        // Adding the panel into the frame giving the comment north it will move in that direction
        frame.add(displayPanel,BorderLayout.NORTH);

        // Setting the buttons
        buttonsPanel.setLayout(new GridLayout(6,4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);

        for(String i :buttonValues){
            JButton button=new JButton();
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(i);
            // This will remove the Square on the buttons when pressed
            button.setFocusable(false);
            buttonsPanel.add(button);
            // This to change the colour of the border
            button.setBorder(new LineBorder(customBlack));
            if(Arrays.asList(topSymbols).contains(i)){
                button.setBackground(customLightGray);
                // This is to set colour of the font
                button.setForeground(customBlack);
            } else if (Arrays.asList(rightSymbols).contains(i)) {
                button.setBackground(customOrange);
                button.setForeground(Color.white);
            } else if (Arrays.asList(bottomSymbols).contains(i)) {
                button.setBackground(customLightGray);
                button.setForeground(customBlack);
            } else {
                button.setBackground(customDrakeGray);
                button.setForeground(Color.white);
            }
            // This is an event listener
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button=(JButton) e.getSource();
                    String buttonValue = button.getText();
                    if(Arrays.asList(topSymbols).contains(buttonValue)){
                        if(Objects.equals(buttonValue,"AC")){
                            clearAll();
                            displayLabel.setText("0");
                        } else if (Objects.equals(buttonValue,"+/-")) {
                            numDisplay=Double.parseDouble(displayLabel.getText());
                            numDisplay *=-1;
                            displayLabel.setText(removeZeroDecimal(numDisplay));
                        }else {
                            numDisplay=Double.parseDouble(displayLabel.getText());
                            numDisplay /=100;
                            displayLabel.setText(removeZeroDecimal(numDisplay));
                        }
                    } else if (Arrays.asList(bottomSymbols).contains(buttonValue)) {
                        if(Objects.equals(buttonValue,"<")) {
                            String a = displayLabel.getText();
                            if (a.length() == 1) {
                                displayLabel.setText("0");
                            }
                            if (!displayLabel.getText().equals("0")) {
                                displayLabel.setText(a.substring(0, a.length() - 1));
                            } else {
                                displayLabel.setText("0");
                            }
                        } else if (Objects.equals(buttonValue,"CE")) {
                            if (!displayLabel.getText().equals("0")){
                                displayLabel.setText("0");
                            }
                        }
                    }
                        else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                        if(Objects.equals(buttonValue,"=")){
                            if (A!=null){
                                B=displayLabel.getText();
                                double numA=Double.parseDouble(A);
                                double numB=Double.parseDouble(B);
                                switch (operator){
                                    case "+" -> {
                                        displayLabel.setText(removeZeroDecimal(numA+numB));
                                        operator=null;
                                    }
                                    case "-" -> {
                                        displayLabel.setText(removeZeroDecimal(numA-numB));
                                        operator=null;
                                    }
                                    case "÷" -> {
                                        displayLabel.setText(removeZeroDecimal(numA/numB));
                                        operator=null;
                                    }
                                    case "×" -> {
                                        displayLabel.setText(removeZeroDecimal(numA*numB));
                                        operator=null;
                                    }
                                }
                            }
                        } else if ("+-÷×".contains(buttonValue)) {
                            if(operator==null){
                                A=displayLabel.getText();
                                displayLabel.setText("0");
                                B="0";
                            }
                            operator=buttonValue;
                        }
                    }else{
                        if(Objects.equals(buttonValue,"√")){
                            double root=Double.parseDouble(displayLabel.getText());
                            displayLabel.setText(removeZeroDecimal(Math.sqrt(root)));
                        }
                        if(Objects.equals(buttonValue,"<")){
                            String a=displayLabel.getText();
                            if(a.length()==1){
                                displayLabel.setText("0");
                            }
                            if(!displayLabel.getText().equals("0")){
                                displayLabel.setText(a.substring(0,a.length()-1));
                            }else {
                                displayLabel.setText("0");
                            }
                        }
                        if(Objects.equals(buttonValue, ".")){
                            if(!displayLabel.getText().contains(".")){
                                displayLabel.setText(displayLabel.getText()+buttonValue);
                            }
                        } else if ("0123456789".contains(buttonValue)) {
                            if(Objects.equals(displayLabel.getText(), "0")){
                                displayLabel.setText(buttonValue);
                            }
                            else {
                                displayLabel.setText(displayLabel.getText()+buttonValue);
                            }

                        }
                    }
                }
            });
        }
        frame.setVisible(true);
    }
}
