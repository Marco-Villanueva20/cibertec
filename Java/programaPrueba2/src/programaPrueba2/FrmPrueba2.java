package programaPrueba2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;

public class FrmPrueba2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JTextField textNombres;
	private JTextField textMarca;
	private JTextField textPrecio;
	private JTextField textStock;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrueba2 frame = new FrmPrueba2();
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
	public FrmPrueba2() {
		setTitle("Registro de productos - Villanueva Soto Marco A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 20, 95, 20);
		contentPane.add(lblNombre);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 58, 59, 20);
		contentPane.add(lblMarca);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 96, 69, 20);
		contentPane.add(lblPrecio);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 137, 89, 20);
		contentPane.add(lblStock);
		
		textNombres = new JTextField();
		textNombres.setBounds(62, 21, 136, 19);
		contentPane.add(textNombres);
		textNombres.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(62, 59, 136, 19);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(62, 97, 69, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textStock = new JTextField();
		textStock.setBounds(62, 138, 69, 19);
		contentPane.add(textStock);
		textStock.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(286, 20, 85, 21);
		contentPane.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(286, 58, 85, 21);
		contentPane.add(btnNuevo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(286, 96, 85, 21);
		contentPane.add(btnCerrar);
	}
}
