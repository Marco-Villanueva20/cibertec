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
import java.awt.event.ActionEvent;

public class FrmEjercicio2 extends JFrame implements ActionListener {

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
					FrmEjercicio2 frame = new FrmEjercicio2();
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
	public FrmEjercicio2() {
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
		//VARIABLES
		int cont = 0, suma = 0, num = 5;
		//LIMPIAR PANTALLA
		txtS.setText("");
		//BUCLE
		while(cont < 55) {//CANTIDAD DE REPETICIONES
			//MOSTRAR EL NUMERO DE LA SERIE 
			imprimir(""+num);   //5 /12
			//SUMAR EL NUMERO DE LA SERIE ACUMULADOR "SUMA"
			//5 + 12
			suma += num;
		//INCREMENTAR EL NUMERO DE LA SERIE
		//  5   +   7
			num += 7;  //12
			//INCREMENTAR EL CONTADOR DE UNO EN UNO
			cont ++;
			}
		imprimir("TOTAL  : "+suma);
		}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
