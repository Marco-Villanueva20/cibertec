package semana_1;
import examen.Corona;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Problema_1 extends JFrame implements ActionListener {

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
					Problema_1 frame = new Problema_1();
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
	public Problema_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 397, 324);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		txtS.setEditable(false);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(160, 39, 85, 21);
		contentPane.add(btnProcesar);
	}

		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Cree un objeto Corona 
		Corona c = new Corona();
		//Asignar datos fijos
		c.setRadioMayor(20);
		c.setRadioMenor(10);
		//Obtener y Mostrar los datos del objeto
		listadoCorona(c);
		
		//Incremente el radio mayor 15% y el radio menor en 30%.
		c.setRadioMayor(c.getRadioMayor() + c.getRadioMayor() * 0.15);
		c.setRadioMenor(c.getRadioMenor() + c.getRadioMenor() * 0.30);
		//Muestre nuevamente todos los datos del objeto 
		listadoCorona(c);
	}
	//METODOS VOID CON PARAMETRO
	void imprimir (String s) {
		txtS.append(s + "\n");
	}
	void listadoCorona(Corona cel) {
		imprimir("Radio Mayor : "+cel.getRadioMayor());
		imprimir("Radio Menor : "+cel.getRadioMenor());
		imprimir("Area total      : "+cel.area());
		imprimir("");
	}
	}


