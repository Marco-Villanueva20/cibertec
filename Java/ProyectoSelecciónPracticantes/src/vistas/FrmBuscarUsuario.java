package vistas;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.ListaUsuarios;
import mantenimiento.GestionAreasDAO;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class FrmBuscarUsuario extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JTable tbUsuarios;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	// Evaluado
	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();

	GestionAreasDAO gAreas = new GestionAreasDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField txtBuscarxNombre;
	private JLabel lblApellido;
	private JTextField txtBuscarxApellido;
	private JLabel lblArea;
	private JTextField txtBuscarxArea;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscarUsuario frame = new FrmBuscarUsuario();
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
	public FrmBuscarUsuario() {
		setTitle("Seleccione en la tabla al destinatario y agrégelo");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		// setIconifiable(true);
		// setMaximizable(true);
		// setClosable(true);
		setBounds(100, 100, 716, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(45, 511, 190, 43);
		contentPane.add(btnAgregar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 156, 672, 345);
		contentPane.add(scrollPane);
		
				tbUsuarios = new JTable();
				scrollPane.setViewportView(tbUsuarios);
				tbUsuarios.addMouseListener(this);
				tbUsuarios.setFillsViewportHeight(true);
				tbUsuarios.setModel(model);

		model.addColumn("Código");
		model.addColumn("Nombre/s");
		model.addColumn("Apellido/s");
		model.addColumn("Cargo");
		model.addColumn("Area");

		panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Filtrar por Nombre y/o Apellido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setForeground(Color.GRAY);
		panel.setBounds(20, 10, 672, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(25, 34, 113, 24);
		panel.add(lblNombre);
		
		txtBuscarxNombre = new JTextField();
		txtBuscarxNombre.addKeyListener(this);
		txtBuscarxNombre.setColumns(10);
		txtBuscarxNombre.setBounds(161, 36, 286, 24);
		panel.add(txtBuscarxNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(25, 68, 113, 24);
		panel.add(lblApellido);
		
		txtBuscarxApellido = new JTextField();
		txtBuscarxApellido.addKeyListener(this);
		txtBuscarxApellido.setColumns(10);
		txtBuscarxApellido.setBounds(161, 70, 286, 24);
		panel.add(txtBuscarxApellido);
		
		lblArea = new JLabel("Área:");
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArea.setBounds(25, 102, 113, 24);
		panel.add(lblArea);
		
		txtBuscarxArea = new JTextField();
		txtBuscarxArea.addKeyListener(this);
		txtBuscarxArea.setColumns(10);
		txtBuscarxArea.setBounds(161, 104, 286, 24);
		panel.add(txtBuscarxArea);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(423, 511, 190, 43);
		contentPane.add(btnCancelar);

		cargarDataUsuario();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarxNombre) {
			keyReleasedTxtBuscarxNombre(e);
		}
		if (e.getSource() == txtBuscarxArea) {
			keyReleasedTxtBuscarxArea(e);
		}
		if (e.getSource() == txtBuscarxApellido) {
			keyReleasedTxtBuscarxApellido(e);
		}
	}

	public void keyTyped(KeyEvent e1) {
		if (e1.getSource() == txtBuscarxNombre) {
			keyTypedTxtBuscarxNombre(e1);
		}
		if (e1.getSource() == txtBuscarxApellido) {
			keyTypedTxtBuscarxApellido(e1);
		}
		if (e1.getSource() == txtBuscarxArea) {
			keyTypedTxtBuscarxArea(e1);
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbUsuarios) {
			mouseClickedTbMemo(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	protected void keyTypedTxtBuscarxArea(KeyEvent e1) {
		bloquearNumeros(e1);
	}

	protected void keyTypedTxtBuscarxApellido(KeyEvent e1) {
		bloquearNumeros(e1);
	}

	protected void keyTypedTxtBuscarxNombre(KeyEvent e1) {
		bloquearNumeros(e1);
	}
	
	protected void keyReleasedTxtBuscarxApellido(KeyEvent e) {
		busquedaGlobal();
	}
	protected void keyReleasedTxtBuscarxArea(KeyEvent e) {
		busquedaGlobal();
	}
	protected void keyReleasedTxtBuscarxNombre(KeyEvent e) {
		busquedaGlobal();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
	
	protected void mouseClickedTbMemo(MouseEvent e) {
		validarSelecTabla();
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		enviarDatos();
		this.dispose();
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	private String obtenerBusquedaxArea() {
		String buscar = null;
		if(txtBuscarxArea.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxArea.getText().trim();
		}
		return buscar;
	}

	private String obtenerBusquedaxApellido() {
		String buscar = null;
		if(txtBuscarxApellido.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxApellido.getText().trim();
		}
		return buscar;
	}

	private String obtenerBusquedaxNombre() {
		String buscar = null;
		if(txtBuscarxNombre.getText().trim().length() == 0) {
			buscar = null;
		}else {
		buscar = txtBuscarxNombre.getText().trim();
		}
		return buscar;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void enviarDatos() {
		int fila;
		
		String cod, nom, ape, cargo, area;
		
		fila = tbUsuarios.getSelectedRow();

		cod = tbUsuarios.getValueAt(fila, 0).toString();
		nom = tbUsuarios.getValueAt(fila, 1).toString();
		ape = tbUsuarios.getValueAt(fila, 2).toString();
		cargo = tbUsuarios.getValueAt(fila, 3).toString();
		area = tbUsuarios.getValueAt(fila, 4).toString();
		
		if (FrmEnviarMemorandum.boton == "Destinatario") {
			
			FrmEnviarMemorandum.txtCodDes.setText(cod);
			FrmEnviarMemorandum.txtNomDes.setText(nom);
			FrmEnviarMemorandum.txtApeDes.setText(ape);
			FrmEnviarMemorandum.txtCargoDes.setText(cargo);
			FrmEnviarMemorandum.txtAreaDes.setText(area);
			this.dispose();
		}
		
		if (FrmMemoPorRevisar.boton == "asignar") {
			FrmMemoPorRevisar.txtCodRev.setText(cod);
			FrmMemoPorRevisar.txtNomRev.setText(nom);
			FrmMemoPorRevisar.txtApeRev.setText(ape);
			FrmMemoPorRevisar.txtCargoRev.setText(cargo);
			FrmMemoPorRevisar.txtAreaRev.setText(area);
			this.dispose();
		}

	}
	
	private void busquedaGlobal() {
		String buscarxNombre, buscarxApellido, buscarxArea;

		buscarxNombre = obtenerBusquedaxNombre();
		buscarxApellido = obtenerBusquedaxApellido();
		buscarxArea = obtenerBusquedaxArea();

		if (txtBuscarxNombre.getText().trim().length()== 0 && txtBuscarxApellido.getText().trim().length()== 0 && txtBuscarxArea.getText().trim().length()==0) {
			cargarDataUsuario();
		} else {
			ArrayList<ListaUsuarios> lista = gUsuario.buscarUsuarioxNomxApexArea(buscarxNombre,buscarxApellido,buscarxArea);

			model.setRowCount(0);
			for (ListaUsuarios listaUser : lista) {

				Object fila[] = { listaUser.getCodigo(),listaUser.getNombre(), 
						listaUser.getApellido(),
						listaUser.getCargo(),listaUser.getArea()};

				model.addRow(fila);
			}
		}
	}

	
	private void cargarDataUsuario() {
		model.setRowCount(0);

		ArrayList<ListaUsuarios> lista = gUsuario.listarUsuarios();

		for (ListaUsuarios listaUser : lista) {

			Object fila[] = { listaUser.getCodigo(), listaUser.getNombre(), listaUser.getApellido(),
					listaUser.getCargo(), listaUser.getArea() };

			model.addRow(fila);
		}
	}
	
	private void validarSelecTabla() {
		if (tbUsuarios.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla usuarios");
			return;
		}
	}
	
	private void bloquearNumeros(KeyEvent e1) {
	    char letra = e1.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e1.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
}

