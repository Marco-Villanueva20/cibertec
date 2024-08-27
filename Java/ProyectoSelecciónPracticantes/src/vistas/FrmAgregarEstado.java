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
import entidad.Estado;
import mantenimiento.GestionEstadoDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmAgregarEstado extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTitAgrEstado;
	private JLabel lblCodigo;
	private JTextField txtCodEstado;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JLabel lblNomEstado;
	private JTextField txtNomEstado;

	
	GestionEstadoDAO gEstado = new GestionEstadoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarEstado frame = new FrmAgregarEstado();
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
	public FrmAgregarEstado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitAgrEstado = new JLabel("AGREGAR ESTADO");
		lblTitAgrEstado.setOpaque(true);
		lblTitAgrEstado.setBackground(Color.BLACK);
		lblTitAgrEstado.setForeground(Color.WHITE);
		lblTitAgrEstado.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitAgrEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitAgrEstado.setBounds(0, 10, 474, 86);
		contentPane.add(lblTitAgrEstado);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(86, 161, 55, 25);
		contentPane.add(lblCodigo);

		txtCodEstado = new JTextField();
		txtCodEstado.setEditable(false);
		txtCodEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCodEstado.setBackground(new Color(0, 255, 255));
		txtCodEstado.setForeground(Color.BLACK);
		txtCodEstado.setBounds(225, 161, 124, 25);
		contentPane.add(txtCodEstado);
		txtCodEstado.setColumns(10);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmAgregarEstado.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(280, 276, 143, 37);
		contentPane.add(btnCancelar);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmAgregarEstado.class.getResource("/img/GuardarTodo.png")));
		btnAgregar.setBounds(63, 276, 124, 37);
		contentPane.add(btnAgregar);

		lblNomEstado = new JLabel("Nombre del estado:");
		lblNomEstado.setBounds(86, 198, 101, 21);
		contentPane.add(lblNomEstado);

		txtNomEstado = new JTextField();
		txtNomEstado.addKeyListener(this);
		txtNomEstado.setColumns(10);
		txtNomEstado.setBounds(225, 196, 169, 25);
		contentPane.add(txtNomEstado);
		
		txtCodEstado.setText(String.valueOf(gEstado.numIdEstado()));

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
		if (e.getSource() == txtNomEstado) {
			keyTypedTxtNomEstado(e);
		}
	}
	protected void keyTypedTxtNomEstado(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			abrirMantEstado();

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
			Estado es = new Estado();

			es.setCodigo(codigo);
			es.setDescEstado(descripcion);

			int ok = gEstado.registro(es);

			if (ok == 0) {
				Mensaje.Error("Error en el registro");
			} else {
				Mensaje.Exito("Registro Exitoso");
				abrirMantEstado();
			}
		}
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>
	private int getCodigo() {
		int codigo =-1;
		if (txtCodEstado.getText().trim().length()==0) {
			Mensaje.Error("Error al generar el código");
		}else {
			codigo = Integer.parseInt(txtCodEstado.getText().trim());
		}
		return codigo;
	}

	private String getDescripcion() {
		String desc = null;
		if (txtNomEstado.getText().trim().length()==0) {
			Mensaje.Error("Ingrese nombre/descripcion del estado");
		}else {
			desc = txtNomEstado.getText().trim();
		}
		return desc;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
	private void abrirMantEstado() {
		this.dispose();
		FrmMantEstado fMantEstado = new FrmMantEstado();
		Agregar.alEscritorio(fMantEstado);
	}
	
}
