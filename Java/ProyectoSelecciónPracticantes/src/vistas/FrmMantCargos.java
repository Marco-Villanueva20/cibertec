package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cargos;
import mantenimiento.GestionCargosDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmMantCargos extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblTitMantCargos;
	private JLabel lblFiltrar;
	private JTextField txtBuscar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTable tbCargos;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	public static Cargos cargoConDatos = new Cargos();
	GestionCargosDAO gCargos = new GestionCargosDAO();


	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantCargos frame = new FrmMantCargos();
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
	public FrmMantCargos() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 706, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitMantCargos = new JLabel("MANTENIMIENTO CARGOS");
		lblTitMantCargos.setBounds(0, 10, 692, 76);
		lblTitMantCargos.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitMantCargos.setOpaque(true);
		lblTitMantCargos.setBackground(Color.DARK_GRAY);
		lblTitMantCargos.setForeground(Color.WHITE);
		lblTitMantCargos.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitMantCargos);

		lblFiltrar = new JLabel("Filtrar nombre del cargo:");
		lblFiltrar.setBounds(10, 133, 206, 42);
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblFiltrar);

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(240, 140, 349, 32);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(69, 209, 101, 26);
		contentPane.add(btnAgregar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(341, 209, 101, 26);
		contentPane.add(btnEliminar);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(471, 209, 101, 26);
		contentPane.add(btnSalir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 276, 672, 345);
		contentPane.add(scrollPane);

		tbCargos = new JTable();
		tbCargos.addMouseListener(this);
		tbCargos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbCargos);

		tbCargos.setModel(model);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(193, 212, 123, 26);
		contentPane.add(btnActualizar);
		model.addColumn("Código");
		model.addColumn("Descripcion");

		cargarDataCargos();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyTypedTxtBuscar(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbCargos) {
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
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		buscarxEstado();
	}
	protected void mouseClickedTbMemo(MouseEvent e) {
		validarSelecTabla();
	}
	protected void keyTypedTxtBuscar(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		FrmAgregarCargos agrCargos = new FrmAgregarCargos();
		Agregar.alEscritorio(agrCargos);
		this.dispose();
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		if (tbCargos.getSelectedRow() == -1) {
			Mensaje.Error("Selecione el cargo que va Actualizar");
			return;
		} else {
			validarSelecTabla();
			FrmActualizarCargos actCargos = new FrmActualizarCargos();
			Agregar.alEscritorio(actCargos);
			this.dispose();
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int posFila, opcion;
		posFila = tbCargos.getSelectedRow();
		if (posFila == -1) {
			Mensaje.Error("Selecione el cargo a eliminar");
			return;
		}
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = gCargos.eliminar(Integer.parseInt(model.getValueAt(posFila, 0).toString()));
			if (res == 1) {
				Mensaje.Exito("Cargo eliminado correctamente");
			} else {
				Mensaje.Error("Ocurrio un error al intentar eliminar el Cargo");
			}
		}
		cargarDataCargos();
		return;

	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de salir", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
		this.dispose();
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private String getBuscar() {
		String buscar;
		buscar = txtBuscar.getText().trim();

		return buscar;
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
	
	private void dataParaActualizar(int posFila) {
		cargoConDatos.setCodigo(Integer.parseInt(tbCargos.getValueAt(posFila, 0).toString()));
		cargoConDatos.setDesCargo(tbCargos.getValueAt(posFila, 1).toString());

	}

	private void validarSelecTabla() {
		if (tbCargos.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila existente de la tabla cargo");
			return;
		} else {
			int posFila = tbCargos.getSelectedRow();
			dataParaActualizar(posFila);
		}
	}
	private void buscarxEstado() {
		String busxEstado;
		busxEstado = getBuscar();

		if (txtBuscar.getText().trim().length() == 0) {
			cargarDataCargos();
		} else {
			ArrayList<Cargos> lista = gCargos.listarCargo(busxEstado);
			model.setRowCount(0);
			for (Cargos es : lista) {
				Object fila[] = { es.getCodigo(), es.getDesCargo() };
				model.addRow(fila);

			}
		}
	}
	private void cargarDataCargos() {
		model.setRowCount(0);
		ArrayList<Cargos> lista = gCargos.listarCargo();
		for (Cargos es : lista) {
			Object fila[] = { es.getCodigo(), es.getDesCargo() };
			model.addRow(fila);
		}
	}

}
