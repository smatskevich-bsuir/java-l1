package com.smatskevich.lab1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class Lab1 {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Lab1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        JPanel firstLine = new JPanel();
        firstLine.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel labelTip = new JLabel("Номер числа Фибоначчи");
        firstLine.add(labelTip);
        
        JTextField fileld = new JTextField(8);
        firstLine.add(fileld);
        
        JLabel labelResultMessage = new JLabel("Значение: ");
        firstLine.add(labelResultMessage);
        
        JLabel labelResultValue = new JLabel("");
        firstLine.add(labelResultValue);
        
        JPanel secondLine = new JPanel();
        secondLine.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JButton calcButton = new JButton("Посчитать");
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int number = 0;
            	
            	try {
            		number = Integer.parseInt(fileld.getText());
            	} catch (NumberFormatException err) {
            		labelResultValue.setText("Error");
                    frame.pack();
            		return;
            	}
            	
            	if(number < 1 || number > 47) {
            		labelResultValue.setText("Error");
                    frame.pack();
            		return;
            	}
            	
            	int result = 0;
            	int[] prev = {1, 1};
            	
            	if(number == 1)
            		result = 0;
            	else if(number > 1 && number < 4 )
            		result = prev[number - 2];
            	else
            	{
	            	for(int i = 3; i < number; i++)
	            	{
	            		int temp = prev[0];
	            		prev[0] = prev[1];
	            		prev[1] = temp;
	            		
	            		prev[1] = prev[0] + prev[1];
	            	}
	            	
	            	result = prev[1];
            	}
            	
            	labelResultValue.setText(Integer.toString(result));
                frame.pack();
            }
        });
        secondLine.add(calcButton);
        
        content.add(firstLine);
        content.add(secondLine);
        
        frame.getContentPane().add(content);

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
