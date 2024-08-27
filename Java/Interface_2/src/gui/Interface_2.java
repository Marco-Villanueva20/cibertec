package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseHijos.Circulo;
import claseHijos.Cuadrado; 
import clasePadre.Figura; 

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface_2 extends JFrame implements ActionListener {

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
					Interface_2 frame = new Interface_2();
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
	public Interface_2() {
		setTitle("Interface_2");
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
    	Circulo   cir = new Circulo(30,40,10.0);
		listado(cir);

		Cuadrado  cua = new Cuadrado(10,20,15.0);
		listado(cua);
    }
     
    void listado(Figura x) {
		imprimir(">>> Datos de " + x.getClass().getName());
		if (x instanceof Circulo) {
			imprimir("Ubicación del círculo  :  " + x.ubicacion());
			imprimir("Area del círculo       :  " + x.area());
			imprimir(((Circulo)x).dibujar());
			imprimir(((Circulo)x).rotar());			
		}
		else { 
			imprimir("Ubicación del cuadrado :  " + x.ubicacion());
			imprimir("Area del cuadrado      :  " + x.area());
			imprimir(((Cuadrado)x).dibujar());
		}
		imprimir("");
	}

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
 
 
}
