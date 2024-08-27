package programaTransporte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Mensajes;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class frmEmpresa extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTurno;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTurno;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	//DECIMAL
	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmpresa frame = new frmEmpresa();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //PARA QUE EL CUADRO SALGA EN EL MEDIO/CENTRAR FRM
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public frmEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTurno = new JLabel("Turno     :");
		lblTurno.setBounds(10, 10, 57, 13);
		contentPane.add(lblTurno);
		
		cboTurno = new JComboBox();
		cboTurno.setModel(new DefaultComboBoxModel(new String[] {"Ma\u00F1ana", "Tarde", "Noche"}));
		cboTurno.setBounds(89, 6, 112, 21);
		contentPane.add(cboTurno);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 56, 57, 13);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(89, 54, 112, 16);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 416, 149);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(341, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(341, 52, 85, 21);
		contentPane.add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//DECLARACION DE VARIABLE
		int turno ,cantPasj,obs;
		double impPag;
		//ENTRADA DE DATOS
		turno = getTurno();
		try {
			cantPasj = getCantidadPasajes();
			if(cantPasj <= 0) {
				Mensajes.mensajeError("INGRESE VALORES MAYORES A 0");
				actionPerformedBtnBorrar(e);
				return;
				
			}
		} catch (Exception e1) {
			Mensajes.mensajeError("INGRESE VALORES NUMERICOS");
			actionPerformedBtnBorrar(e);
			return;
		}
		//PROCESO DE CALCULO
		impPag = calcImpPagar(turno,cantPasj);
		obs = calcObsequio(cantPasj);
		//SALIDA DE RESULTADOS
		mostrarResultados(impPag,obs);
		
		
	}

	private void mostrarResultados(double impPag, int obs) {
		txtS.setText("IMPORTE A PAGAR : S/. "+df.format(impPag)+"\n");
		imprimir("OBSEQUIO	 : "+obs+" Caramelos ");
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	private int calcObsequio(int cantPasj) {
		if(cantPasj > 10)
			return cantPasj * 4;
		if(cantPasj > 5)
			return cantPasj * 3;
		else
			return cantPasj * 2;
	}

	private double calcImpPagar(int turno, int cantPasj) {
		switch (turno) {
		case 0:
			return cantPasj * 30;
		case 1:
			return cantPasj * 35;
		default:
			return cantPasj * 42.50;
		}
	}

	private int getCantidadPasajes() {
		return Integer.parseInt(txtCantidad.getText());
		
	}

	private int getTurno() {
		return cboTurno.getSelectedIndex();
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		cboTurno.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}

//PAGINA 246 MANUAL
