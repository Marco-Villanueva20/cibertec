package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import entidad.Cargos;
import mantenimiento.GestionAreasDAO;
import mantenimiento.GestionCargosDAO;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmActualizarCargos extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTituloActCargo;
	private JLabel lblCodCargo;
	private JTextField txtCodCargo;
	private JButton btnCancelar;
	private JLabel lblNomCargo;
	private JTextField txtNomCargo;

	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();
	GestionCargosDAO gCargos = new GestionCargosDAO();
	GestionAreasDAO gAreas = new GestionAreasDAO();
	GestionEstadoDAO gEstado = new GestionEstadoDAO();
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmActualizarCargos frame = new FrmActualizarCargos();
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
	public FrmActualizarCargos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTituloActCargo = new JLabel("ACTUALIZAR CARGO");
		lblTituloActCargo.setOpaque(true);
		lblTituloActCargo.setBackground(Color.BLACK);
		lblTituloActCargo.setForeground(Color.WHITE);
		lblTituloActCargo.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTituloActCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloActCargo.setBounds(0, 10, 474, 86);
		contentPane.add(lblTituloActCargo);

		lblCodCargo = new JLabel("Código:");
		lblCodCargo.setBounds(86, 161, 55, 25);
		contentPane.add(lblCodCargo);

		txtCodCargo = new JTextField();
		txtCodCargo.setEditable(false);
		txtCodCargo.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCodCargo.setBackground(new Color(0, 255, 255));
		txtCodCargo.setForeground(Color.BLACK);
		txtCodCargo.setBounds(225, 161, 124, 25);
		contentPane.add(txtCodCargo);
		txtCodCargo.setColumns(10);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmActualizarCargos.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(280, 276, 143, 37);
		contentPane.add(btnCancelar);

		lblNomCargo = new JLabel("Nombre del Cargo:");
		lblNomCargo.setBounds(86, 198, 107, 21);
		contentPane.add(lblNomCargo);

		txtNomCargo = new JTextField();
		txtNomCargo.addKeyListener(this);
		txtNomCargo.setColumns(10);
		txtNomCargo.setBounds(225, 196, 169, 25);
		contentPane.add(txtNomCargo);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(50, 282, 143, 37);
		contentPane.add(btnActualizar);
		cargarCajas();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNomCargo) {
			keyTypedTxtNomCargo(e);
		}
	}
	protected void keyTypedTxtNomCargo(KeyEvent e) {
		bloquearNumeros(e);
	}

	private void bloquearNumeros(KeyEvent e) {
		char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			abrirMantCargos();

		}
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		int codigo;
		String descripcion;
		
		codigo = getCodigo();
		descripcion = getDescripcion();
		
		if (codigo == -1 || descripcion == null) {
			return;
		} else {
			Cargos car = new Cargos();
			car.setDesCargo(descripcion);
			car.setCodigo(codigo);

			int ok = gCargos.actualizar(car);

			if (ok == 0) {
				Mensaje.Error("Error en la actualizacion");
			} else {
				Mensaje.Exito("Actualizacion Exitosa ");
				abrirMantCargos();
			}
		}
	}
	
	
	private void abrirMantCargos() {
		this.dispose();
		FrmMantCargos mantCargos = new FrmMantCargos();
		Agregar.alEscritorio(mantCargos);
	}
	
	private void cargarCajas() {
		txtCodCargo.setText(String.valueOf(FrmMantCargos.cargoConDatos.getCodigo()));
		txtNomCargo.setText(FrmMantCargos.cargoConDatos.getDesCargo());
	}
	
	
	//>>>>>>>>>>>>>>
	
	private int getCodigo() {
		int codigo = -1;
		if (txtCodCargo.getText().trim().length()==0) {
			Mensaje.Error("Ocurrió un error, el codigo se encuentra vacío");
		}else {
			codigo = Integer.parseInt(txtCodCargo.getText().trim());
		}
		return codigo;
	}

	private String getDescripcion() {
		String desc = null;
		if(txtNomCargo.getText().trim().length()==0) {
			Mensaje.Error("Ingrese nombre o descripción del cargo");
		}else {
			desc = txtNomCargo.getText().trim();
		}
		return desc;
	}
	
	//>>>>>>>>>>>>>>
	
	
}
