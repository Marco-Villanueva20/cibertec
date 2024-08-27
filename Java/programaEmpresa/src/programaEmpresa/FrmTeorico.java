package programaEmpresa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmTeorico extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblDineroRepartir;
	private JTextField txtDineroRepartir;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	//FORMATEAR DECIMALES
	DecimalFormat df = new DecimalFormat("0.00");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTeorico frame = new FrmTeorico();
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
	public FrmTeorico() {
		setTitle("UNIVERSIDAD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDineroRepartir = new JLabel("Dinero a repartir :");
		lblDineroRepartir.setBounds(10, 23, 105, 13);
		contentPane.add(lblDineroRepartir);
		
		txtDineroRepartir = new JTextField();
		txtDineroRepartir.setBounds(123, 20, 96, 19);
		contentPane.add(txtDineroRepartir);
		txtDineroRepartir.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(315, 6, 85, 21);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(315, 43, 85, 21);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 82, 416, 171);
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
		double cant,ingElec,ingEco,ingSis,ingCiv,ingMin;
		//ENTRADA DE DATOS
		try {
			cant = Double.parseDouble(txtDineroRepartir.getText());
			//VALIDACION
			if(cant <= 0){
				JOptionPane.showMessageDialog(this, "INGRESAR VALORES MAYORES A 0","Error!",0);
				txtDineroRepartir.setText("");
				txtS.setText("");
				txtDineroRepartir.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "INGRESAR VALORES NUMERICOS","Error!",0);
			txtDineroRepartir.setText("");
			txtS.setText("");
			txtDineroRepartir.requestFocus();
			return;
		}
		//PROCESO DE CALCULO
	//IMPORTES DE DONACION
		ingCiv = cant * 0.25;
		ingSis = ingCiv * 0.17;
		ingEco =  (ingSis + ingCiv) * 0.05;
		ingElec = ingEco * 0.35;
		ingMin = cant - (ingCiv + ingSis + ingEco + ingElec);
		//SALIDA DE DATOS;
		txtS.setText("DINERO QUE LE CORRESPONDE POR FACULTAD" +"\n"+"\n");
		txtS.append("Ingenieria Civil              : S/. " + df.format(ingCiv) + "\n");    
		txtS.append("Ingenieria de Sistemas :S/. " + df.format(ingSis) + "\n");
		txtS.append("Ingenieria Económica   :S/. " + df.format(ingEco) + "\n");
		txtS.append("Ingenieria Electrónica   :S/. " + df.format(ingElec) + "\n");
		txtS.append("Ingenieria de Minas       :S/. " + df.format(ingMin) );
		
	}
}
