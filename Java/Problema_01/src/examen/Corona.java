package examen;

public class Corona {
	//ATRIBUTOS
	private double radioMayor;
	private double radioMenor;
			//METODOS
		//Constructor
	public Corona() {
	}
	
	public Corona(double radMayor,double radMenor){
		radioMayor = radMayor;
		radioMenor = radMenor;
	}
		//Métodos de acceso set/get 
	//set
	public void  setRadioMayor(double radMayor) {
		radioMayor = radMayor;
	}
	
	public void  setRadioMenor(double radMenor) {
		radioMenor = radMenor;
	}
	
	//get
	public double getRadioMayor() {
		return radioMayor;
	}
	public double getRadioMenor() {
		return radioMenor;
	}
	//Metodo adicional
	public double area() {
		return 3.1416 * ( radioMayor * radioMayor + radioMenor * radioMenor );
	}
}
