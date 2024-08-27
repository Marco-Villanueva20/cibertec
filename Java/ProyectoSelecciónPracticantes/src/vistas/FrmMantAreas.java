package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Areas;
import mantenimiento.GestionAreasDAO;
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
public class FrmMantAreas extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblTitMantAreas;
	private JLabel lblFiltrar;
	private JTextField txtBuscar;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTable tbArea;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();

	public static Areas areaConDatos = new Areas();

	GestionAreasDAO gAreas = new GestionAreasDAO();
	
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantAreas frame = new FrmMantAreas();
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
	public FrmMantAreas() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 706, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitMantAreas = new JLabel("MANTENIMIENTO AREAS");
		lblTitMantAreas.setBounds(0, 10, 692, 76);
		lblTitMantAreas.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitMantAreas.setOpaque(true);
		lblTitMantAreas.setBackground(Color.DARK_GRAY);
		lblTitMantAreas.setForeground(Color.WHITE);
		lblTitMantAreas.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitMantAreas);

		lblFiltrar = new JLabel("Filtrar nombre de area:");
		lblFiltrar.setBounds(10, 133, 160, 42);
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblFiltrar);

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(193, 140, 349, 32);
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

		tbArea = new JTable();
		tbArea.addMouseListener(this);
		tbArea.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbArea);

		tbArea.setModel(model);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(193, 212, 123, 26);
		contentPane.add(btnActualizar);
		model.addColumn("Código");
		model.addColumn("Descripcion");
		
		cargarDataArea();

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
		if (e.getSource() == tbArea) {
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
	
	private void keyTypedTxtBuscar(KeyEvent e) {
		bloquearNumeros(e);
	}
	
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		buscarxEstado();
	}

	protected void mouseClickedTbMemo(MouseEvent e) {
		validarSelecTabla();
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		FrmAgregarAreas agrAreas = new FrmAgregarAreas();
		Agregar.alEscritorio(agrAreas);
		this.dispose();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		if (tbArea.getSelectedRow() == -1) {
			Mensaje.Error("Selecione el área que va actualizar");
			return;
		} else {
			validarSelecTabla();
			FrmActualizarAreas actAreas = new FrmActualizarAreas();
			Agregar.alEscritorio(actAreas);
			this.dispose();
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int posFila, opcion;
		posFila = tbArea.getSelectedRow();
		if (posFila == -1) {
			Mensaje.Error("Selecione el área que va eliminar");
			return;
		}
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			int res = gAreas.eliminar(Integer.parseInt(model.getValueAt(posFila, 0).toString()));
			if (res == 1) {
				Mensaje.Exito("Área eliminado correctamente");
			} else {
				Mensaje.Error("Ocurrió un error al intentar eliminar el área");
			}
		}
		cargarDataArea();
		return;

	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
		this.dispose();
		}
	}

	

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	private String getBuscar() {
		String buscar;
		buscar = txtBuscar.getText().trim();
		return buscar;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><

	private void buscarxEstado() {
		String busxEstado;

		busxEstado = getBuscar();

		if (txtBuscar.getText().trim().length() == 0) {
			cargarDataArea();
		} else {
			ArrayList<Areas> lista = gAreas.listarArea(busxEstado);

			model.setRowCount(0);
			for (Areas es : lista) {
				Object fila[] = { es.getCodigo(),es.getDescArea()};
				model.addRow(fila);

			}
		}
	}
	private void cargarDataArea() {
		model.setRowCount(0);
		ArrayList<Areas> lista = gAreas.listarAreas();
		for (Areas es : lista) {
			Object fila[] = { es.getCodigo(), es.getDescArea() };
			model.addRow(fila);
		}
	}
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}

	private void validarSelecTabla() {
		if (tbArea.getSelectedRow() == -1) {
			Mensaje.Error("Selecione una fila de la tabla áreas");
			return;
		} else {
			int posFila = tbArea.getSelectedRow();

			dataParaActualizar(posFila);
		}
	}
	private void dataParaActualizar(int posFila) {
		areaConDatos.setCodigo(Integer.parseInt(tbArea.getValueAt(posFila, 0).toString()));
		areaConDatos.setDescArea(tbArea.getValueAt(posFila, 1).toString());

}
}
