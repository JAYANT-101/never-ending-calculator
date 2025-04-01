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

    // This is a window this will have the panel
    JFrame frame=new JFrame("Calculator");
    // Put the text inside the label
    JLabel displayLabel=new JLabel();
    // Then put the Label in the panel
    JPanel displayPanel=new JPanel();
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

    }
}
