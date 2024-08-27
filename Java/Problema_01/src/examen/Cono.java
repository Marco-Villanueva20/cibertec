package examen;

public class Cono {
	//atributos
	private double radio;
	private double generatriz;
		//METODOS
	//Constructor
		public Cono() {
		}
		//Constructor
		public Cono(double rad, double gen) {
			radio = rad;
			generatriz = gen;
		}
		//Métodos de acceso set/get 
		//set
		public void  setRadio(double rad) {
			radio = rad;
		}
		public void  setGeneratriz(double gen) {
			generatriz = gen;
		}
		//get
		public double getRadio() {
			return radio;
		}
		public double getGeneratriz() {
			return generatriz;
		}
		//area total
		public double area() {
			return 3.1416 * radio *(radio + generatriz);
		}
}
