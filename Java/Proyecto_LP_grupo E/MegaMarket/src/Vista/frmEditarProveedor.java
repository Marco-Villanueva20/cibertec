	package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entidad.Proveedor;
import Mantenimiento.GestionProveedorDAO;
import utils.Alertas;
import utils.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmEditarProveedor extends JInternalFrame implements ActionListener {
	private JLabel lblCodigo;
	private JLabel lblRazonSocial;
	private JLabel lblRuc;
	private JLabel lblDireccion;
	private JTextField txtRazonSocial;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private frmMantenimientoProveedores frmMantenimientoProveedores;
	private JTextField txtCodigo;
	private Proveedor proveedor = new Proveedor();

	GestionProveedorDAO gProv = new GestionProveedorDAO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarProveedor frame = new frmEditarProveedor();
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
	public frmEditarProveedor() {
		setTitle("Editar Proveedor");
		setBounds(100, 100, 334, 301);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 29, 92, 14);
		getContentPane().add(lblCodigo);

		lblRazonSocial = new JLabel("Razón Social:");
		lblRazonSocial.setBounds(10, 72, 92, 14);
		getContentPane().add(lblRazonSocial);

		lblRuc = new JLabel("RUC:");
		lblRuc.setBounds(10, 112, 92, 14);
		getContentPane().add(lblRuc);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 156, 92, 14);
		getContentPane().add(lblDireccion);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(112, 69, 177, 20);
		getContentPane().add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		txtRuc = new JTextField();
		txtRuc.setBounds(112, 109, 177, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(frmEditarProveedor.class.getResource("/Img/floppy-disk.png")));
		btnGuardar.setBounds(57, 207, 111, 39);
		btnGuardar.addActionListener(this);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmEditarProveedor.class.getResource("/Img/previous.png")));
		btnCancelar.setBounds(178, 207, 111, 39);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(112, 153, 177, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(112, 26, 177, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

	}

	public void setFrmMantenimientoProveedores(frmMantenimientoProveedores frmMantenimientoProveedores) {
		this.frmMantenimientoProveedores = frmMantenimientoProveedores;

	}
	
	public void cargar(int codigo) {
		proveedor = gProv.obtener(codigo);
		
		txtCodigo.setText(Integer.toString((proveedor.getCodigo())));
		txtRazonSocial.setText(proveedor.getNombre());
		txtRuc.setText(proveedor.getRuc());
		txtDireccion.setText(proveedor.getDireccion());

		txtRazonSocial.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {

		actualizarProveedor();
	}

	private void actualizarProveedor() {
		String nomb, ruc, dire;
		int cod;
		// entradas
		cod = getCodigo();
		nomb = getNombre();
		ruc = getRuc();
		dire = getDireccion();

		// validar
		if (cod == -1 || nomb == null || ruc == null || dire == null) {
			return;
		} else {
			// crear un objeto de la clase Usuarios
			Proveedor p = new Proveedor();
			// setear -> Asignar los valores obtenidos de la GUI a los artículos privados
			p.setNombre(nomb);
			p.setRuc(ruc);
			p.setDireccion(dire);
			p.setCodigo(cod);

			// Llamar al proceso del resgistro
			int res = gProv.ActualizarProveedor(p);
			// Validar el resultado del proceso de registro
			if (res == 0) {
				Alertas.mensajeError("Error en la actualización");
			} else {
				Alertas.mensajeExitoso("Proveedor actualizado");

			}

		}
		this.frmMantenimientoProveedores.listar();
		this.dispose();
		return;
	}

	private int getCodigo() {
		int cod = -1; 
		cod = Integer.parseInt(txtCodigo.getText());
		return cod;
	}

	private String getDireccion() {
		String dire = null;
		if (txtDireccion.getText().length() == 0) {
			Alertas.mensajeError("Ingresar la dirección proveedor");
			txtDireccion.requestFocus();
		} else if (txtDireccion.getText().trim().matches(Validaciones.DIRECCION_PROVEEDOR)) {
			dire = txtDireccion.getText().trim();
		} else {
			Alertas.mensajeError("¡Formato incorrecto! Ejm: Parque Empresarial Omega Edificio C ");
			txtDireccion.setText("");
			txtDireccion.requestFocus();
		}
		return dire;
	}

	private String getRuc() {
		String ruc = null;
		// campo vacío
		if (txtRuc.getText().trim().length() == 0) {
			Alertas.mensajeError("Ingresar el RUC del proveedor");
			txtRuc.setText("");
			txtRuc.requestFocus();
			// Formato 8 DIGITOS
		} else if (txtRuc.getText().trim().matches(Validaciones.RUC_PROVEEDOR)) {
			ruc = txtRuc.getText().trim();
		} else {
			Alertas.mensajeError("!Formato incorrecto¡Ej. 20527188564");
			txtRuc.setText("");
			txtRuc.requestFocus();
		}
		return ruc;
	}

	private String getNombre() {
		String nomb = null;
		if (txtRazonSocial.getText().length() == 0) {
			Alertas.mensajeError("Ingresar la razón social del proveedor");
			txtRazonSocial.requestFocus();
		} else if (txtRazonSocial.getText().trim().matches(Validaciones.NOMBRE_PROVEEDOR)) {
			nomb = txtRazonSocial.getText().trim();
		} else {
			Alertas.mensajeError("Formato incorrecto, ingresar de 4 a 35 letras");
			txtRazonSocial.setText("");
			txtRazonSocial.requestFocus();
		}
		return nomb;
	}

}
