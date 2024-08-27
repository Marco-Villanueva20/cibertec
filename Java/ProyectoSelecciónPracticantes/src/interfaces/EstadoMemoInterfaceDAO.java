package interfaces;

import java.util.ArrayList;

import entidad.EstadoMemo;
import entidad.ReporteEstadoMemo;

public interface EstadoMemoInterfaceDAO {
	
		public ArrayList<ReporteEstadoMemo> reporteEstMemo(int revision);
		public ArrayList<ReporteEstadoMemo> reporteEstMemoxCodMemo(int codMemo);
		
		public int finalizar(EstadoMemo estMemo);
		public int asignar(EstadoMemo estMemo1,EstadoMemo estMemo2);
		public int numOrdenxCodMemo(int codMemo);
}
