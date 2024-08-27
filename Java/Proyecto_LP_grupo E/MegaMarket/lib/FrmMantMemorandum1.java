package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Areas;
import entidad.Estado;
import entidad.ListaMemorandum;
import entidad.Memorandum;
import mantenimiento.GestionAreasDAO;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionMemorandumDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmMantMemorandum1 extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblFecha;
	private JDateChooser dcFecha;
	private JLabel lblTipo;
	@SuppressWarnings("rawtypes")
	private JComboBox cboDestino;
	private JTextField txtNombre;
	private JLabel lblNewLabel;
	private JTextField txtTipo;
	private JLabel lblDestino;
	private JLabel lblEstado;
	@SuppressWarnings("rawtypes")
	private JComboBox cboEstado;
	private JTable tbMemo;
	private JScrollPane scrollPane;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JButton btnRegistrar;
	private JTextField txtBuscar;
	private JLabel lblBuscarXArea;
	
	DefaultTableModel model = new DefaultTableModel();
	GestionAreasDAO gAreas = new GestionAreasDAO();
	GestionMemorandumDAO gMemo = new GestionMemorandumDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();
	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();
	private JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantMemorandum1 frame = new FrmMantMemorandum1();
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
	@SuppressWarnings("rawtypes")
	public FrmMantMemorandum1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 639);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 71, 68, 21);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(61, 86, 96, 31);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 327, 45, 13);
		contentPane.add(lblFecha);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(61, 344, 134, 31);
		contentPane.add(dcFecha);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 395, 45, 13);
		contentPane.add(lblTipo);
		
		cboDestino = new JComboBox();
		cboDestino.setBounds(61, 283, 134, 31);
		contentPane.add(cboDestino);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(61, 152, 202, 31);
		contentPane.add(txtNombre);
		
		lblNewLabel = new JLabel("Nombre/s:");
		lblNewLabel.setBounds(10, 132, 74, 21);
		contentPane.add(lblNewLabel);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(61, 412, 179, 31);
		contentPane.add(txtTipo);
		
		lblDestino = new JLabel("Para el Área de:");
		lblDestino.setBounds(10, 260, 110, 13);
		contentPane.add(lblDestino);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 453, 68, 13);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setEditable(true);
		cboEstado.setBounds(61, 474, 134, 31);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 33, 951, 410);
		contentPane.add(scrollPane);
		
		tbMemo = new JTable();
		scrollPane.setViewportView(tbMemo);
		tbMemo.addMouseListener(this);
		tbMemo.setFillsViewportHeight(true);
		

		// asociar objeto "model" a la tb usuario
		tbMemo.setModel(model);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(444, 532, 159, 70);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(634, 532, 159, 70);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(822, 532, 159, 70);
		contentPane.add(btnSalir);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(61, 219, 202, 31);
		contentPane.add(txtApellido);
		
		lblApellido = new JLabel("Apellido/s:");
		lblApellido.setBounds(10, 193, 74, 21);
		contentPane.add(lblApellido);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(257, 532, 159, 70);
		contentPane.add(btnRegistrar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(156, 6, 96, 31);
		contentPane.add(txtBuscar);
		
		lblBuscarXArea = new JLabel("Buscar por Área:");
		lblBuscarXArea.setBounds(29, 15, 103, 13);
		contentPane.add(lblBuscarXArea);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(1017, 532, 159, 70);
		contentPane.add(btnLimpiar);
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Área");
		model.addColumn("Fecha");
		model.addColumn("Tipo");
		model.addColumn("Estado");
		
		cargarDataMemo();
		llenarComboAreas();
		llenarComboEstado();
		mostrarData(0);
	}

	@SuppressWarnings("unchecked")
	private void llenarComboEstado() {
		ArrayList<Estado> lista = gEstado.listarEstado();
		if (lista.size() == 0) {
			Mensaje.Error("Lista Vacia");
		} else {
			cboEstado.addItem("Seleccione...");
			for (Estado tipEstado : lista) {
				cboEstado.addItem(tipEstado.getDescEstado());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void llenarComboAreas() {
		ArrayList<Areas> lista = gAreas.listarAreas();
		if (lista.size() == 0) {
			Mensaje.Error("Lista Vacia");
		} else {
			cboDestino.addItem("Seleccione...");
			for (Areas tipAreas : lista) {
				cboDestino.addItem(tipAreas.getDescArea());
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
	}

	private void limpiar() {
		txtBuscar.setText("");
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTipo.setText("");
		cboDestino.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
		dcFecha.setDate(null);
		txtCodigo.requestFocus();
	}

	private String getNomEstado() {
	String nomEstado;
	nomEstado = cboEstado.getSelectedItem().toString();
	return nomEstado;
	}
	private String getNomUsuario() {
		String nomUsuario;
		nomUsuario = txtNombre.getText().trim();
		return nomUsuario;
	}
	private String getApeUsuario() {
		String apeUsuario;
		apeUsuario = txtApellido.getText().trim();
		return apeUsuario;
	}
	private String getNomArea() {
		String nomArea;
		nomArea = cboDestino.getSelectedItem().toString();
		return nomArea;
	}

	private int getCodigo() {
		int codigo;
		codigo = Integer.parseInt(txtCodigo.getText().trim());
		return codigo;
	}
	
	private String getTipo() {
		String tipo;
		tipo = txtTipo.getText().trim();
		return tipo;
	}

	private String getFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha;
		fecha = sdf.format(dcFecha.getDate());
		return fecha;
	}
	
	private void mostrarData(int posFila) {
		// declarar las variables

		String codigo,fecha,tipo,destino,estado,nomUsuario, apeUsuario;
		// paso 1: obtener los datos de la tabla
		codigo = tbMemo.getValueAt(posFila, 0).toString();
		nomUsuario = tbMemo.getValueAt(posFila, 1).toString();
		apeUsuario = tbMemo.getValueAt(posFila, 2).toString();
		destino = tbMemo.getValueAt(posFila, 3).toString();
		fecha = tbMemo.getValueAt(posFila, 4).toString();
		tipo = tbMemo.getValueAt(posFila, 5).toString();
		estado = tbMemo.getValueAt(posFila, 6).toString();
		

		// paso 2: enviar los datos de la tabla a las cajas de texto
		txtCodigo.setText(codigo);
		txtNombre.setText(nomUsuario);
		txtApellido.setText(apeUsuario);
		cboDestino.setSelectedItem(destino);
		try {
			dcFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTipo.setText(tipo);
		cboEstado.setSelectedItem(estado);
	}
	private void cargarDataMemo() {
		// 1. Limpiar la Tabla
		model.setRowCount(0);
		// 2 Llamar al proceso de consulta
		ArrayList<ListaMemorandum> lista = gMemo.listarMemo();
		// crear un bucle para el recorrido
		for (ListaMemorandum m : lista) {
			// Crear un arreglo
			Object fila[] = { m.getId_memo(), m.getNombre(),m.getApellido(),m.getArea(),m.getFecha(),m.getTipo(),m.getEstado()};
			// añadir la fila a la tabla
			model.addRow(fila);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbMemo) {
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
	protected void mouseClickedTbMemo(MouseEvent e) {
		int posFila = tbMemo.getSelectedRow();
		// mostrar data
		mostrarData(posFila);
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		// variables
		int codigo;
		String fecha;
		String tipo;
		int destino;
		int estado;
		int usuario;
		// Nombres
		String nomArea, nomUsuario, apeUsuario, nomEstado;
		nomUsuario = getNomUsuario();
		apeUsuario = getApeUsuario();
		nomArea = getNomArea();
		nomEstado = getNomEstado();
		

		destino = gMemo.obtIdArea(nomArea);
		usuario = gMemo.obtIdUsuario(nomUsuario, apeUsuario);
		estado = gMemo.obtIdEstado(nomEstado);
		if (usuario == -1) {
			Mensaje.Error("Usuario incorrecto\nCorrija Nombre o Apellidos ");
			return;
		}
		// entradas
		codigo = getCodigo();
		fecha = getFecha();
		tipo = getTipo();

		// Validar
		if (codigo == -1 || fecha == null || tipo == null || destino == -1 || estado == -1 || usuario == -1) {
			return;
		} else {
			Mensaje.Exito("Datos Correctos");
			limpiar();
		}
		// procesos
		// Crear un objeto de tipo "Usuario"
		Memorandum m = new Memorandum();
		// setear --> Asignar los nuevos valores ingresados por la gui a los atributos
		// privados
		m.setCodigo(codigo);
		m.setFecha(fecha);
		m.setTipo(tipo);
		m.setDestino(destino);
		m.setEstado(estado);
		m.setUsuario(usuario);
		// "GestionUsuario"
		int ok = gMemo.actualizar(m);
		// Validar el Resultado del proceso de registro
		if (ok == 0) {
			Mensaje.Error("Error en el registro");

		} else {
			Mensaje.Exito("Registro Exitoso");
			cargarDataMemo();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		// Declarar Variables
				int codigo, opcion;
				// obtener el codigo
				codigo = getCodigo();
				// validar
				if (codigo == -1) {
					return;
				} else {
					// Ventana de Confirmación
					opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						// Lllamar al proceso de eliminar
						int ok = gMemo.eliminar(codigo);
						// validar el resultado del proceso
						if (ok == 0) {
							Mensaje.Error("Código no existe");
						} else {
							Mensaje.Exito("Usuario Eliminado");
							cargarDataMemo();
						}
					}
				}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		// variables
				int codigo;
				String fecha;
				String tipo;
				int destino;
				int estado;
				int usuario;
				//Nombres
				String nomArea,nomUsuario,apeUsuario,nomEstado;
				nomArea = getNomArea();
				nomUsuario= getNomUsuario();
				nomEstado = getNomEstado();
				apeUsuario = getApeUsuario();
				
				destino = gMemo.obtIdArea(nomArea);
				usuario = gMemo.obtIdUsuario(nomUsuario,apeUsuario);
				estado = gMemo.obtIdEstado(nomEstado);
				if (usuario == -1) {
				    Mensaje.Error("Usuario incorrecto\nCorrija Nombre o Apellidos ");
				    return;
				}
				// entradas
				codigo = getCodigo();
				fecha = getFecha();
				tipo = getTipo();

				// Validar
				if (codigo == -1 || fecha == null || tipo == null || destino == -1 || estado == -1 || usuario == -1) {
					return;
				} else {
					Mensaje.Exito("Datos Correctos");
					limpiar();
				}
				// procesos
				// Crear un objeto de tipo "Usuario"
				Memorandum m = new Memorandum();
				// setear --> Asignar los nuevos valores ingresados por la gui a los atributos
				// privados
				m.setCodigo(codigo);
				m.setFecha(fecha);
				m.setTipo(tipo);
				m.setDestino(destino);
				m.setEstado(estado);
				m.setUsuario(usuario);
				// "GestionMemorandum"
				int ok = gMemo.registrar(m);
				// Validar el Resultado del proceso de registro
				if (ok == 0) {
					Mensaje.Error("Error en el registro");
				} else {
					Mensaje.Exito("Registro Exitoso");
					cargarDataMemo();
				}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			this.dispose();
		}
	}

	private String getBuscar() {
		String buscar;
		buscar = txtBuscar.getText().trim();
		
		return buscar;
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		String buscar;
		// Paso 1: obtener el código ingresado
		buscar = getBuscar();
		// Paso 2: validar que el código ingresado responda al formato
		if (buscar == null) {
			cargarDataMemo();
		} else { // Llamar al método buscarMemo con el texto del campo de búsqueda
            ArrayList<ListaMemorandum> lista = gMemo.buscarMemo(buscar);
            // Agregar los resultados a la tabla
            model.setRowCount(0);
            for (ListaMemorandum m : lista) {
                Object fila[] = { m.getId_memo(), m.getNombre(),m.getApellido(),m.getArea(),m.getFecha(),m.getTipo(),m.getEstado()};
                model.addRow(fila);
            
			}}
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}
}
