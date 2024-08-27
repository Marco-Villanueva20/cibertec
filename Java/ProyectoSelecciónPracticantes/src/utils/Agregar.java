package utils;

import javax.swing.JInternalFrame;

public class Agregar {
	public static void alEscritorio(JInternalFrame internal) {
		vistas.FrmPrincipal.escritorio.add(internal);
		int x = (vistas.FrmPrincipal.escritorio.getWidth() - internal.getWidth()) / 2;
		int y = (vistas.FrmPrincipal.escritorio.getHeight() - internal.getHeight()) / 2;
		internal.setLocation(x, y);
		internal.setVisible(true);
	}
	
}
