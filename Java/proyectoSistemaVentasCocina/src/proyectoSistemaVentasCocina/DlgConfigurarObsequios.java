package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Alertas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarObsequios extends JDialog implements KeyListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarObsequios dialog = new DlgConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblObsequio1 = new JLabel("1 unidad");
			lblObsequio1.setBounds(10, 20, 134, 13);
			contentPanel.add(lblObsequio1);
		}
		{
			JLabel lblObsequio2 = new JLabel("2 a 5 unidades");
			lblObsequio2.setBounds(10, 43, 134, 13);
			contentPanel.add(lblObsequio2);
		}
		{
			JLabel lblObsequio3 = new JLabel("6 a m\u00E1s unidades");
			lblObsequio3.setBounds(10, 66, 134, 13);
			contentPanel.add(lblObsequio3);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(341, 16, 85, 21);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(341, 43, 85, 21);
			contentPanel.add(btnCancelar);
		}
		{
			txtObsequio1 = new JTextField();
			txtObsequio1.addKeyListener(this);
			txtObsequio1.setBounds(176, 17, 96, 19);
			contentPanel.add(txtObsequio1);
			txtObsequio1.setColumns(10);
		}
		{
			txtObsequio2 = new JTextField();
			txtObsequio2.setBounds(176, 40, 96, 19);
			contentPanel.add(txtObsequio2);
			txtObsequio2.setColumns(10);
		}
		{
			txtObsequio3 = new JTextField();
			txtObsequio3.setBounds(176, 63, 96, 19);
			contentPanel.add(txtObsequio3);
			txtObsequio3.setColumns(10);
		}
		//METODO DE CARGAR DATOS CLASE NRO 5 Y CLASE NUMERO 6
		cargarData();
}

		private void cargarData() {
			txtObsequio1.setText(" "+FrmPrincipal.obsequio1);
			txtObsequio2.setText(" "+FrmPrincipal.obsequio2);
			txtObsequio3.setText(" "+FrmPrincipal.obsequio3);
	
}
	

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtObsequio1) {
			keyTypedTxtObsequio1(e);
		}
	}
	protected void keyTypedTxtObsequio1(KeyEvent e) {
		bloquearNumeros(e);
	}

	private void bloquearNumeros(KeyEvent xarg0) {
		char num = xarg0.getKeyChar();
		if(Character.isDigit(num)){
			getToolkit().beep();
			xarg0.consume();
			Alertas.mensajeError("Ingrese solo letras");
		}
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
		double resp;
		String obs1,obs2,obs3;
		 obs1 = txtObsequio1.getText();
		 obs2 = txtObsequio2.getText();
		 obs3 = txtObsequio3.getText();
		//VENTANA DE CONFIRMACION

		resp = JOptionPane.showConfirmDialog(this,"SEGURO DE GUARDAR CAMBIOS?","SISTEMA",JOptionPane.YES_NO_OPTION);
		// VALIDAR LA RESPUESTA DE LA VENTANA DE CONFIRMACION
		if(resp == 0) {//yes --> si --> 0
		//metodo para guardar los cambios
		guardarCambios1(obs1);
		guardarCambios2(obs2);
		guardarCambios3(obs3);
		//CERRAR VENTANA ACTUAL
		this.dispose();
		}
	}
	private void guardarCambios1(String desc1) {
		FrmPrincipal.obsequio1 = txtObsequio1.getText();
	}
	private void guardarCambios2(String desc2) {
		FrmPrincipal.obsequio2 =  txtObsequio2.getText();	
	}
	private void guardarCambios3(String obs3) {
		FrmPrincipal.obsequio3 = txtObsequio3.getText();
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
