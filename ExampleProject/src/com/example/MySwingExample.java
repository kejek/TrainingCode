package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class MySwingExample extends JFrame implements ActionListener {
	private static JPanel myPanel;
	private static JButton option1;
	private static JButton option2;
	private static JButton option3;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel label3;

	public MySwingExample() {
		//initialize components and panel
		myPanel = new JPanel();
		
		option1 = new JButton("1");
		option1.addActionListener(this);
		label1 = new JLabel();
		label1.setText("Option 1");
		
		option2 = new JButton("2");
		option2.addActionListener(this);
		label2 = new JLabel();
		label2.setText("Option 2");
		
		option3 = new JButton("3");
		option3.addActionListener(this);
		label3 = new JLabel();
		label3.setText("Option 3");
		
		
		
		
		myPanel.add(option1);
		myPanel.add(option2);
		myPanel.add(option3);
		
		myPanel.add(label1);
		myPanel.add(label2);
		myPanel.add(label3);

		this.add(myPanel);
	}

	public static void main(String[] args) {
		panelSetup();
	}

	private static void panelSetup() {
		MySwingExample example = new MySwingExample();
		
		
		example.setTitle("My Swing Example");
		example.setSize(300, 200);
		example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		example.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == option1) {
			String userText = JOptionPane.showInputDialog(this,
					"Enter a message:");
			label1.setText(userText);
		}
	}
}
