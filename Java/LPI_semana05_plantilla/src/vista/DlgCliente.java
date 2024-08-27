package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.ReporteIdUsuario;
import entidad.ReporteTipoUsuario;
import mantenimiento.GestionUsuarioDAO;
import utils.Mensaje;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbCliente;
	private JScrollPane scrollPane;
	
	GestionUsuarioDAO gUsuario = new GestionUsuarioDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 212);
		contentPanel.add(scrollPane);
		
		tbCliente = new JTable();
		tbCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbCliente);
		
		
		model.addColumn("Código");
		model.addColumn("Nombres Completos");
		tbCliente.setModel(model);
		listarClientes();
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void listarClientes() {
		//limpiar tabla
		model.setRowCount(0);
		// Obtenere el resultado del proceso
		ArrayList<ReporteTipoUsuario> lista = gUsuario.listarReporteUsuario(2);
		if(lista.size()==0) {
			Mensaje.error("Lista Vacía");
		}else {
			for(ReporteTipoUsuario repUsuario : lista) {
				Object fila[]= {repUsuario.getCodigo(),repUsuario.getNomCompleto()};
				model.addRow(fila);
			}
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	protected void actionPerformedOkButton(ActionEvent e) {
	enviarDatos();
	}

	private void enviarDatos() {
		int fila;
	String cod,cliente;
	// Obtener el valor de la fila seleccionada
	fila = tbCliente.getSelectedRow();
	
	//obtener los datos
	cod = tbCliente.getValueAt(fila,0).toString();
	cliente = tbCliente.getValueAt(fila,1).toString();
	
	//Obtener los datos a las cajas de texto
	FrmBoleta.txtCodCliente.setText(cod);
	FrmBoleta.txtNomCompletoCliente.setText(cliente);
	//Cerrar la ventana Actual
	this.dispose();
	}
}
