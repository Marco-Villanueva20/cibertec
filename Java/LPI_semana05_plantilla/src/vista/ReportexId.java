package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.ReporteIdProducto;
import entidad.ReporteIdUsuario;
import entidad.Usuario;
import mantenimiento.GestionProductoDAO;
import mantenimiento.GestionTipoProductoDAO;
import utils.Mensaje;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ReportexId extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tbProducto;
	private JTextField txtIdProd;
	private JButton btnReporte;
	DefaultTableModel model = new DefaultTableModel();
	GestionProductoDAO gProd = new GestionProductoDAO();
	GestionTipoProductoDAO gTipProd = new GestionTipoProductoDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportexId frame = new ReportexId();
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
	public ReportexId() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportePorFecha = new JLabel("Reporte de Producto por Id");
		lblReportePorFecha.setBounds(10, 23, 216, 30);
		contentPane.add(lblReportePorFecha);
		
		JLabel lblIdprod = new JLabel("Id Prod:");
		lblIdprod.setBounds(10, 64, 65, 14);
		contentPane.add(lblIdprod);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 102, 336, 122);
		contentPane.add(scrollPane);
		
		tbProducto = new JTable();
		scrollPane.setViewportView(tbProducto);
		tbProducto.setFillsViewportHeight(true);
		tbProducto.setModel(model);
		txtIdProd = new JTextField();
		txtIdProd.setBounds(85, 62, 96, 19);
		contentPane.add(txtIdProd);
		txtIdProd.setColumns(10);
		
		btnReporte = new JButton("REPORTE");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(151, 232, 111, 21);
		contentPane.add(btnReporte);
		
		model.addColumn("Nombre");
		model.addColumn("Precio");
		model.addColumn("Stock");
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		String codigo;
		// paso 1 --> obtener el codigo ingresado
		codigo = getCodigo();
		// paso 2 --> validar que el codigo ingresado responda al formato
		if (codigo == null) {
			return;
		} else {			
				model.setRowCount(0);
				// 2 Llamar al proceso de consulta
				ArrayList<ReporteIdProducto> lista = gProd.bucarProducto(codigo);
				// crear un bucle para el recorrido
				for (ReporteIdProducto r : lista) {
					// Crear un arreglo
					Object fila[] = {r.getNombre(),r.getPrecio(),r.getStock()};
					// añadir la fila a la tabla
					model.addRow(fila);
					}
			}
	}

	private String getCodigo() {
		String codigo;
		codigo = txtIdProd.getText();
		return codigo;
	}
}