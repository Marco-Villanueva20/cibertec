package guis;

import clases.*;
import arreglos.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgAtencionesPagadas extends JDialog {
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAtencionesPagadas dialog = new DlgAtencionesPagadas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgAtencionesPagadas() {
		setResizable(false);
		setTitle("Reporte | Atenciones pagadas");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 675, 345);
		getContentPane().add(scrollPane);
	
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);
		
		listar();
	}
	
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	void listar() {
		ArregloAtenciones aa = new ArregloAtenciones();
		ArregloPacientes ap = new ArregloPacientes();
		Atencion a;
		Paciente p;
		txtS.setText("");
		for (int i=0; i<aa.tamaño(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 1) {
				p = ap.buscar(a.getCodigoPaciente());
				imprimir("Código de atención :  " + a.getCodigoAtencion());
				imprimir("Código de paciente :  " + a.getCodigoPaciente());
				imprimir("Nombres            :  " + p.getNombres());
				imprimir("Apellidos          :  " + p.getApellidos());
				imprimir("Fecha de atención  :  " + a.getFechaAtencion()
				                                  + " - " + a.getHoraAtencion());
				imprimir("Total pagado       :  S/ " + formato(a.getApagar()));
				imprimir();
			}
		}
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  Métodos que retornan valor (con parámetros)
	String formato(double real) {
		return String.format(Locale.US, "%-10.2f", real);
	}
	
}