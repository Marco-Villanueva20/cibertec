package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Producto;
import mantenimiento.GestionProductoDAO;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.GenerarReporte;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class FrmLstProductos extends JFrame {

	private JPanel contentPane;
	GestionProductoDAO gProd = new GestionProductoDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstProductos frame = new FrmLstProductos();
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
	public FrmLstProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listado de Productos");
		lblTitulo.setBounds(22, 11, 183, 24);
		contentPane.add(lblTitulo);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al método
				listado();
			}
		});
		btnListado.setBounds(88, 377, 194, 46);
		contentPane.add(btnListado);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
		btnPdf.setBounds(457, 377, 177, 46);
		contentPane.add(btnPdf);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panelReporte.setBounds(22, 58, 1009, 309);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	private JPanel panelReporte;
	
	void imprimePDF() {
		listado();
	}
	
	
	
	void listado(){
		ArrayList<Producto> listProd = gProd.listarProductos();
		try {
			//paso 1 obtener datos
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(listProd);
			
			//paso 2 el diseño del reporte
			String fileName = "reportes/reporte_productos.jasper";
			
			//paso 3 generar el reporte
			JasperPrint jasPrint = GenerarReporte.generar(fileName, data, null);
			// 4 mostrar el reporte
			JRViewer jvi = new JRViewer(jasPrint);
			panelReporte.removeAll();
			panelReporte.add(jvi);
			panelReporte.repaint();
			panelReporte.revalidate();
		} catch (Exception e) {
			System.out.println("Error al generar reporte "+e.getMessage());
		}
	}
}


