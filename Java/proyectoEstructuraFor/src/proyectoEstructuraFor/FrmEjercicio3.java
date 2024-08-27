package proyectoEstructuraFor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEjercicio3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicio3 frame = new FrmEjercicio3();
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
	public FrmEjercicio3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 416, 273);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(173, 10, 85, 21);
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {

		//DECLARACION DE VARIABLE
		double suma=0;
		//Limpiar pantalla
		txtS.setText("");
		//generar el bucle
		for (int i = 0,num = 3, deno = 2; i < 50 ; i++,num+=4,deno += 3) {
			
			//mostrar valores de la serie
			imprimir(num+"/"+deno);
			//sumar los valores
			suma += num *1.0/deno;//1.0 se pone para cambiar num a double ya que num es int (entero)
		
		}
		imprimir("suma : " +suma);
		
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}

}
