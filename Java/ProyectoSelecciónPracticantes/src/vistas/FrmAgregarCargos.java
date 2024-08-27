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
import mantenimiento.GestionCargosDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmAgregarCargos extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTitAgregarCargos;
	private JLabel lblCodCargo;
	private JTextField txtCodCargo;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JLabel lblNomCargo;
	private JTextField txtNomCargo;

	GestionCargosDAO gCargos = new GestionCargosDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarCargos frame = new FrmAgregarCargos();
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
	public FrmAgregarCargos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitAgregarCargos = new JLabel("AGREGAR CARGO");
		lblTitAgregarCargos.setOpaque(true);
		lblTitAgregarCargos.setBackground(Color.BLACK);
		lblTitAgregarCargos.setForeground(Color.WHITE);
		lblTitAgregarCargos.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitAgregarCargos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitAgregarCargos.setBounds(0, 10, 474, 86);
		contentPane.add(lblTitAgregarCargos);

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
		btnCancelar.setIcon(new ImageIcon(FrmAgregarCargos.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(280, 276, 143, 37);
		contentPane.add(btnCancelar);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmAgregarCargos.class.getResource("/img/GuardarTodo.png")));
		btnAgregar.setBounds(63, 276, 124, 37);
		contentPane.add(btnAgregar);

		lblNomCargo = new JLabel("Nombre del cargo:");
		lblNomCargo.setBounds(86, 198, 101, 21);
		contentPane.add(lblNomCargo);

		txtNomCargo = new JTextField();
		txtNomCargo.addKeyListener(this);
		txtNomCargo.setColumns(10);
		txtNomCargo.setBounds(225, 196, 169, 25);
		contentPane.add(txtNomCargo);
		
		txtCodCargo.setText(String.valueOf(gCargos.numIdCargo()));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
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
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			abrirMantCargo();

		}
	}

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		int codigo;
		String descripcion;
		
		codigo = getCodigo();
		descripcion = getDescripcion();
		
		if (codigo == -1 || descripcion == null) {
			return;
		} else {
			Cargos car = new Cargos();

			car.setCodigo(codigo);
			car.setDesCargo(descripcion);

			int ok = gCargos.registro(car);

			if (ok == 0) {
				Mensaje.Error("Error en el registro");
			} else {
				Mensaje.Exito("Registro Exitoso");
				abrirMantCargo();
			}
		}
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>>>>
	private int getCodigo() {
		int codigo=-1;
		if (txtCodCargo.getText().trim().length()==0) {
			Mensaje.Error("Error al generar el codigo,verifique");
		}else {
			codigo = Integer.parseInt(txtCodCargo.getText().trim());
		}
		return codigo;
	}

	private String getDescripcion() {
		String desc = null;
		if (txtNomCargo.getText().trim().length()==0) {
			Mensaje.Error("Ingrese nombre/descripcion del cargo");
		}else {
			desc = txtNomCargo.getText().trim();
		}
		return desc;
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
	private void abrirMantCargo() {
		this.dispose();
		FrmMantCargos mantCargo = new FrmMantCargos();
		Agregar.alEscritorio(mantCargo);
	}
}
