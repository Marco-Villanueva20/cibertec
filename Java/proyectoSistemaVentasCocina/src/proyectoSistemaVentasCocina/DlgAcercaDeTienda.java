package proyectoSistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DlgAcercaDeTienda extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JLabel lblLineaHorizontal;
	private JLabel lblAutores;
	private JLabel lblNombreIntegrante;
	private JButton btnCerrar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAcercaDeTienda dialog = new DlgAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaDeTienda() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(119, 136, 153));
		setTitle("Acerca De Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setForeground(new Color(255, 250, 250));
		lblTienda.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setBounds(99, 10, 230, 27);
		contentPanel.add(lblTienda);
		
		lblLineaHorizontal = new JLabel("");
		lblLineaHorizontal.setForeground(new Color(240, 255, 255));
		lblLineaHorizontal.setBounds(0, 59, 436, 13);
		contentPanel.add(lblLineaHorizontal);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setForeground(new Color(240, 248, 255));
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblAutores.setBounds(160, 82, 109, 13);
		contentPanel.add(lblAutores);
		
		lblNombreIntegrante = new JLabel("Villanueva Soto Marco Antonio");
		lblNombreIntegrante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreIntegrante.setForeground(new Color(240, 255, 255));
		lblNombreIntegrante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreIntegrante.setBounds(99, 123, 239, 13);
		contentPanel.add(lblNombreIntegrante);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 250, 205));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(184, 180, 85, 21);
		contentPanel.add(btnCerrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\Documents\\COMPUTACION E INFORMATICA\\INTRODUCCI\u00D3N A LA ALGORITMIA\\Semana 5 Repe\\LABORATORIO\\PROYECTO\\proyectoSistemaVentasCocina\\src\\imagen\\imagen.png"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPanel.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
