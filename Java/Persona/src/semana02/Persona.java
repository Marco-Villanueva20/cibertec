package semana02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Persona extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombresApellidos;
	private JLabel lblAnoNacimiento;
	private JTextField txtNombresApellidos;
	private JTextField txtAnoNacimiento;
	private JButton btnBorrar;
	private JScrollPane scp;
	private JTextArea txtS;
	private JLabel lblPesoKilogramos;
	private JTextField txtPesoKilogramos;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona frame = new Persona();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Persona() {
		setTitle("Persona (Villanueva Soto Marco Antonio)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(100, 100, 450, 285));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombresApellidos = new JLabel("Nombres y apellidos");
		lblNombresApellidos.setBounds(10, 11, 106, 14);
		contentPane.add(lblNombresApellidos);

		lblAnoNacimiento = new JLabel("A\u00F1o de nacimiento");
		lblAnoNacimiento.setBounds(10, 36, 106, 14);
		contentPane.add(lblAnoNacimiento);

		txtNombresApellidos = new JTextField();
		txtNombresApellidos.setBounds(126, 8, 126, 20);
		contentPane.add(txtNombresApellidos);
		txtNombresApellidos.setColumns(10);

		txtAnoNacimiento = new JTextField();
		txtAnoNacimiento.setBounds(126, 33, 126, 20);
		contentPane.add(txtAnoNacimiento);
		txtAnoNacimiento.setColumns(10);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 89, 414, 148);
		contentPane.add(scp);

		txtS = new JTextArea();
		scp.setViewportView(txtS);

		lblPesoKilogramos = new JLabel("Peso en kilogramos");
		lblPesoKilogramos.setBounds(10, 61, 106, 14);
		contentPane.add(lblPesoKilogramos);

		txtPesoKilogramos = new JTextField();
		txtPesoKilogramos.setBounds(126, 58, 126, 20);
		contentPane.add(txtPesoKilogramos);
		txtPesoKilogramos.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}

	// Procesa la pulsacion del boton Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	
	}

	// Procesa la pulsaci�n del bot�n Procesar
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		String nombresApellidos;
		int anoNacimiento;
		double pesoKilogramos;
		//entrada de datos
		
		nombresApellidos = txtNombresApellidos.getText();
		anoNacimiento = Integer.parseInt(txtAnoNacimiento.getText());
		pesoKilogramos = Double.parseDouble(txtPesoKilogramos.getText());
		
		//proceso de calculo -- no hay
		//salida de resultados
		txtS.setText("DATOS INGRESADOS \n\n");
		txtS.append("Nombres y Apellidos 	: "+ nombresApellidos + "\n");
		txtS.append("Anho de Nacimiento 	: "+ anoNacimiento + "\n");
		txtS.append("Peso en Kilogramos 	: " + pesoKilogramos +  " \n" );
		
		
				
	}
}
