package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import claseHijos.Circulo;
import claseHijos.Cuadrado;
import claseHijos.Rectangulo;
import clasePadre.Figura;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Polimorfismo_2 extends JFrame implements ActionListener {

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
					Polimorfismo_2 frame = new Polimorfismo_2();
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
	public Polimorfismo_2() {
		setTitle("Polimorfismo_2");
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
    	Figura[]  f = new Figura[3];

		f[0] = new Circulo(30, 40, 10.0);
        f[1] = new Cuadrado(10, 20, 15.0);
        f[2] = new Rectangulo(60, 70, 18.0, 17.0);

		listado(f);

        imprimir("El área mayor es :  " + mayorArea(f));
    }

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void listado(Figura[] x) {
		imprimir("P O L I M O R F I S M O");
		for (int i=0; i<x.length; i++) {
			imprimir(">>> Datos de " + x[i].getClass().getName());
			imprimir(x[i].datosCompletos());
		}
	}
	double mayorArea(Figura[] x) {
        double  areaMayor = x[0].area();
        for (int i=1; i<x.length; i++) {
            if (areaMayor < x[i].area()) {
                areaMayor = x[i].area();
            }
        }
        return areaMayor;
    }

}
