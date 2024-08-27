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

import entidad.Areas;
import mantenimiento.GestionAreasDAO;
import utils.Agregar;
import utils.Mensaje;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmActualizarAreas extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTitActualizarAreas;
	private JLabel lblCodArea;
	private JTextField txtCodArea;
	private JButton btnCancelar;
	private JLabel lblNomArea;
	private JTextField txtNomArea;

	GestionAreasDAO gAreas = new GestionAreasDAO();
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmActualizarAreas frame = new FrmActualizarAreas();
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
	public FrmActualizarAreas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitActualizarAreas = new JLabel("ACTUALIZAR ÁREAS");
		lblTitActualizarAreas.setOpaque(true);
		lblTitActualizarAreas.setBackground(Color.BLACK);
		lblTitActualizarAreas.setForeground(Color.WHITE);
		lblTitActualizarAreas.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitActualizarAreas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitActualizarAreas.setBounds(0, 10, 474, 86);
		contentPane.add(lblTitActualizarAreas);

		lblCodArea = new JLabel("Código:");
		lblCodArea.setBounds(86, 161, 55, 25);
		contentPane.add(lblCodArea);

		txtCodArea = new JTextField();
		txtCodArea.setEditable(false);
		txtCodArea.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtCodArea.setBackground(new Color(0, 255, 255));
		txtCodArea.setForeground(Color.BLACK);
		txtCodArea.setBounds(225, 161, 124, 25);
		contentPane.add(txtCodArea);
		txtCodArea.setColumns(10);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmActualizarAreas.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(280, 276, 143, 37);
		contentPane.add(btnCancelar);

		lblNomArea = new JLabel("Nombre de Área:");
		lblNomArea.setBounds(86, 198, 107, 21);
		contentPane.add(lblNomArea);

		txtNomArea = new JTextField();
		txtNomArea.addKeyListener(this);
		txtNomArea.setColumns(10);
		txtNomArea.setBounds(225, 196, 169, 25);
		contentPane.add(txtNomArea);

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
		if (e.getSource() == txtNomArea) {
			keyTypedTxtNomArea(e);
		}
	}
	protected void keyTypedTxtNomArea(KeyEvent e) {
		bloquearNumeros(e);
	}

	
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		int opcion = JOptionPane.showConfirmDialog(this, "Seguro de Salir", "Sistema", JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			abrirMantAreas();

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
			Areas area = new Areas();
			area.setDescArea(descripcion);
			area.setCodigo(codigo);

			int ok = gAreas.actualizar(area);

			if (ok == 0) {
				Mensaje.Error("Error en la Actualizacion");
			} else {
				Mensaje.Exito("Actualizacion Exitosa ");
				abrirMantAreas();
			}
		}
	}
	
	
	private void cargarCajas() {
		txtCodArea.setText(String.valueOf(FrmMantAreas.areaConDatos.getCodigo()));
		txtNomArea.setText(FrmMantAreas.areaConDatos.getDescArea());
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>
	private int getCodigo() {
		int codigo = -1;
		if(txtCodArea.getText().trim().length()==0) {
			Mensaje.Error("Error codigo vacío");
		}else {
			codigo = Integer.parseInt(txtCodArea.getText().trim());
		}
		return codigo;
	}

	private String getDescripcion() {
		String desc = null;
		if(txtNomArea.getText().trim().length()==0) {
			Mensaje.Error("Ingrese nombre o descripción del área");
		}else {
			desc = txtNomArea.getText().trim();
		}
		return desc;
	}
	
	//>>>>>>>>>

	private void abrirMantAreas() {
		this.dispose();
		FrmMantAreas mantAreas = new FrmMantAreas();
		Agregar.alEscritorio(mantAreas);
	}
	
	private void bloquearNumeros(KeyEvent e3) {
	    char letra = e3.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e3.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
}
