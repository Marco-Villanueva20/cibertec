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

public class DlgConfigurarCuotaDiaria extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiariaEsperada;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCuotaDiaria() {
		setTitle(" Configurar cuota diaria\r");
		setBounds(100, 100, 500, 116);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuotaDioariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
			lblCuotaDioariaEsperada.setBounds(10, 14, 163, 13);
			contentPanel.add(lblCuotaDioariaEsperada);
		}
		{
			txtCuotaDiariaEsperada = new JTextField();
			txtCuotaDiariaEsperada.addKeyListener(this);
			txtCuotaDiariaEsperada.setBounds(197, 11, 124, 19);
			contentPanel.add(txtCuotaDiariaEsperada);
			txtCuotaDiariaEsperada.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(380, 10, 85, 21);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(380, 39, 85, 21);
			contentPanel.add(btnCancelar);
		}
		
		//METODO DE CARGAR DATOS CLASE NRO 5 Y CLASE NUMERO 6
		cargarData();
}

		private void cargarData() {
			txtCuotaDiariaEsperada.setText(" "+FrmPrincipal.cuotaDiaria);	
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
		int cant ,resp ;
		try {
			cant = Integer.parseInt(txtCuotaDiariaEsperada.getText());
			if(cant <=0) {
				Alertas.mensajeError("Ingresar valores mayores a 0");
				txtCuotaDiariaEsperada.setText("");
				txtCuotaDiariaEsperada.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			
			Alertas.mensajeError("Ingresar valores numericos");
			txtCuotaDiariaEsperada.setText("");
			txtCuotaDiariaEsperada.requestFocus();
			return;
		}
		//VENTANA DE CONFIRMACION
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
		FrmPrincipal.cuotaDiaria = Integer.parseInt(txtCuotaDiariaEsperada.getText());
		return;
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCuotaDiariaEsperada) {
			keyTypedTxtCuotaDiariaEsperada(e);
		}
	}
	protected void keyTypedTxtCuotaDiariaEsperada(KeyEvent e) {
		bloquearLetras(e);
	}

	private void bloquearLetras(KeyEvent e) {
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
