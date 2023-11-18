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
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(218, 218, 218));
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
		title.setForeground(new Color(128, 0, 0));
		title.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 32));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(196,25,540,39);
		getContentPane().add(title);
		JScrollPane resultPane = new JScrollPane(); // scrollability when password is too big
		resultPane.setBounds(115, 356, 318, 60);
		resultPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(resultPane);
		
		// Text area where the password is displayed
		JTextArea resultArea = new JTextArea();
		resultPane.setViewportView(resultArea);
		resultArea.setForeground(new Color(255, 255, 255));
		resultArea.setBackground(new Color(128, 128, 128));
		resultArea.setEditable(false);
		resultArea.setFont(new Font("Eras Medium ITC",Font.BOLD,26));
		
		// select criteria heading
		JLabel subHeader = new JLabel("Criterias :");
		subHeader.setForeground(new Color(255, 128, 128));
		subHeader.setFont(new Font("Eras Demi ITC", Font.PLAIN, 24));
		subHeader.setHorizontalAlignment(SwingConstants.CENTER);
		subHeader.setBounds(610, 107, 290, 70);
		getContentPane().add(subHeader);
		
		// password length label
		JLabel length = new JLabel("Password Length");
		length.setForeground(new Color(128, 128, 128));
		length.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		length.setBounds(550,187,163,39);
		getContentPane().add(length);
		
		// password length input 
		JTextArea lengthInput = new JTextArea();
		lengthInput.setBackground(new Color(192, 192, 192));
		lengthInput.setFont(new Font("Eras Medium ITC",Font.PLAIN,20));
		lengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lengthInput.setBounds(739,187,192,39);
		getContentPane().add(lengthInput);
		
		
		// button lowercase
		JToggleButton lowerCaseButton = new JToggleButton("Lowercase");
		lowerCaseButton.setBounds(637,274,225,56);
		getContentPane().add(lowerCaseButton);
		
		// button uppercase
		JToggleButton upperCaseButton = new JToggleButton("Uppercase");
		upperCaseButton.setBounds(637,373,225,56);
		getContentPane().add(upperCaseButton);
		
		// number button
		JToggleButton numButton = new JToggleButton("Number");
		numButton.setBounds(637,462,225,56);
		getContentPane().add(numButton);
		
		// special symbol button
		JToggleButton symbolButton = new JToggleButton("Symbol");
		symbolButton.setBounds(637,546,225,56);
		getContentPane().add(symbolButton); 
		
		// generate button
		JButton generateButton = new JButton("Generate Password");
		generateButton.setBackground(new Color(0, 255, 0));
		generateButton.setBounds(373,664,182,41);
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
		
		JButton clearButton = new JButton("clear selection");
		clearButton.setBounds(827, 715, 126, 21);
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
		
		JLabel pwdLabel = new JLabel("Password");
		pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdLabel.setForeground(new Color(128, 128, 128));
		pwdLabel.setBounds(237, 306, 96, 39);
		contentPane.add(pwdLabel);
		
	}
}
