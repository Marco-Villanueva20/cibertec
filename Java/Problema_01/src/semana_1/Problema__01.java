package semana_1;
import examen.Cono;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.Corona;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Problema__01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema__01 frame = new Problema__01();
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
	public Problema__01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 131, 378, 339);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(175, 48, 85, 21);
		contentPane.add(btnProcesar);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Cree un objeto Cono
		Cono c = new Cono();
		//Asignar datos fijos
		c.setRadio(20);
		c.setGeneratriz(10);
		//Obtener y Mostrar los datos del objeto
		listadoCono(c);
		
		//Incremente el radio mayor 10% y el radio menor en 25%.
		c.setRadio (c.getRadio() + c.getRadio() * 0.10);
		c.setGeneratriz (c.getGeneratriz() + c.getGeneratriz() * 0.25);
		//Muestre nuevamente todos los datos del objeto 
		listadoCono(c);
	}
	//METODOS VOID CON PARAMETRO
	void imprimir (String s) {
		txtS.append(s + "\n");
	}
	void listadoCono(Cono cel) {
		imprimir("Radio         : "+cel.getRadio());
		imprimir("Generatriz : "+cel.getGeneratriz());
		imprimir("Area total   : "+cel.area());
		imprimir("");
	}
}
