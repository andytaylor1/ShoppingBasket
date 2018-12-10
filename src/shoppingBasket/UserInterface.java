package shoppingBasket;
import java.awt.*;

import javax.swing.*;

public class UserInterface {
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("Shopping basket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,300);
        frame.setVisible(true); 
        
        
        JPanel inner = new JPanel();
        JPanel lower = new JPanel();
        inner.setLayout(new GridBagLayout());
        lower.setLayout(new GridBagLayout());
        
        frame.getContentPane().add(inner, BorderLayout.NORTH);
        frame.getContentPane().add(lower, BorderLayout.SOUTH);
        
        JButton button1 = new JButton("Press");
        JButton button2 = new JButton("Press");
        JButton button3 = new JButton("Press");
        JButton button4 = new JButton("Press");
        JButton button5 = new JButton("Press");
        
        JButton button6 = new JButton("Press");
        JButton button7 = new JButton("Press");
        JButton button8 = new JButton("Press");
        JButton button9 = new JButton("Press");
        JButton button10 = new JButton("Press");
        
        
        inner.add(button1);
        inner.add(button2);
        inner.add(button3);
        inner.add(button4);
        inner.add(button5);
        
        lower.add(button6);
        lower.add(button7);
        lower.add(button8);
        lower.add(button9);
        lower.add(button10);
        
        inner.setVisible(true); 
        lower.setVisible(true);
		
	}

}
