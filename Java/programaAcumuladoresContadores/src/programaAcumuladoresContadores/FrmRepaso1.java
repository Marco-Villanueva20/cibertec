package programaAcumuladoresContadores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmRepaso1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cboProducto;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRepaso1 frame = new FrmRepaso1();
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
	public FrmRepaso1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 20, 45, 13);
		contentPane.add(lblProducto);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 62, 45, 13);
		contentPane.add(lblCantidad);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(341, 16, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(341, 58, 85, 21);
		contentPane.add(btnBorrar);
		
		cboProducto = new JComboBox();
		cboProducto.setBounds(88, 16, 92, 17);
		contentPane.add(cboProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(88, 59, 96, 19);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 416, 152);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
}
