package Quizz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quizz {

	private JFrame frame;
/*	private JRadioButton radRespuesta1;
	private JRadioButton radRespuesta2;
	private JRadioButton radRespuesta3;*/
	public String [] strPreguntas = {"¿Cuándo inició la segunda guerra mundial?","¿En qué ciudad se lanzó primero la bomba atómica?","¿Con cuántas vidas terminó el holocausto?","¿Cómo comenzó la Segunda Guerra Mundial?","¿En qué consistía la \"guerra relámpago\" o blitzkrieg \nllevada a cabo por los alemanes?"};
	public String [] strRespuesta1 = {"1 de agosto de 1941","Hiroshima","Entre 2.000.000 y 3.000.000 de personas","Comenzó con la invasión de Polonia por parte de Alemania", "Consistía en la acción coordinada de unidades de artillería, blindadas, aviación y comunicaciones para debilitar \nrápidamente las defensas del enemigo"};
	public String [] strRespuesta2 = {"1 de septiembre de 1939","Nagasaki","Entre 5.900.000 y 7.100.000 personas","Comenzó con el pacto expansionista firmado por Japón, Italia y Alemania","Consistía en usar armas químicas junto con bombardeos continuos"};
	public String [] strRespuesta3 = {" 28 de julio de 1914","Tokyo-3","Entre 15.00.000 y 18.000.000 personas","comenzó con la invasión de la URSS por parte de Alemania ","Consistía en atacar los objetivos clave siempre coincidiendo con tormentas y mal tiempo para mermar más fácilmente las defensas del enemigo"};
    public String [] strRespuestasDadas = new String [5];
	public String [] strRespuestasCorrectas = {"1 de septiembre de 1939","Hiroshima","Entre 5.900.000 y 7.100.000 personas", "Comenzó con la invasión de Polonia por parte de Alemania", "Consistía en la acción coordinada de unidades de artillería, blindadas, aviación y comunicaciones para debilitar rápidamente las defensas del enemigo" };
    int i = 0;
	int intPuntaje = 0;
	boolean [] blnRevisado = new boolean[5];

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quizz window = new Quizz();
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
	public Quizz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumeracion = new JLabel("Pregunta 1");
		lblNumeracion.setBounds(10, 11, 109, 14);
		frame.getContentPane().add(lblNumeracion);
		
		JLabel lblPregunta = new JLabel("\u00BFCu\u00E1ndo inici\u00F3 la segunda guerra mundial?");
		lblPregunta.setBounds(10, 36, 549, 34);
		frame.getContentPane().add(lblPregunta);
		
		JRadioButton radRespuesta1 = new JRadioButton("1 agosto de 1942");
		radRespuesta1.setBounds(10, 77, 549, 74);
		frame.getContentPane().add(radRespuesta1);
		
		JRadioButton radRespuesta2 = new JRadioButton("1 de septiembre de 1939");
		radRespuesta2.setBounds(10, 154, 535, 67);
		frame.getContentPane().add(radRespuesta2);
		
		JRadioButton radRespuesta3 = new JRadioButton("28 de julio de 1914");
		radRespuesta3.setBounds(10, 224, 549, 68);
		frame.getContentPane().add(radRespuesta3);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(strPreguntas[i]==strPreguntas[0]) 
				{
					JOptionPane.showMessageDialog(null,"No se puede retroceder mas");
				}
				else 
				{
					i--; 
					lblNumeracion.setText("Pregunta "+(i+1));
					lblPregunta.setText(strPreguntas[i]);
					radRespuesta1.setText(strRespuesta1[i]);
					radRespuesta2.setText(strRespuesta2[i]);
					radRespuesta3.setText(strRespuesta3[i]);
					
				}
			}
		});
		btnAnterior.setBounds(30, 311, 89, 23);
		frame.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{

				if(radRespuesta1.isSelected()==true) 
				{
					strRespuestasDadas[i] = strRespuesta1[i];
					
				}
				else 
				{
					if(radRespuesta2.isSelected() == true) 
					{
						strRespuestasDadas[i] = strRespuesta2[i];
					}
					else
					{
						if(radRespuesta3.isSelected() == true) 
						{
							strRespuestasDadas[i] = strRespuesta3[i];
						}
					}
				}
					
				
				if(strPreguntas[i]==strPreguntas[4]) 
				{
					JOptionPane.showMessageDialog(null,"No se puede avanzar mas");
				}
				else 
				{
					
					
					i++;
					lblNumeracion.setText("Pregunta "+(i+1));
					lblPregunta.setText(strPreguntas[i]);
					radRespuesta1.setText(strRespuesta1[i]);
					radRespuesta2.setText(strRespuesta2[i]);
					radRespuesta3.setText(strRespuesta3[i]);
					
					
					
				}	
			}
		});
		btnSiguiente.setBounds(131, 311, 89, 23);
		frame.getContentPane().add(btnSiguiente);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{

				if(radRespuesta1.isSelected()==true) 
				{
					strRespuestasDadas[i] = strRespuesta1[i];
					
				}
				else 
				{
					if(radRespuesta2.isSelected() == true) 
					{
						strRespuestasDadas[i] = strRespuesta2[i];
					}
					else
					{
						if(radRespuesta3.isSelected() == true) 
						{
							strRespuestasDadas[i] = strRespuesta3[i];
						}
					}
				}
				for(int j = 0;j<5;j++ ) 
				{
					if(strRespuestasDadas[j]== strRespuestasCorrectas[j]) 
					{
						intPuntaje++;
					}
				}
				JOptionPane.showMessageDialog(null,"Su puntuacion es de: "+ intPuntaje);
				
				intPuntaje = 0;
			}
		});
		btnEvaluar.setBounds(342, 311, 89, 23);
		frame.getContentPane().add(btnEvaluar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(452, 311, 89, 23);
		frame.getContentPane().add(btnSalir);
		ButtonGroup radRespuestas = new ButtonGroup();
		radRespuestas.add(radRespuesta2);
		radRespuestas.add(radRespuesta1);
		radRespuestas.add(radRespuesta3);
	}
}
