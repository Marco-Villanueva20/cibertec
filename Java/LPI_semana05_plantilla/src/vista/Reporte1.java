package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Usuario;
import mantenimiento.GestionUsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Reporte1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	DefaultTableModel model = new DefaultTableModel();
	private JTable tbUsuarios;
	private JButton btnReporte;
	
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte1 frame = new Reporte1();
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
	public Reporte1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDeUsuarios = new JLabel("Listado de Usuarios");
		lblListadoDeUsuarios.setBounds(24, 11, 194, 26);
		contentPane.add(lblListadoDeUsuarios);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(172, 236, 89, 23);
		contentPane.add(btnReporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 176);
		contentPane.add(scrollPane);
		
		tbUsuarios = new JTable();
		tbUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuarios);
		
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Id Usuario");
		
		tbUsuarios.setModel(model);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		mostrarListado();
	}

	private void mostrarListado() {
		model.setRowCount(0);

		ArrayList<Usuario> listaUser = gUser.listarUsuario();
		// validar el resultado de l consulta
		if (listaUser.size() == 0) {
			mensajeError("Lista Vacía");
		} else {
			for (Usuario usuario : listaUser) {
				Object fila[] = { usuario.getCodigo(), usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(),
						usuario.getTipo() };
				model.addRow(fila);
			}

		}
		}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Error",0 );
		
	}
		

				
		
	}
