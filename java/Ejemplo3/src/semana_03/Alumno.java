package semana_03;

public class Alumno {

	//  Atributos privados
	private int codigo, nota1, nota2;
	private String nombre;
	//  Variable privada de clase
	private static int cantidad;
    //  Constante pública de clase 
    public static final String ENTIDAD;
	//  Bloque de inicialización
	static {
		cantidad = 0;
		ENTIDAD = "Cibertec";
	}	
	//  Constructores
    public Alumno(int codigo, String nombre, int nota1, int nota2) {
    	this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        cantidad ++;
    }
    public Alumno(int codigo, String nombre) {
    	this(codigo, nombre, 88, 88);
    }
    public Alumno() {
    	this(88888, "ninguno");
    }     
	//  Métodos de acceso público: set/get
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNota1() {
		return nota1;
	}
	public int getNota2() {
		return nota2;
	}
	//  Métodos públicos de clase: set/get
    public static void setCantidad(int cantidad) {
    	Alumno.cantidad = cantidad;
    } 	
    public static int getCantidad() {
    	return cantidad;
    }    
	//  Operaciones públicas
	public double promedio() {
		return (nota1 + nota2) / 2.0;
	}
	
}