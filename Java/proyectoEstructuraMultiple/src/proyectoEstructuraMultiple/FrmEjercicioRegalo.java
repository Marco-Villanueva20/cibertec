package proyectoEstructuraMultiple;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEjercicioRegalo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JButton btnProcesar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicioRegalo frame = new FrmEjercicioRegalo();
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
	public FrmEjercicioRegalo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 13, 45, 13);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(82, 10, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(293, 9, 85, 21);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 53, 368, 124);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		int numero;
		String obs;
		//ENTRADA DE DATOS
		try {
			numero = Integer.parseInt(txtNumero.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,"Ingresar valores Numericos","Error",0);
			txtNumero.setText("");
			txtS.setText("");
			txtNumero.requestFocus();
			return;
			
		}
		//PROCESO DE CALCULO
		switch(numero) {
		case 10 : obs = "Reloj";break;
		case 27: obs = "Memoria USB";break;
		case 36: obs = "Pelota";break;
		case 5: obs = "Lapicero";break;
		default: obs = "No tiene obsequio";
		}
		//SALIDA DE DATOS
		txtS.setText("Resultados \n");
		txtS.append("Obsequio: "+ obs);
		
	}
}
