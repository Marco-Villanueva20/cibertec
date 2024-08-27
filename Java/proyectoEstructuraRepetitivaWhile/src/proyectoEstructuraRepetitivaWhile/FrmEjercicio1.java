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

public class FrmEjercicio1 extends JFrame implements ActionListener {

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
					FrmEjercicio1 frame = new FrmEjercicio1();
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
	public FrmEjercicio1() {
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
		int cont = 0;
		//LIMPIAR PANTALLA
		txtS.setText("");
		
		//INICIAMOS BUCLE
		while(cont < 3){
			//Mostrar en pantalla "java"
			imprimir ("java");
			//INCREMEMENTAR EL CONTADOR DE 1 EN 1
			cont ++;
		}
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
