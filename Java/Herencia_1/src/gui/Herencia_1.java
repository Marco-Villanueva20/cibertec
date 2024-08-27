package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseHijos.Hijo;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Herencia_1 extends JFrame implements ActionListener {

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
					Herencia_1 frame = new Herencia_1();
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
	public Herencia_1() {
		setTitle("Herencia_1");
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
    	Hijo  h = new Hijo(1,3,5,7);
    	listado(h);
    }

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void listado(Hijo x) {
		imprimir(">>>  H I J O");		
		imprimir("v1 :  " + x.v1);
		imprimir("v2 :  " + x.getv2());
		imprimir("v3 :  " + x.getv3());
		imprimir("v4 :  " + x.v4);
		imprimir("suma :  " + x.suma());
		imprimir("producto :  " + x.producto());
		imprimir("");
	}
}
