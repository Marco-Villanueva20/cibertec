package semana1;
import clases.Alumno;

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

public class GUIAlumno extends JFrame implements ActionListener {

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
					GUIAlumno frame = new GUIAlumno();
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
	public GUIAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(10, 23, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 416, 179);
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
		// CREADO OBJETO a DEL TIPO ALUMNO
		Alumno a = new Alumno();
		// ASIGNAR DATOS
		a.codigo = 2324;
		a.nombre = "Marco";
		a.nota1 = 12;
		a.nota2 = 16;
		// MOSTRSR INFORMACION
		txtS.setText("CODIGO: " + a.codigo + "\n");
		txtS.append("Nombre: " + a.nombre + "\n");
		txtS.append("Nota 1: " + a.nota1 + "\n");
		txtS.append("Nota 2: " + a.nota2 + "\n");
		txtS.append("Promedio : " + a.promedio() + "\n");
	}
}
