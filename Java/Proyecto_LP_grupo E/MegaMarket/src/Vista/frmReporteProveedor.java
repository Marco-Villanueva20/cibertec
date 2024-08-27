package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;

public class frmReporteProveedor extends JInternalFrame {
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JLabel lblProveedor;
	private JComboBox comboBox;
	private JTextArea textArea;
	private frmPrincipal frmPrincipal;
	private JButton btnReporte;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReporteProveedor frame = new frmReporteProveedor();
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
	public frmReporteProveedor() {
		setClosable(true);
		setBounds(100, 100, 591, 483);
		getContentPane().setLayout(null);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 66, 46, 14);
		getContentPane().add(lblDesde);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(265, 66, 46, 14);
		getContentPane().add(lblHasta);
		
		lblProveedor = new JLabel("Seleccione Proveedor:");
		lblProveedor.setBounds(10, 115, 122, 14);
		getContentPane().add(lblProveedor);
		
		comboBox = new JComboBox();
		comboBox.setBounds(142, 111, 163, 22);
		getContentPane().add(comboBox);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 144, 555, 298);
		getContentPane().add(textArea);
		
		btnReporte = new JButton("Generar reporte");
		btnReporte.setBounds(422, 111, 143, 22);
		getContentPane().add(btnReporte);
		
		lblNewLabel = new JLabel("Reporte de pedidos por proveedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(169, 11, 264, 27);
		getContentPane().add(lblNewLabel);

	}

	public void setFrmPrincipal(frmPrincipal frmPrincipal) {
		this.frmPrincipal = frmPrincipal;	
	}
}
