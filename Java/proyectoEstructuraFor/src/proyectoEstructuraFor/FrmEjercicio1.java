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

public class FrmEjercicio1 extends JFrame implements ActionListener {

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
		setTitle("Ejercicio1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 416, 318);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(173, 12, 85, 21);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		double sProm = 0;
		int sGenerado,cantEmp1 =0, cantEmp2 = 0, cantEmp3 = 0, suma = 0;
		//Limpiar pantalla
		txtS.setText("");
		//generar el bucle
		for (int i = 0; i < 100 ; i++) {
			//generar sueldos aleatorios
			sGenerado = valoresAleatorios(850,3150);
			//mostrar sueldos generados
			imprimir("SUELDO GENERADO : " +sGenerado);
			//ACUMULAR LOS SUELDO PROMEDIO
			suma += sGenerado;
			//La cantidad de empleados que ganan menos de S/. 1750
			if(sGenerado < 1750)
				cantEmp1 ++;
			//La cantidad de empleados que ganan S/. 1750
			else if(sGenerado == 1750)
				cantEmp2 ++;
			//La cantidad de empleados que ganan más de S/. 1750
			else
				cantEmp3 ++;
		}
		//calcular promedio
		sProm = suma /100;
		imprimir("");
		imprimir("Sueldo Promedio : S/. "+sProm);
		imprimir("La cantidad de empleados que ganan menos de S/. 1750 : "+cantEmp1);
		imprimir("La cantidad de empleados que ganan S/. 1750 : "+cantEmp2);
		imprimir("La cantidad de empleados que ganan mas de S/. 1750 : "+cantEmp3);
		
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}

	private int valoresAleatorios(int min, int max) {
		return (int) ((max - min + 1) * Math.random() + min);
	}
}
