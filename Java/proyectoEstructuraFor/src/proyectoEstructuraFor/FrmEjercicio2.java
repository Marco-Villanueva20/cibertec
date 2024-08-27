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

public class FrmEjercicio2 extends JFrame implements ActionListener {

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
		double nProm = 0;
		int nGeneradas,alumnApro =0, alumnDesa = 0, suma = 0;
		//Limpiar pantalla
		txtS.setText("");
		//generar el bucle
		for (int i = 0; i < 45 ; i++) {
			//generar la nota aleatorios
			nGeneradas = valoresAleatorios(0,20);
			//mostrar Notas generados
			imprimir("Notas generadas : " +nGeneradas);
			//ACUMULAR LOS SUELDO PROMEDIO
			suma += nGeneradas;
			//cantidad de estudiantes desaprobadas
			if(nGeneradas < 13)
				alumnDesa ++;
			//cantidad de estudiantes aprobados
			else 
				alumnApro ++;
		}
		//calcular promedio
		nProm = suma /45;
		imprimir("");
		imprimir("Notas Promedio : S/. "+nProm);
		imprimir("La cantidad de alumnos aprobados : "+alumnApro);
		imprimir("La cantidad de alumnos desaprobados : "+alumnDesa);
		
		
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}

	private int valoresAleatorios(int min, int max) {
		return (int) ((max - min + 1) * Math.random() + min);
	}
}
