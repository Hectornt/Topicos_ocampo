package com.Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class miPila {
    Stack<String> varPila = new Stack<String>();
    String strExpresion = "";
    
    int intError = 0;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miPila window = new miPila();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public miPila() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblExpresion = new JLabel("Escriba la expresion");
		lblExpresion.setBounds(28, 30, 152, 14);
		frame.getContentPane().add(lblExpresion);
		
		JTextArea txtExpresion = new JTextArea();
		txtExpresion.setBounds(28, 68, 225, 28);
		frame.getContentPane().add(txtExpresion);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				strExpresion = txtExpresion.getText();
				char chrCaracter = ' ';
				for (int x = 0;x<strExpresion.length();x++) 
				{
					chrCaracter = strExpresion.charAt(x);
					if(chrCaracter  == '(') 
					{
						varPila.push("parentesisAbre");
					}
					if(chrCaracter == ')')
					{
						if(varPila.empty())
						{
							intError = 1;
							break;
						}
						else 
						{
							varPila.pop();
						}
					}
				}
				if(varPila.empty()&& intError == 0) 
				{
					JOptionPane.showMessageDialog(null, "La expresion es correcta :D!!");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "La expresion es incorrecta D:");
				}
				
			}
		});
		btnEvaluar.setBounds(28, 202, 89, 23);
		frame.getContentPane().add(btnEvaluar);
	}
}
