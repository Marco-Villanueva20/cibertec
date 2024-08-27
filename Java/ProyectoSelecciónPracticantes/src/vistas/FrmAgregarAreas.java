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
public class FrmAgregarAreas extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblTitAgrArea;
	private JLabel lblCodArea;
	private JTextField txtCodArea;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JLabel lblNomArea;
	private JTextField txtNomArea;

	
	GestionAreasDAO gAreas = new GestionAreasDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgregarAreas frame = new FrmAgregarAreas();
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
	public FrmAgregarAreas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitAgrArea = new JLabel("AGREGAR ÁREA");
		lblTitAgrArea.setOpaque(true);
		lblTitAgrArea.setBackground(Color.BLACK);
		lblTitAgrArea.setForeground(Color.WHITE);
		lblTitAgrArea.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTitAgrArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitAgrArea.setBounds(0, 10, 474, 86);
		contentPane.add(lblTitAgrArea);

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
		btnCancelar.setIcon(new ImageIcon(FrmAgregarAreas.class.getResource("/img/cerrar.png")));
		btnCancelar.setBounds(280, 276, 143, 37);
		contentPane.add(btnCancelar);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(FrmAgregarAreas.class.getResource("/img/GuardarTodo.png")));
		btnAgregar.setBounds(63, 276, 124, 37);
		contentPane.add(btnAgregar);

		lblNomArea = new JLabel("Nombre del área:");
		lblNomArea.setBounds(86, 198, 101, 21);
		contentPane.add(lblNomArea);

		txtNomArea = new JTextField();
		txtNomArea.addKeyListener(this);
		txtNomArea.setColumns(10);
		txtNomArea.setBounds(225, 196, 169, 25);
		contentPane.add(txtNomArea);

		txtCodArea.setText(String.valueOf(gAreas.numIdArea()));
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

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		int codigo;
		String descripcion;
		codigo = getCodigo();
		descripcion = getDescripcion();
		
		if (codigo == -1 || descripcion == null) {
			return;
		} else {
			Areas area = new Areas();

			area.setCodigo(codigo);
			area.setDescArea(descripcion);

			int ok = gAreas.registro(area);

			if (ok == 0) {
				Mensaje.Error("Error en el registro");
			} else {
				Mensaje.Exito("Registro Exitoso");
				abrirMantAreas();
			}
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private int getCodigo() {
		int codigo = -1;
		if(txtCodArea.getText().trim().length()==0) {
			Mensaje.Error("Error al generar el codigo, verifique");
		}else {
			codigo = Integer.parseInt(txtCodArea.getText().trim());
		}
		return codigo;
	}

	private String getDescripcion() {
		String desc = null;
		if(txtNomArea.getText().trim().length()==0) {
			Mensaje.Error("Ingrese nombre/descripcion del área");
		}else {
			desc = txtNomArea.getText().trim();
		}
		return desc;
	}
	
	//>>>>>>>>>>>>>>>>>>>
	
	private void abrirMantAreas() {
		this.dispose();
		FrmMantAreas fMantAreas = new FrmMantAreas();
		Agregar.alEscritorio(fMantAreas);
	}
	private void bloquearNumeros(KeyEvent e) {
	    char letra = e.getKeyChar();
	    if (Character.isDigit(letra)) {
	        getToolkit().beep();
	        e.consume();
	        Mensaje.Error("Ingrese solo letras");
	    }
	}
}
