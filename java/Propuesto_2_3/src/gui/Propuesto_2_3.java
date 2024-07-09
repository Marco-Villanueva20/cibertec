package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Font;

public class Propuesto_2_3 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCelular;
	private JTextField txtCelular;	
	private JLabel lblSueldo;
	private JTextField txtSueldo;	
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto_2_3 frame = new Propuesto_2_3();
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
	public Propuesto_2_3() {
		setTitle("Propuesto_2_3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("c\u00F3digo");
		lblCodigo.setBounds(10, 15, 50, 23);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(57, 15, 70, 23);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("nombre");
		lblNombre.setBounds(10, 40, 50, 23);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(57, 40, 70, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCelular = new JLabel("celular");
		lblCelular.setBounds(150, 15, 50, 23);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setBounds(220, 15, 70, 23);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		lblSueldo = new JLabel("sueldo (S/)");
		lblSueldo.setBounds(150, 40, 60, 23);
		contentPane.add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(220, 40, 70, 23);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(330, 15, 94, 23);
		btnProcesar.addActionListener(this);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(330, 40, 94, 23);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 415, 380);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		try {
			int codigo = leerCodigo();
			String nombre = leerNombre();
			if (nombre.length() > 0)
				try {
					int celular = leerCelular();
					try {
						double sueldo = leerSueldo();
						/**
						Empleado e = new Empleado(codigo, nombre, celular, sueldo);
						*/
						
						limpieza();
					}
					catch (Exception e) {
						mensaje("Ingrese SUELDO correcto", txtSueldo);
					}
				}
				catch (Exception e) {
					mensaje("Ingrese CELULAR correcto", txtCelular);
				}
			else
				mensaje("Ingrese NOMBRE correcto", txtNombre);
		}
		catch (Exception e) {
			mensaje("Ingrese CÓDIGO correcto", txtCodigo);
		}	
	}
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		limpieza();
		txtS.setText("");		
	}
	//  Métodos tipo void (sin parámetros)
	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtCelular.setText("");
		txtSueldo.setText("");
		txtCodigo.requestFocus();
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	int leerCelular() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	double leerSueldo() {
		return Double.parseDouble(txtSueldo.getText().trim());
	}
	
}