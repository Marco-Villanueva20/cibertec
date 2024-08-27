package programaDonacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FrmDonacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox cboMoneda;
	private JLabel lblMoneda;
	private JLabel lblCantidad;
	private JTextField textCantidad;
	private JButton btnDonar;
	private JButton btnBorrar;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDonacion frame = new FrmDonacion();
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
	public FrmDonacion() {
		setTitle("Donacion (Marco Antonio Villanueva Soto)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboMoneda = new JComboBox();
		cboMoneda.setModel(new DefaultComboBoxModel(new String[] {"Soles", "Dolares", "Euros"}));
		cboMoneda.setBounds(115, 26, 103, 21);
		contentPane.add(cboMoneda);
		
		lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(10, 26, 64, 17);
		contentPane.add(lblMoneda);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 80, 81, 13);
		contentPane.add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(122, 77, 96, 19);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		btnDonar = new JButton("Donar");
		btnDonar.addActionListener(this);
		btnDonar.setBounds(301, 26, 85, 21);
		contentPane.add(btnDonar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(301, 76, 85, 21);
		contentPane.add(btnBorrar);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 124, 376, 129);
		contentPane.add(textArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDonar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
