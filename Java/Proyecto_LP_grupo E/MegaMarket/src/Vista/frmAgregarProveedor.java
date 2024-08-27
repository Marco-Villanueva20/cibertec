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

public class frmAgregarProveedor extends JInternalFrame implements ActionListener {
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
	private JLabel lblAutogenerado;

	
	GestionProveedorDAO gProv = new GestionProveedorDAO();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAgregarProveedor frame = new frmAgregarProveedor();
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
	public frmAgregarProveedor() {
		setTitle("Agregar Proveedor");
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
		btnGuardar.setIcon(new ImageIcon(frmAgregarProveedor.class.getResource("/Img/floppy-disk.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(57, 207, 111, 39);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(frmAgregarProveedor.class.getResource("/Img/previous.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(178, 207, 111, 39);
		getContentPane().add(btnCancelar);
		
		lblAutogenerado = new JLabel("Código autogenerado.");
		lblAutogenerado.setBounds(112, 29, 177, 14);
		getContentPane().add(lblAutogenerado);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(112, 153, 177, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

	}

	public void setFrmMantenimientoProveedores(frmMantenimientoProveedores frmMantenimientoProveedores) {	
		this.frmMantenimientoProveedores = frmMantenimientoProveedores;
		
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
			
		guardarRegistro();
	}

	private void guardarRegistro() {
		String nomb, ruc, dire;

		// entradas
		nomb = getNombre();
		ruc = getRuc();
		dire = getDireccion();

		// validar
		if (nomb == null || ruc == null || dire == null ) {
			return;
		} else {
			// crear un objeto de la clase Usuarios
			Proveedor p = new Proveedor();
			// setear -> Asignar los valores obtenidos de la GUI a los artículos privados
			p.setNombre(nomb);
			p.setRuc(ruc);
			p.setDireccion(dire);

			// Llamar al proceso del resgistro
			int res = gProv.registrarProveedor(p);
			// Validar el resultado del proceso de registro
			if (res == 0) {
				Alertas.mensajeError("Error en el registro");
			} else {
				Alertas.mensajeExitoso("Proveedor registrado");
				
			}
			
		}
		this.frmMantenimientoProveedores.listar();
		this.dispose();
		return;
	}

	private String getDireccion() {
		String dire = null;
		if(txtDireccion.getText().length() == 0 ) {
			Alertas.mensajeError("Ingresar la direccion del proveedor");
			txtDireccion.requestFocus();
		}else if(txtDireccion.getText().trim().matches(Validaciones.DIRECCION_PROVEEDOR)) {
			dire = txtDireccion.getText().trim();
			}else {
				Alertas.mensajeError("¡Formato incorrecto! Ejm: Parque Empresarial Omega Edificio C");
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
		if(txtRazonSocial.getText().length() == 0 ) {
			Alertas.mensajeError("Ingresar la razón social del proveedor");
			txtRazonSocial.requestFocus();
		}else if(txtRazonSocial.getText().trim().matches(Validaciones.NOMBRE_PROVEEDOR)) {
			nomb = txtRazonSocial.getText().trim();
			}else {
				Alertas.mensajeError("Formato incorrecto, ingresar de 4 a 35 letras");
				txtRazonSocial.setText("");
				txtRazonSocial.requestFocus();
			}
		return nomb;
	}
	
	
}
