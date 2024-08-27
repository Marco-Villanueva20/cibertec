package interfaces;

import java.util.ArrayList;

import entidad.EstadoMemo;
import entidad.Memorandum;
import entidad.ReporteMemorandum;
import entidad.ReporteVariosMemorandum;

public interface MemorandumInterfacesDAO {
	
	public int numIdMemorandum();
	public int enviarMemo(Memorandum memo , EstadoMemo estMemo);
	public ReporteMemorandum reporteMemo(int cod);
	
	public ArrayList<ReporteMemorandum> listarMemorandumx(int emisor, String codMemo,String nombreCompleto,String asunto,String fecha);
	public ArrayList<ReporteMemorandum> listarMemorandumxEmisor(int emisor);
	
	public ArrayList<ReporteVariosMemorandum> reportarVariosMemos();
	public ArrayList<ReporteVariosMemorandum> reportarVariosMemosxFecha(String fecha);
}
