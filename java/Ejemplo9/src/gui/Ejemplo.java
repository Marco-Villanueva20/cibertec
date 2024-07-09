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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	private JButton btnReportar;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JTextArea txtS;
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
		setTitle("Ejemplo - Semana_09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 40, 28);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(120, 11, 50, 28);
		contentPane.add(lblNombre);
		
		lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(255, 11, 40, 28);
		contentPane.add(lblNota1);	
		
		lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(362, 11, 40, 28);
		contentPane.add(lblNota2);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(54, 11, 40, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 11, 60, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(295, 11, 40, 28);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);

		txtNota2 = new JTextField();
		txtNota2.setBounds(402, 11, 40, 28);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(450, 50, 155, 23);
		contentPane.add(btnAdicionar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(450, 75, 155, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 50, 432, 200);
		contentPane.add(scrollPaneA);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPaneA.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("código");
		modelo.addColumn("nombre");
		modelo.addColumn("nota 1");
		modelo.addColumn("nota 2");
		modelo.addColumn("promedio");
		tblTabla.setModel(modelo);

		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 250, 432, 100);
		contentPane.add(scrollPaneB);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPaneB.setViewportView(txtS);
		
		listar();		
	}
	
	//  Declaración global
	ArregloAlumnos aa = new ArregloAlumnos();

	/** 
	 *           .-------.
     *  .-------.| 456   |
     *  |  123  || Juan  |.-------.
     *  |  Ana  || 15    || 789   |.-------.
     *  |  19   || 14    || Pedro || 302   |
     *  |  15   |'-------'| 17    || David |
     *  '-------'   |     | 19    || 13    |
     *      |        \    '-------'| 18    |
     *      \         |      /     '-------'
     *       \        |     /          /
     *        \ _     |    /    _ _ _ /
     *            \   |   |   / 
     *          .---.---.---.---.---.---.---.---.---.---.
     *     ==>  | @ | @ | @ | @ |   |   |   |   |   |   |
     *          '---'---'---'---'---'---'---'---'---'---'
     *            0   1   2   3   4   5   6   7   8   9
     * 							  ^                 
	 */
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/**
		 * Envía al método adicionar un nuevo alumno creado
		 */	
		int codigo = leerCodigo();
		String nombre = leerNombre();
		int nota1 = leerNota1();
		int nota2 = leerNota2();
		Alumno nuevo = new Alumno(codigo, nombre, nota1, nota2);
		aa.adicionar(nuevo);
		listar();
		limpieza();
	}
	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		/**
		 * Muestra la cantidad de alumnos, promedio general
		 * de todos los alumnos y nombre del alumno con el
		 * mayor promedio
		 */
		txtS.setText("");
		imprimir("cantidad de alumnos :  " + aa.tamaño());
		imprimir("promedio general :  " + aa.promedioGeneral());
		imprimir("mayor promedio :  " + aa.promedioMayor());
  	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
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
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
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