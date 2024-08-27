package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseHijos.Gato;
import claseHijos.Perro;
import clasePadre.Mamifero;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface_1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_1 frame = new Interface_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface_1() {
		setTitle("Interface_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 110, 486, 293);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("P R O C E S A R");
		btnProcesar.addActionListener(this);
		btnProcesar.setFont(new Font("Arial", Font.BOLD, 16));
		btnProcesar.setBounds(28, 54, 486, 45);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		procesar();
	}
	
	//  Métodos tipo void (sin parámetros)
    void procesar() {
    	Gato   g = new Gato();
		listado(g);

		Perro  p = new Perro();
		listado(p);
    }
    
//  Listado es un método polimórfico
	void listado(Mamifero x) {
   		if (x instanceof Gato)
       		imprimir(">>> objeto GATO");
   		else
       		imprimir(">>> objeto PERRO");
		
		imprimir("mensaje     :  " + x.mensaje());
		imprimir("hacer ruido :  " + x.hacerRuido());
		
		if (x instanceof Gato) {
			imprimir("vacuna A    :  " + ((Gato) x).vacunaA);
			imprimir("cuidado     :  " + ((Gato) x).cuidado());			
		}
		else {
			imprimir("vacuna A    :  " + ((Perro) x).vacunaA);
			imprimir("vacuna B    :  " + ((Perro) x).vacunaB);
			imprimir("cuidado     :  " + ((Perro) x).cuidado());
			imprimir("peligro     :  " + ((Perro) x).peligro());
		}
		imprimir("");
	}

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
 
 
}
