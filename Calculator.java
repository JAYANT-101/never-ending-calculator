import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
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
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    // This is a window this will have the panel
    JFrame frame=new JFrame("Calculator");
    // Put the text inside the label
    JLabel displayLabel=new JLabel();
    // Then put the Label in the panel
    JPanel displayPanel=new JPanel();
    // Fpr buttons
    JPanel buttonsPanel=new JPanel();
    Calculator(){
        frame.setVisible(true);
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
        buttonsPanel.setLayout(new GridLayout(5,4));
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
            }else {
                button.setBackground(customDrakeGray);
                button.setForeground(Color.white);
            }
        }
    }
}
