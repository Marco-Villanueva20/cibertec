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
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ReportexFecha extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tbUsuario;
	private JButton btnReporte;
	DefaultTableModel model = new DefaultTableModel();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	private JDateChooser dcFecNac;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportexFecha frame = new ReportexFecha();
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
	public ReportexFecha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportePorFecha = new JLabel("Reporte de Usuario por Fecha de Nacimiento");
		lblReportePorFecha.setBounds(10, 23, 239, 30);
		contentPane.add(lblReportePorFecha);
		
		JLabel lblFechaProd = new JLabel("Fecha Nac:");
		lblFechaProd.setBounds(10, 64, 65, 14);
		contentPane.add(lblFechaProd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 102, 336, 122);
		contentPane.add(scrollPane);
		
		tbUsuario = new JTable();
		scrollPane.setViewportView(tbUsuario);
		tbUsuario.setFillsViewportHeight(true);
		tbUsuario.setModel(model);
		
		btnReporte = new JButton("REPORTE");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(151, 232, 111, 21);
		contentPane.add(btnReporte);
		
		dcFecNac = new JDateChooser();
		dcFecNac.setBounds(81, 59, 121, 19);
		contentPane.add(dcFecNac);
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("Fecha de Nacimiento");
		model.addColumn("Tipo");
		model.addColumn("Estado");
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		String fecha;
		// paso 1 --> obtener el codigo ingresado
		fecha = getCodigo();
		// paso 2 --> validar que el codigo ingresado responda al formato
		if (fecha == null) {
			return;
		} else {			
				model.setRowCount(0);
				// 2 Llamar al proceso de consulta
				ArrayList<Usuario> lista = gUser.listarUsuarioxFecha(fecha);
				// crear un bucle para el recorrido
				for (Usuario u : lista) {
					// Crear un arreglo
					Object fila[] = {u.getCodigo(),u.getNombre(),u.getApellido(),u.getUsuario(),u.getClave(),u.getFechNacimiento(),u.getTipo(),u.getEstado()};
					// añadir la fila a la tabla
					model.addRow(fila);
					}
			}
	}

	private String getCodigo() {
		String codigo;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		codigo = sdf.format(dcFecNac.getDate());
		return codigo;
	}
}