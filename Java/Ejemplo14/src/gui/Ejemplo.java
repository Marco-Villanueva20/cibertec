package gui;

import clase.Alumno;
import arreglo.ArregloAlumnos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblNota1;
	private JLabel lblNota2;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtNota1;	
	private JTextField txtNota2;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
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
	public Ejemplo() {
		setTitle("Ejemplo - Semana_12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 40, 28);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(54, 11, 40, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(120, 11, 50, 28);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 11, 60, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(255, 11, 40, 28);
		contentPane.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(295, 11, 40, 28);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		lblNota2 = new JLabel("Nota 2");
		lblNota2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNota2.setBounds(358, 11, 40, 28);
		contentPane.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(402, 11, 40, 28);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(450, 50, 155, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(450, 75, 155, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(450, 100, 155, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(450, 125, 155, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 432, 274);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("código");
		modelo.addColumn("nombre");
		modelo.addColumn("nota 1");
		modelo.addColumn("nota 2");
		modelo.addColumn("promedio");
		tblTabla.setModel(modelo);
		
		listar();		
	}
	
	//  Declaración global
	ArregloAlumnos aa = new ArregloAlumnos();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/**
		 * Adiciona un nuevo alumno validando que el código no se repita
		 */	
		try {
			int codigo = leerCodigo();
			if (aa.buscar(codigo) == null) {
				String nombre = leerNombre();
				if (nombre.length() > 0)
					try {
						int nota1 = leerNota1();
						try {
							int nota2 = leerNota2();
							Alumno nuevo = new Alumno(codigo, nombre, nota1, nota2);
							aa.adicionar(nuevo);
							listar();
							limpieza();
						}
						catch (Exception e) {
							error("ingrese NOTA 2", txtNota2);
						}
					}
					catch (Exception e) {
						error("ingrese NOTA 1", txtNota1);
					}
				else 
					error("ingrese NOMBRE", txtNombre);
			}
			else
				error("el CÓDIGO ya existe", txtCodigo);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodigo);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		/**
		 * Busca un código y si existe muestra los datos del alumno
		 */
		try {
			int codigo = leerCodigo();
			Alumno a = aa.buscar(codigo);
			if (a == null) {
				mensaje("el CÓDIGO no existe");
				limpieza();
			}
			else {
				txtNombre.setText(a.getNombre());
				txtNota1.setText("" + a.getNota1());
				txtNota2.setText("" + a.getNota2());
				txtCodigo.requestFocus();
			}
		}
		catch (Exception e) {
			mensaje("ingrese CÓDIGO");
			limpieza();
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		/**
		 * Modifica los datos de un alumnno
		 */	
		try {
			int codigo = leerCodigo();
			Alumno x = aa.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				if (nombre.length() > 0)
					try {
						int nota1 = leerNota1();
						try {
							int nota2 = leerNota2();
							x.setCodigo(codigo);
							x.setNombre(nombre);
							x.setNota1(nota1);
							x.setNota2(nota2);
							aa.actualizarArchivo();
							listar();
							limpieza();
						}
						catch (Exception e) {
							error("ingrese NOTA 2", txtNota2);
						}
					}
					catch (Exception e) {
						error("ingrese NOTA 1", txtNota1);
					}
				else 
					error("ingrese NOMBRE", txtNombre);
			}
			else
				error("el CÓDIGO no existe", txtCodigo);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodigo);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		/**
		 * Busca un código y si existe retira al alumno del arreglo
		 */	
		try {
			int codigo = leerCodigo();
			Alumno a = aa.buscar(codigo);
			if (a == null)
				mensaje("el CÓDIGO no existe");
			else {
				aa.eliminar(a);
				listar();
			}
			limpieza();
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodigo);
		}
	}
	//  Métodos tipo void (sin parámetros)
	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtCodigo.requestFocus();
	}	
   	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<aa.tamaño(); i++) {
			Object[] fila = { aa.obtener(i).getCodigo(),
					          aa.obtener(i).getNombre(),
					          aa.obtener(i).getNota1(),
					          aa.obtener(i).getNota2(),
					          aa.obtener(i).promedio() };
			modelo.addRow(fila);
		}
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
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
	int leerNota1() {
		return Integer.parseInt(txtNota1.getText().trim());
	}
	int leerNota2() {
		return Integer.parseInt(txtNota2.getText().trim());
	}
	
}