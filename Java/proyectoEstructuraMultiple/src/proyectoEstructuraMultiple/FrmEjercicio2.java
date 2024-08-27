package proyectoEstructuraMultiple;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEjercicio2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEjercicio2 frame = new FrmEjercicio2();
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
	public FrmEjercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("Numero :");
		lblNumero.setBounds(10, 24, 62, 13);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(82, 21, 96, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 69, 364, 133);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(289, 20, 85, 21);
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		String obs;
		int numero;
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
		case 10,48: obs = "Reloj";break;		//ES LO RECOMENDABLE 
				//OTRA OPCION SERIA : case 48:
								//    case 10: obs ="Reloj"; break;
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
