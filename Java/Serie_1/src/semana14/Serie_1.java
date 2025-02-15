package semana14;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;

public class Serie_1 extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JButton btnProcesar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serie_1 frame = new Serie_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Serie_1() {
		setTitle("Serie_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 491);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(123, 7, 89, 23);
		contentPane.add(btnProcesar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 41, 315, 400);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//DECLARACION DE VARIABLE
		int num = 3, suma = 0, cont = 0;
		//LIMPIAR PANTALLA
		txtS.setText("");
		//GENERAMOS BUCLE
		while (cont < 20) {
			//IMPRIMA LA SERIE
			imprimir(""+num);
			//acumular el valor de la serie
			suma += num;
			//INCREMENTAR EL VALOR DE LA SERIE
			num += 6;
			//INCREMENTAR AL CONTADOR
			cont ++;
		}
		imprimir("SUMA : "+suma);
		
	}

	private void imprimir(String cad) {
		txtS.append(cad+"\n");
		
	}
}