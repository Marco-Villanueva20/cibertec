package utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class ColorCeldaListaEstadoMemo extends JTable {
	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,int ColumnIndex)
	{
	Component componente = super.prepareRenderer(renderer, rowIndex,ColumnIndex);	
	if( getValueAt(rowIndex, ColumnIndex) != null && getValueAt(rowIndex, ColumnIndex).getClass().equals(String.class)) {
		String valor = this.getValueAt(rowIndex, ColumnIndex).toString();
		if(valor.equalsIgnoreCase("pendiente")) {
			componente.setBackground(Color.RED);
			componente.setForeground(Color.WHITE);
		}
		else if(valor.equalsIgnoreCase("revisado")||valor.equalsIgnoreCase("aprobado")||valor.equalsIgnoreCase("asignado")) {
			componente.setBackground(Color.ORANGE);
			componente.setForeground(Color.WHITE);
		}
		else if(valor.equalsIgnoreCase("finalizado")) {
			componente.setBackground(Color.CYAN);
			componente.setForeground(Color.BLACK);
		}
		else if(valor.equalsIgnoreCase("rechazado")) {
			componente.setBackground(Color.BLACK);
			componente.setForeground(Color.WHITE);
		}
		else {
			componente.setBackground(Color.WHITE);
			componente.setForeground(Color.BLACK);
		}
	}
	return componente;
	}
}
