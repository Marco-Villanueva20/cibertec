package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloCarga;
import hilos.HiloTiempo;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPreLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 308);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 23, 313, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 5, 313, 14);
		contentPane.add(lblMensajes);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/Carga.gif")));
		lblNewLabel.setBounds(43, 52, 199, 209);
		contentPane.add(lblNewLabel);
		
		//metodo  para iniciar el conteo en la barra de progreso
		iniciarBarraProgreso();
	}

	private void iniciarBarraProgreso() {
		//--> 0 hasta el 100;
		HiloCarga h = new HiloCarga(prbCarga);
		h.start();
		
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent e) {
		//1.validar si la barra de progreso tiene el valor de 100
		if(prbCarga.getValue() == 100) {
			//instanciar un objeto de tipo FrmPrincipal
			FrmPrincipal prin = new FrmPrincipal();
			//objeto visible
			prin.setVisible(true);
			//ubicacion
			prin.setLocationRelativeTo(this);
			prin.setExtendedState(Frame.MAXIMIZED_BOTH);
			//cerrar la ventana actual(barra de progreso)
			this.dispose();
		}
	}
}
