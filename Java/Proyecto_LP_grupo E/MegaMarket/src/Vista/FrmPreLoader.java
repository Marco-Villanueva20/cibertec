package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.HiloBarraProgreso;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPreLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblSpinner;

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
		setBounds(100, 100, 354, 255);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(15, 186, 313, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 5, 313, 14);
		contentPane.add(lblMensajes);
		
		lblSpinner = new JLabel("");
		lblSpinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpinner.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/Spin-1s-200px.gif")));
		lblSpinner.setBounds(48, 30, 241, 145);
		contentPane.add(lblSpinner);
		cargarBarraProgreso();
	}
	private void cargarBarraProgreso() {
		//llamar al proceso
		HiloBarraProgreso h = new HiloBarraProgreso();
		//ejecute el proceso
		h.start();
	}
	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent e) {
		abrirVentanaPrincipal();
	}

	private void abrirVentanaPrincipal() {
		if(prbCarga.getValue() == 100) {
			frmPrincipal prin = new frmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			this.dispose();
		}
		
	}
}
