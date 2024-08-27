package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.ReporteTipoUsuario;
import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Reporte3 extends JFrame implements ActionListener {

	GestionTipoUsuarioDAO gTip = new GestionTipoUsuarioDAO();
	private JPanel contentPane;
	private JComboBox cboTipo;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	GestionUsuarioDAO gUser = new  GestionUsuarioDAO();
	private JButton btnReporte;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte3 frame = new Reporte3();
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
	public Reporte3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		lblListadoDeUsuarios.setBounds(24, 11, 194, 26);
		contentPane.add(lblListadoDeUsuarios);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 414, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 44, 46, 14);
		contentPane.add(lblTipo);

		table.setModel(model);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(66, 41, 157, 20);
		contentPane.add(cboTipo);
		
		btnReporte = new JButton("REPORTE");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(138, 239, 140, 21);
		contentPane.add(btnReporte);
		
		model.addColumn("Código");
		model.addColumn("Nombre Completo");
		model.addColumn("Descripcion");
		
		cargarDataCbo();

		
	}

	protected int getCodigo() {
		int codigo;
		codigo = cboTipo.getSelectedIndex();
		return codigo;
	}

	private void cargarDataCbo() {
		//llamar al proceso de consulta
		ArrayList<TipoUsuario> lista = gTip.listarTipoUsuario();
		// 2 validar
		if(lista.size() == 0 ) {
			Mensaje.error("Lista Vacia");
		}else {
			cboTipo.addItem("Seleccione ...");
			for(TipoUsuario tipoUser : lista) {
				cboTipo.addItem(tipoUser.getIdTipo()+ " - "+tipoUser.getDescripTipo());
			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		int codigo;
		// paso 1 --> obtener el codigo ingresado
		codigo = getCodigo();
		// paso 2 --> validar que el codigo ingresado responda al formato
		if (codigo == -1) {
		    return;
		} else {
		    // llamar al proceso de busqueda
		    ArrayList<ReporteTipoUsuario> lista = gUser.listarReporteUsuario(codigo);
		    // validar el resultado del proceso
		    if (lista.size()==0) {
		        Mensaje.error("No se encontraron usuarios");
		    } else {
		        for (ReporteTipoUsuario u : lista) {
		            Object fila[] = {
		            u.getCodigo(),
		            u.getNomCompleto(),u.getDescripTipoUsuario()
		            };
		            model.addRow(fila);
		            }
		        }
		    }
	}
}