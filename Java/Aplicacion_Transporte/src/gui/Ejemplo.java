package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseHijos.Auto;
import claseHijos.Avion;
import claseHijos.Bicicleta;
import claseHijos.Helicoptero;
import claseHijos.Moto;
import clasePadre.Transporte;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo extends JFrame implements ActionListener {

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
					Ejemplo frame = new Ejemplo();
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
	public Ejemplo() {
		setTitle("Ejemplo");
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
    	Auto  aut = new Auto(5);
		listado(aut);
		imprimir("");
		
		Bicicleta  bic = new Bicicleta(1);
		listado(bic);
		imprimir("");
		
		Moto  mot = new Moto(2);
		listado(mot);
		imprimir("");
		
		Helicoptero  hel = new Helicoptero(10);
		listado(hel);
		imprimir(hel.subir());
		imprimir(hel.bajar());
		imprimir("");
		
		Avion  avi = new Avion(300);
		listado(avi);
		imprimir(avi.subir());
		imprimir(avi.bajar());		
    }

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void listado(Transporte x) {
		imprimir(x.mostrarCapacidad());
		imprimir(x.avanzar());
		imprimir(x.detener());
		imprimir(x.retroceder());
	}
 
}
