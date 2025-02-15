package guis;

import clases.Medicina;
import arreglos.ArregloMedicinas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgMedicina extends JDialog implements ActionListener, KeyListener, MouseListener {

	private JLabel lblImgMedicina;
	private JLabel lblCodigoMedicina;
	private JLabel lblNombre;
	private JLabel lblLaboratorio;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JTextField txtCodigoMedicina;
	private JTextField txtNombre;
	private JTextField txtLaboratorio;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblMedicina;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMedicina dialog = new DlgMedicina();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgMedicina() {
		setResizable(false);
		setTitle("Mantenimiento | Medicina");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);

		lblImgMedicina = new JLabel();
		lblImgMedicina.setIcon(new ImageIcon("imagenes/dlgMedicina.png"));
		lblImgMedicina.setBounds(400, 10, 88, 88);
		getContentPane().add(lblImgMedicina);
		
		lblCodigoMedicina = new JLabel("C\u00F3digo");
		lblCodigoMedicina.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigoMedicina);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 40, 70, 23);
		getContentPane().add(lblNombre);
	
		lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setBounds(10, 70, 70, 23);
		getContentPane().add(lblLaboratorio);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 100, 70, 23);
		getContentPane().add(lblStock);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 130, 70, 23);
		getContentPane().add(lblPrecio);
		
		txtCodigoMedicina = new JTextField();
		txtCodigoMedicina.setBounds(90, 10, 85, 23);
		getContentPane().add(txtCodigoMedicina);
		txtCodigoMedicina.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 40, 200, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtLaboratorio = new JTextField();
		txtLaboratorio.setBounds(90, 70, 200, 23);
		getContentPane().add(txtLaboratorio);
		txtLaboratorio.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(90, 100, 85, 23);
		getContentPane().add(txtStock);
		txtStock.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(90, 130, 85, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.setBounds(190, 10, 100, 23);
		getContentPane().add(btnAceptar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.setBounds(535, 10, 150, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(535, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(535, 60, 150, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 675, 195);
		getContentPane().add(scrollPane);

		tblMedicina = new JTable();
		tblMedicina.addKeyListener(this);
		tblMedicina.addMouseListener(this);
		tblMedicina.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMedicina);

		modelo = new DefaultTableModel();
		modelo.addColumn("C�DIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("LABORATORIO");
		modelo.addColumn("STOCK");
		modelo.addColumn("PRECIO UNITARIO");
	
		tblMedicina.setModel(modelo);
		
		txtCodigoMedicina.setEditable(false);
		
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	
	//  Declaraci�n global
	ArregloMedicinas am = new ArregloMedicinas();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtNombre.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (am.tama�o() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen pacientes");	
		}
		else {
			editarFila();
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			txtNombre.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (am.tama�o() == 0)
			mensaje("No existen pacientes");
		else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("� Desea eliminar el registro ?");
			if (ok == 0) {
				am.eliminar(am.buscar(leerCodigoMedicina()));
				am.grabarMedicinas();
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int codigoMedicina = leerCodigoMedicina();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String laboratorio = leerLaboratorio();
			if (laboratorio.length() > 0)
				try {
					int stock = leerStock();
					try {
						double precioUnitario = leerPrecio();
						if (btnAdicionar.isEnabled() == false) {
							Medicina nueva = new Medicina(codigoMedicina, nombre, laboratorio, stock, precioUnitario);
							am.adicionar(nueva);
							am.grabarMedicinas();
							btnAdicionar.setEnabled(true);
						}
						if (btnModificar.isEnabled() == false) {
							Medicina m = am.buscar(codigoMedicina);
							m.setNombre(nombre);
							m.setLaboratorio(laboratorio);
							m.setStock(stock);
							m.setPrecioUnitario(precioUnitario);
							am.grabarMedicinas();
							btnModificar.setEnabled(true);
						}
						listar();
						habilitarEntradas(false);
					}
					catch (Exception e) {
						error("Ingrese PRECIO correcto", txtPrecio);
					}
				}
				catch (Exception e) {
					error("Ingrese STOCK correcto", txtStock);
				}
			else
				error("ingrese LABORATORIO correcto", txtLaboratorio);
		}
		else
			error("ingrese NOMBRE correcto", txtNombre);		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}
	public void keyTyped(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblMedicina) {
			mouseClickedTblMedicina(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseEnteredBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(arg0);
		}
		if (arg0.getSource() == tblMedicina) {
			mouseEnteredTblMedicina(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblMedicina(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void mouseEnteredTblMedicina(MouseEvent arg0) {
		tblMedicina.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//  M�todos tipo void (sin par�metros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblMedicina.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  // codigoMedicina
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));  // laboratorio
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  // stock
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20));  // precioUnitario
	}
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblMedicina.getSelectedRow();
		if (modelo.getRowCount() == am.tama�o() - 1)
			posFila = am.tama�o() - 1;
		if (posFila == am.tama�o())
			posFila --;
		modelo.setRowCount(0);
		Medicina m;
		for (int i=0; i<am.tama�o(); i++) {
			m = am.obtener(i);
			Object[] fila = { m.getCodigoMedicina(),
					          m.getNombre(),
					          m.getLaboratorio(),
					          m.getStock(),
					          m.getPrecioUnitario() };
			modelo.addRow(fila);
		}
		if (am.tama�o() > 0)
			tblMedicina.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void editarFila() {
		if (am.tama�o() == 0)
			limpieza();
		else {
			Medicina m = am.obtener(tblMedicina.getSelectedRow());
			txtCodigoMedicina.setText("" + m.getCodigoMedicina());
			txtNombre.setText(m.getNombre());
			txtLaboratorio.setText(m.getLaboratorio());
			txtStock.setText("" + m.getStock());
			txtPrecio.setText("" +m.getPrecioUnitario());
		}
	}
	void limpieza() {
		txtCodigoMedicina.setText("" + am.codigoCorrelativo());
		txtNombre.setText("");
		txtLaboratorio.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtNombre.setEditable(sino);
		txtLaboratorio.setEditable(sino);
		txtStock.setEditable(sino);
		txtPrecio.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	//  M�todos que retornan valor (sin par�metros)
	int leerCodigoMedicina() {
		return Integer.parseInt(txtCodigoMedicina.getText().trim());
	}
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerLaboratorio() {
		return txtLaboratorio.getText().trim();
	}
	int leerStock() {
		return Integer.parseInt(txtStock.getText().trim());
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	//  M�todos que retornan valor (con par�metros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
}