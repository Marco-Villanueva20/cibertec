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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescuento1;
	private JTextField txtDescuento2;
	private JTextField txtDescuento4;
	private JButton btnAceptar;
	private JTextField txtDescuento3;
	private JButton btnCancelar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDescuento1 = new JLabel("1 a 5 unidades");
			lblDescuento1.setBounds(10, 27, 111, 13);
			contentPanel.add(lblDescuento1);
		}
		{
			JLabel lblDescuento2 = new JLabel("6 a 10 unidades");
			lblDescuento2.setBounds(10, 50, 111, 13);
			contentPanel.add(lblDescuento2);
		}
		{
			JLabel lblDescuento3 = new JLabel("11 a 15 unidades");
			lblDescuento3.setBounds(10, 76, 111, 13);
			contentPanel.add(lblDescuento3);
		}
		{
			JLabel lblDescuento4 = new JLabel("M\u00E1s de 15 Unidades");
			lblDescuento4.setBounds(10, 99, 129, 13);
			contentPanel.add(lblDescuento4);
		}
		{
			txtDescuento1 = new JTextField();
			txtDescuento1.addKeyListener(this);
			txtDescuento1.setBounds(149, 24, 96, 19);
			contentPanel.add(txtDescuento1);
			txtDescuento1.setColumns(10);
		}
		{
			txtDescuento2 = new JTextField();
			txtDescuento2.addKeyListener(this);
			txtDescuento2.setBounds(149, 47, 96, 19);
			contentPanel.add(txtDescuento2);
			txtDescuento2.setColumns(10);
		}
		{
			txtDescuento4 = new JTextField();
			txtDescuento4.addKeyListener(this);
			txtDescuento4.setBounds(149, 96, 96, 19);
			contentPanel.add(txtDescuento4);
			txtDescuento4.setColumns(10);
		}
		{
			JLabel lblPorcentaje1 = new JLabel("%");
			lblPorcentaje1.setBounds(255, 27, 45, 13);
			contentPanel.add(lblPorcentaje1);
		}
		{
			JLabel lblPorcentaje2 = new JLabel("%");
			lblPorcentaje2.setBounds(255, 50, 45, 13);
			contentPanel.add(lblPorcentaje2);
		}
		{
			JLabel lblPorcentaje3 = new JLabel("%");
			lblPorcentaje3.setBounds(255, 73, 45, 13);
			contentPanel.add(lblPorcentaje3);
		}
		{
			JLabel lblPorcentaje4 = new JLabel("%");
			lblPorcentaje4.setBounds(255, 96, 45, 13);
			contentPanel.add(lblPorcentaje4);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(341, 46, 85, 21);
			contentPanel.add(btnCancelar);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(341, 19, 85, 21);
			contentPanel.add(btnAceptar);
		}
		{
			txtDescuento3 = new JTextField();
			txtDescuento3.addKeyListener(this);
			txtDescuento3.setColumns(10);
			txtDescuento3.setBounds(149, 73, 96, 19);
			contentPanel.add(txtDescuento3);
			
		}
		//METODO DE CARGAR DATOS CLASE NRO 5 Y CLASE NUMERO 6
			cargarData();
	}

	private void cargarData() {
		txtDescuento1.setText(" "+FrmPrincipal.porcentaje1);
		txtDescuento2.setText(" "+FrmPrincipal.porcentaje2);
		txtDescuento3.setText(" "+FrmPrincipal.porcentaje3);
		txtDescuento4.setText(" "+FrmPrincipal.porcentaje4);
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
		double resp,desc1,desc2,desc3,desc4;
		 try {
			desc1 = Double.parseDouble(txtDescuento1.getText());
			 desc2 = Double.parseDouble(txtDescuento2.getText());
			 desc3 = Double.parseDouble(txtDescuento3.getText());
			 desc4 = Double.parseDouble(txtDescuento4.getText());

			//VENTANA DE CONFIRMACION
			 if(desc1 <= 0 || desc2 <=0 || desc3 <= 0 || desc4 <= 0) {
				 Alertas.mensajeError("Ingresar valores mayores a 0");
				 txtDescuento1.setText("");
				 txtDescuento2.setText("");
				 txtDescuento3.setText("");
				 txtDescuento4.setText("");
				 txtDescuento1.requestFocus();
				 return;
			 }
		} catch (NumberFormatException e1) {
			 Alertas.mensajeError("Ingresar valores numericos");
			 txtDescuento1.setText("");
			 txtDescuento2.setText("");
			 txtDescuento3.setText("");
			 txtDescuento4.setText("");
			 txtDescuento1.requestFocus();
			 return;
		}
		resp = JOptionPane.showConfirmDialog(this,"SEGURO DE GUARDAR CAMBIOS?","SISTEMA",JOptionPane.YES_NO_OPTION);
		// VALIDAR LA RESPUESTA DE LA VENTANA DE CONFIRMACION
		if(resp == 0) {//yes --> si --> 0
		//metodo para guardar los cambios
		guardarCambios1(desc1);
		guardarCambios2(desc2);
		guardarCambios3(desc3);
		guardarCambios4(desc4);
		
		//CERRAR VENTANA ACTUAL
		this.dispose();
		}
	}
	private void guardarCambios1(double desc1) {
		FrmPrincipal.porcentaje1 = Double.parseDouble(txtDescuento1.getText());	
	}
	private void guardarCambios2(double desc2) {
		FrmPrincipal.porcentaje2 = Double.parseDouble(txtDescuento2.getText());	
	}
	private void guardarCambios3(double desc3) {
		FrmPrincipal.porcentaje3 = Double.parseDouble(txtDescuento3.getText());	
	}
	private void guardarCambios4(double desc4) {
		FrmPrincipal.porcentaje4 = Double.parseDouble(txtDescuento4.getText());	
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDescuento4) {
			keyTypedTxtDescuento4(e);
		}
		if (e.getSource() == txtDescuento3) {
			keyTypedTxtDescuento3(e);
		}
		if (e.getSource() == txtDescuento2) {
			keyTypedTxtDescuento2(e);
		}
		if (e.getSource() == txtDescuento1) {
			keyTypedTxtDescuento1(e);
		}
	}
	protected void keyTypedTxtDescuento1(KeyEvent e) {
		bloquearNumeros(e);
	}
		
	protected void keyTypedTxtDescuento2(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void keyTypedTxtDescuento3(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void keyTypedTxtDescuento4(KeyEvent e) {
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
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
