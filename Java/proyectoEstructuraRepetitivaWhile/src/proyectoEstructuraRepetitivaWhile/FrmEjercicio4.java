package proyectoEstructuraRepetitivaWhile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmEjercicio4 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicio4 frame = new FrmEjercicio4();
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
	public FrmEjercicio4() {
		setTitle("EJERCICIO 1 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(176, 30, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 416, 150);
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
		//DECLARAMOS VARIABLE PARA CONTROLAR LA CANTIDAD DE INTERACCIONES
		int num1 =7, num2 = 12 ,num3 = 18 ;
		//LIMPIAR PANTALLA
		txtS.setText("");
		//INICIAMOS BUCLE
		while(num1 >= 1) {//CANTIDAD DE REPETICIONES
			//IMPRIMIR LOS VALORES DE LAS SERIE 
			imprimir( num1+"\t"+num2+"\t"+num3);
		//INCREMENTAR LOS VALORES DE LA SERIE
			num1 --;
			num2 -= 2;
			num3 -= 3;
			}
	}
	

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
