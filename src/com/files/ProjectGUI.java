package com.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProjectGUI extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);  // center the window

		setContentPane(contentPane);
		
		// to render the GUI components
		addComponents();
	}

	
	private void addComponents() {
		
		contentPane.setLayout(null);
		
		// Title of the panel
		JLabel title = new JLabel("Random Password Generator");
		title.setFont(new Font("Eras Bold ITC", Font.BOLD, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,24,540,39);
		getContentPane().add(title);
		
		// Text area where the password is displayed
		JTextArea resultArea = new JTextArea();
		resultArea.setEditable(false);
		resultArea.setFont(new Font("Eras Medium ITC",Font.BOLD,26));
		JScrollPane resultPane = new JScrollPane(resultArea); // scrollability when password is too big
		resultPane.setBounds(25, 97, 479, 60);
		resultPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(resultPane);
		
		// select criteria heading
		JLabel subHeader = new JLabel("Select your criterias");
		subHeader.setFont(new Font("Eras Demi ITC", Font.PLAIN, 24));
		subHeader.setHorizontalAlignment(SwingConstants.CENTER);
		subHeader.setBounds(10, 197, 516, 70);
		getContentPane().add(subHeader);
		
		// password length label
		JLabel length = new JLabel("Enter Password Length");
		length.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		length.setBounds(55,275,272,39);
		getContentPane().add(length);
		
		// password length input 
		JTextArea lengthInput = new JTextArea();
		lengthInput.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		lengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lengthInput.setBounds(280,275,192,39);
		add(lengthInput);
		
		
		// button lowercase
		JToggleButton lowerCaseButton = new JToggleButton("Lowercase");
		lowerCaseButton.setBounds(25,337,225,56);
		add(lowerCaseButton);
		
		// button uppercase
		JToggleButton upperCaseButton = new JToggleButton("Uppercase");
		upperCaseButton.setBounds(282,337,225,56);
		add(upperCaseButton);
		
		// number button
		JToggleButton numButton = new JToggleButton("Number");
		numButton.setBounds(25,408,225,56);
		add(numButton);
		
		// special symbol button
		JToggleButton symbolButton = new JToggleButton("Symbol");
		symbolButton.setBounds(282,408,225,56);
		add(symbolButton); 
		
		// generate button
		JButton generateButton = new JButton("Generate Password");
		generateButton.setBounds(155,487,182,41);
		add(generateButton);
		
	}
	
}
