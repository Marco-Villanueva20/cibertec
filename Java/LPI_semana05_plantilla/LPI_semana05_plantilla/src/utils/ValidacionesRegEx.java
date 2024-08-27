package utils;

public class ValidacionesRegEx {
	public static final String TEXTO = "[a-zA-Z\\s]{3,20}";
	public static final String USUARIO = "[Uu//d{3}]";
	
	public static final String TELEFONO = "[9][0-9]{9}";
	public static final String DNI = "[0-9]{8}";
	public static final String CORREO = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	
}
