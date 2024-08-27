package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConfigurarCantidadOptima extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantOptima;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCantidadOptima dialog = new DlgConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCantidadOptima() {
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 450, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(341, 8, 85, 21);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(341, 39, 85, 21);
			contentPanel.add(btnCancelar);
		}
		{
			JLabel lblCantidadOptima = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
			lblCantidadOptima.setBounds(10, 14, 228, 13);
			contentPanel.add(lblCantidadOptima);
		}
		{
			txtCantOptima = new JTextField();
			txtCantOptima.addKeyListener(this);
			txtCantOptima.setBounds(248, 11, 49, 19);
			contentPanel.add(txtCantOptima);
			txtCantOptima.setColumns(10);
		}
		//METODO DE CARGAR DATOS CLASE NRO 5 Y CLASE NUMERO 6
		cargarData();
}

	private void cargarData() {
	txtCantOptima.setText(" "+FrmPrincipal.cantidadOptima);
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int cant,resp = 0;
		
		try {
			cant = Integer.parseInt(txtCantOptima.getText());
			//VENTANA DE CONFIRMACION
			if(cant <= 0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				txtCantOptima.setText("");
				txtCantOptima.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			Alertas.mensajeError("Ingresar valores Numericos");
			txtCantOptima.setText("");
			txtCantOptima.requestFocus();
			return;
		}
		resp = JOptionPane.showConfirmDialog(this,"SEGURO DE GUARDAR CAMBIOS?","SISTEMA",JOptionPane.YES_NO_OPTION);
		// VALIDAR LA RESPUESTA DE LA VENTANA DE CONFIRMACION
		if(resp == 0) {//yes --> si --> 0
		//metodo para guardar los cambios
		guardarCambios(cant);
		//CERRAR VENTANA ACTUAL
		this.dispose();
		}
	}

	private void guardarCambios(int cant) {
		FrmPrincipal.cantidadOptima =Integer.parseInt(txtCantOptima.getText());
		return;
	}
	
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCantOptima) {
			keyTypedTxtCantOptima(e);
		}
	}
	protected void keyTypedTxtCantOptima(KeyEvent e) {
		bloquearNumeros(e);
	}

	private void bloquearNumeros(KeyEvent e) {
		char letra = e.getKeyChar();
		if(Character.isLetter(letra)){
			getToolkit().beep();
			e.consume();
			Alertas.mensajeError("Ingrese solo números");
		}		
		
	}
}
