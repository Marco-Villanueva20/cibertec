package vista;

import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class FrmRptVtas extends JInternalFrame implements ActionListener {
	private JDateChooser dcFecha;
	private JTextField txtFechaActual;
	private JLabel lblNewLabel_1;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnReporte;
	
	//fecha actual
	Date fecha = new Date();
	//dandole formato a la fecha
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVtas frame = new FrmRptVtas();
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
	public FrmRptVtas() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 215, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDel = new JLabel("Fecha Fin:");
		lblDel.setBounds(30, 77, 71, 19);
		getContentPane().add(lblDel);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(302, 60, 89, 23);
		getContentPane().add(btnReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 106, 408, 142);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(111, 77, 114, 19);
		getContentPane().add(dcFecha);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaActual.setEditable(false);
		txtFechaActual.setBounds(111, 48, 114, 19);
		getContentPane().add(txtFechaActual);
		txtFechaActual.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Fecha Inicio:");
		lblNewLabel_1.setBounds(20, 51, 89, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtFechaActual.setText(sdf.format(fecha));
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		String fechaInicio;
		String fechaFin;
		
		fechaInicio = txtFechaActual.getText();
		fechaFin = sdf.format(dcFecha.getDate());
		
		
		txtS.setText("");
		txtS.append("Fecha de inicio: "+fechaInicio+"\n");
		txtS.append("Fecha de fin: "+fechaFin);
		
		
	}
}
