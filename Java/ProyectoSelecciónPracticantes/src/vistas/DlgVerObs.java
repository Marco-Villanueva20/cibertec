package vistas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class DlgVerObs extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	public static JTextArea txtObs;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVerObs dialog = new DlgVerObs();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVerObs() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgVerObs.class.getResource("/img/lupa.png")));
		setType(Type.POPUP);
		setTitle("OBSERVACIONES");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 10, 416, 212);
			contentPanel.add(scrollPane);
			{
				txtObs = new JTextArea();
				scrollPane.setViewportView(txtObs);
				txtObs.setEditable(false);
				txtObs.setLineWrap(true);
				txtObs.setFont(new Font("Monospaced", Font.PLAIN, 13));
			}
		}
		okButton = new JButton("OK");
		okButton.setBounds(186, 232, 84, 20);
		contentPanel.add(okButton);
		okButton.addActionListener(this);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				buttonPane.setLayout(null);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		this.dispose();
	}
}
