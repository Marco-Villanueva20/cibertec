package programaPrueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FrmPrueba extends JFrame {
	//componente
	private JPanel contentPane;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JLabel lblEdad;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JButton btnGuardar;
	private JButton btnCerrar;
	private JLabel lblPeso;
	private JTextField txtPeso;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrueba frame = new FrmPrueba();
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
	public FrmPrueba() {
		setTitle("Registros de personas - Villanueva Soto Marco A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 10, 60, 13);
		contentPane.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(67, 7, 96, 19);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 43, 60, 13);
		contentPane.add(lblApellidos);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 75, 45, 13);
		contentPane.add(lblEdad);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(67, 40, 96, 19);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(67, 72, 96, 19);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(286, 6, 85, 21);
		contentPane.add(btnGuardar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(286, 71, 85, 21);
		contentPane.add(btnCerrar);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 111, 45, 13);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(67, 108, 96, 19);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(286, 39, 85, 21);
		contentPane.add(btnNuevo);
	}
}
