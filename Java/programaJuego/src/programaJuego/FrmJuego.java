package programaJuego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmJuego extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblGolesA;
	private JTextField txtGolesA;
	private JLabel lblGolesB;
	private JTextField txtGolesB;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmJuego frame = new FrmJuego();
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
	public FrmJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblGolesA = new JLabel("Goles A");
		lblGolesA.setBounds(10, 10, 45, 13);
		contentPane.add(lblGolesA);
		
		txtGolesA = new JTextField();
		txtGolesA.setBounds(72, 7, 96, 19);
		contentPane.add(txtGolesA);
		txtGolesA.setColumns(10);
		
		lblGolesB = new JLabel("Goles B");
		lblGolesB.setBounds(10, 50, 45, 13);
		contentPane.add(lblGolesB);
		
		txtGolesB = new JTextField();
		txtGolesB.setBounds(72, 47, 96, 19);
		contentPane.add(txtGolesB);
		txtGolesB.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 75, 371, 178);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(296, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(296, 46, 85, 21);
		contentPane.add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		//DECLARACION DE VARIABLE
		int golesA,golesB;
		String resultado = null;
		//Entrada de datos
		golesA = Integer.parseInt(txtGolesA.getText());
		golesB = Integer.parseInt(txtGolesB.getText());
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
	}
}
