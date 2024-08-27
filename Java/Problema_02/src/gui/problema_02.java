package gui;
import examen.Habitacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class problema_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					problema_02 frame = new problema_02();
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
	public problema_02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(170, 40, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 438, 474);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
	Habitacion h1 = new Habitacion(40,35,20);
	listadoHabitacion(h1);
	
	Habitacion h2 = new Habitacion(4,55.5);
	listadoHabitacion(h2);
	
	Habitacion h3 = new Habitacion();
	listadoHabitacion(h3);
	
	listadoGeneral();
	}

	//metodos de tipo void 
	void imprimir(String s) {
		txtS.append(s+"\n");
	}
	void listadoHabitacion(Habitacion h) {
		imprimir("Número de habitación  : "+h.getNumeroHabitacion());
		imprimir("Precio por día               : S/ "+h.getPrecioPorDia());
		imprimir("Días de hospedaje       : "+h.getDiasDeHospedaje()+" días");
		imprimir("Subtotal                        : S/. "+h.subTotal());
		imprimir("Descuento                    : S/. "+h.descuento());
		imprimir("Total a Pagar                : S/. "+h.totalPagar());
		imprimir("");
	}
	void listadoGeneral() {
		imprimir("Cantidad de Objetos creados  : "+Habitacion.getCantidad());
		imprimir("Total a Pagar Acumulado        : S/. "+Habitacion.getTotalPagar());
	}
}
