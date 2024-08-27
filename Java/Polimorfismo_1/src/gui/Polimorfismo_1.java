package gui;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import herencia.Animal;
import herencia.Mamifero;
import herencia.Perro;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Polimorfismo_1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Polimorfismo_1 frame = new Polimorfismo_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Polimorfismo_1() {
		setTitle("Polimorfismo_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 110, 486, 293);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("P R O C E S A R");
		btnProcesar.addActionListener(this);
		btnProcesar.setFont(new Font("Arial", Font.BOLD, 16));
		btnProcesar.setBounds(28, 54, 486, 45);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		procesar();
	}
	
	//  Métodos tipo void (sin parámetros)
    void procesar() {
		//  Upcasting
		Object    oa = new Animal();
		Object    om = new Mamifero();
		Object    op = new Perro();
		Animal    am = new Mamifero();
		Animal    ap = new Perro();
		Mamifero  mp = new Perro();

		imprimir("U P C A S T I N G");
	
		imprimir(">>> Objeto am");
		imprimir("hacer ruido :  " + am.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto ap");
		imprimir("hacer ruido :  " + ap.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto mp");
		imprimir("mensaje     :  " + mp.mensaje());
		imprimir("hacer ruido :  " + mp.hacerRuido());
		imprimir("");

		//  Downcasting
/*		Animal    ao = (Animal) oa;
		Mamifero  mo = (Mamifero) om;
		Perro     po = (Perro) op;
		Mamifero  ma = (Mamifero) am;
		Perro     pa = (Perro) ap;
		Perro     pm = (Perro) mp;

		imprimir("D O W N C A S T I N G");
		imprimir(">>> Objeto ao");
		imprimir("hacer ruido :  " + ao.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto mo");
		imprimir("mensaje     :  " + mo.mensaje());
		imprimir("hacer ruido :  " + mo.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto po");
		imprimir("mensaje     :  " + po.mensaje());
		imprimir("hacer ruido :  " + po.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto ma");
		imprimir("mensaje     :  " + ma.mensaje());
		imprimir("hacer ruido :  " + ma.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto pa");
		imprimir("mensaje     :  " + pa.mensaje());
		imprimir("hacer ruido :  " + pa.hacerRuido());
		imprimir("");

		imprimir(">>> Objeto pm");
		imprimir("mensaje     :  " + pm.mensaje());
		imprimir("hacer ruido :  " + pm.hacerRuido());
		imprimir("");

		Animal  aa = new Animal();*/
		//  No se puede convertir un objeto Animal
		//  en un objeto Perro. ERROR

		//  Perro   pp = (Perro) aa;
    }

	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
 
 
}
