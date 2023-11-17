package com.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

public class ProjectGUI extends JFrame {

	private JPanel contentPane;
	private RandomPassword rp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectGUI frame = new ProjectGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectGUI() {
		
		super("Random Password Generator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(38, 38, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);  // center the window

		setContentPane(contentPane);
		
		rp = new RandomPassword();
		
		// to render the GUI components
		addComponents();
	}

	
	private void addComponents() {
		
		contentPane.setLayout(null);
		
		// Title of the panel
		JLabel title = new JLabel("Random Password Generator");
		title.setForeground(new Color(196, 225, 255));
		title.setFont(new Font("Eras Bold ITC", Font.BOLD, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,24,540,39);
		getContentPane().add(title);
		
		// Text area where the password is displayed
		JTextArea resultArea = new JTextArea();
		resultArea.setForeground(new Color(255, 255, 255));
		resultArea.setBackground(new Color(128, 128, 128));
		resultArea.setEditable(false);
		resultArea.setFont(new Font("Eras Medium ITC",Font.BOLD,26));
		JScrollPane resultPane = new JScrollPane(resultArea); // scrollability when password is too big
		resultPane.setBounds(25, 97, 479, 60);
		resultPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(resultPane);
		
		// select criteria heading
		JLabel subHeader = new JLabel("Select your criterias");
		subHeader.setForeground(new Color(255, 255, 193));
		subHeader.setFont(new Font("Eras Demi ITC", Font.PLAIN, 24));
		subHeader.setHorizontalAlignment(SwingConstants.CENTER);
		subHeader.setBounds(10, 197, 516, 70);
		getContentPane().add(subHeader);
		
		// password length label
		JLabel length = new JLabel("Enter Password Length");
		length.setForeground(new Color(192, 192, 192));
		length.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		length.setBounds(55,275,272,39);
		getContentPane().add(length);
		
		// password length input 
		JTextArea lengthInput = new JTextArea();
		lengthInput.setBackground(new Color(192, 192, 192));
		lengthInput.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		lengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lengthInput.setBounds(280,275,192,39);
		getContentPane().add(lengthInput);
		
		
		// button lowercase
		JToggleButton lowerCaseButton = new JToggleButton("Lowercase");
		lowerCaseButton.setBackground(new Color(255, 255, 193));
		lowerCaseButton.setBounds(25,337,225,56);
		getContentPane().add(lowerCaseButton);
		
		// button uppercase
		JToggleButton upperCaseButton = new JToggleButton("Uppercase");
		upperCaseButton.setBackground(new Color(255, 255, 193));
		upperCaseButton.setBounds(282,337,225,56);
		getContentPane().add(upperCaseButton);
		
		// number button
		JToggleButton numButton = new JToggleButton("Number");
		numButton.setBackground(new Color(255, 255, 193));
		numButton.setBounds(25,408,225,56);
		getContentPane().add(numButton);
		
		// special symbol button
		JToggleButton symbolButton = new JToggleButton("Symbol");
		symbolButton.setBackground(new Color(255, 255, 193));
		symbolButton.setBounds(282,408,225,56);
		getContentPane().add(symbolButton); 
		
		// generate button
		JButton generateButton = new JButton("Generate Password");
		generateButton.setBackground(new Color(194, 255, 134));
		generateButton.setBounds(155,487,182,41);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lengthInput.getText().length() <= 0) 
					return ;
				boolean toggled = lowerCaseButton.isSelected() || upperCaseButton.isSelected() || numButton.isSelected() || symbolButton.isSelected();
				if(toggled) {
					String result = rp.generate(Integer.parseInt(lengthInput.getText()), upperCaseButton.isSelected(), lowerCaseButton.isSelected(), numButton.isSelected(), symbolButton.isSelected());
					resultArea.setText(result);
				}
				
			}
		});
		getContentPane().add(generateButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBackground(new Color(255, 128, 128));
		clearButton.setBounds(441, 532, 85, 21);
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resultArea.setText("");
				lowerCaseButton.setSelected(false);
				upperCaseButton.setSelected(false);
				numButton.setSelected(false);
				symbolButton.setSelected(false);
				lengthInput.setText("");
			
			}
		});
		contentPane.add(clearButton);
		
	}
}
