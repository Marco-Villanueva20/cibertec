package guis;

import libreria.Fecha;

import clases.*;
import arreglos.*;

import java.awt.EventQueue;
import java.awt.Font;

import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgInternamientosPagados extends JDialog {
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgInternamientosPagados dialog = new DlgInternamientosPagados();
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
	public DlgInternamientosPagados() {
		setResizable(false);
		setTitle("Reporte | Internamientos pagados");
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
		ArregloInternamientos ai = new ArregloInternamientos();
		ArregloPacientes ap = new ArregloPacientes();
		Internamiento i;
		Paciente p;
		txtS.setText("");
		for (int j=0; j<ai.tamaño(); j++) {
			i = ai.obtener(j);
			if (i.getEstado() == 1) {
				p = ap.buscar(i.getCodigoPaciente());
				imprimir("Código de internamiento :  " + i.getCodigoInternamiento());
				imprimir("Código de paciente      :  " + p.getCodigoPaciente());
				imprimir("Nombres                 :  " + p.getNombres());
				imprimir("Apellidos               :  " + p.getApellidos());
				imprimir("Fecha de ingreso        :  " + Fecha.enTextoFecha(i.getFechaIngreso())
				                                       + " - " + i.getHoraIngreso());
				imprimir("Fecha de salida         :  " + Fecha.enTextoFecha(i.getFechaSalida())
				                                       + " - " + i.getHoraSalida());
				imprimir("Total pagado            :  S/ " + formato(i.getTotalPagar()));
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