package gui;
import examen.Auto;
import examen.Habitacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class problema_02_ extends JFrame implements ActionListener {

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
					problema_02_ frame = new problema_02_();
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
	public problema_02_() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(172, 29, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 438, 385);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Auto a1 = new Auto("VG3-654",10,20);
		listadoAuto(a1);
		
		Auto a2 = new Auto("BHI-891",15);
		listadoAuto(a2);
		
		Auto a3 = new Auto();
		listadoAuto(a3);
		
		listadoGeneral();
	}
	//metodos de tipo void 
		void imprimir(String s) {
			txtS.append(s+"\n");
		}
		void listadoAuto(Auto a) {
			imprimir("Placa     	         : "+a.getPlaca());
			imprimir("Precio por kilómetro   : S/. "+a.getPrecioPorKilometro());
			imprimir("kilómetros recorridos : "+a.getKilometrosRecorridos()+" km");
			imprimir("Costo de Consumo    : S/."+a.costoConsumo());
			imprimir("Descuento                  : S/. "+a.descuento());
			imprimir("Total a Pagar              : S/. "+a.totalPagar());
			imprimir("");
		}
		void listadoGeneral() {
			imprimir("Cantidad de Objetos creados    : "+Auto.getCantidad());
			imprimir("Costo de Consumo Acumulado : S/. "+Auto.getCostoConsumo());
		}
}
