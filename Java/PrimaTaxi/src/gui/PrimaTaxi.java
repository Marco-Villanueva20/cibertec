package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PrimaTaxi extends JFrame {
    
	    private static final long serialVersionUID = 1L;

    private JPanel contentPane;  
    private JLabel lblFondo;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrimaTaxi frame = new PrimaTaxi();
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
     public PrimaTaxi() {
         final int ANCHO = 786, ALTO = 425, 
                   DX = 6, DY = 29;

         setResizable(false);
         setTitle("PrimaTaxi SAC \u00AE");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(0, 0, ANCHO + DX, ALTO + DY);
         this.setIconImage(new ImageIcon("PT.png").getImage());
         this.setLocationRelativeTo(null);
         
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);

         //  Estas tres instrucciones deben ser siempre las últimas
         lblFondo = new JLabel(new ImageIcon("PrimaTaxi.png"));
         lblFondo.setBounds(0, 0, ANCHO, ALTO);
         contentPane.add(lblFondo);         
     }
}
