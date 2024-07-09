package semana_07;

public class ArregloNotas {

	//  Atributos privados
	private int[] nota;
	private int indice;
	//  Constructor
	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamaño() {
		return indice;
	}
	public int obtener(int i) {
		return nota[i];
	}
	public void adicionar(int numero) {
		if (indice == nota.length)
			ampliarArreglo();
		nota[indice] = numero;
		indice ++;
	}
	//  Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = nota;
		nota = new int[indice + 10];
		for (int i=0; i<indice; i++)
			nota[i] = aux[i];
	}
	
}
