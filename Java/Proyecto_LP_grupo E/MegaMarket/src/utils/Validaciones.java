package utils;

public class Validaciones {
	
	public static final String NOMBRE_PROVEEDOR = "[a-zA-Z\\s]{4,35}";
	public static final String RUC_PROVEEDOR = "[2][0-9]{10}";
	public static final String DIRECCION_PROVEEDOR = "[a-zA-Z0-9\\.\\s]{4,35}";
	
	public static final String NOMBRE_PRODUCTO = "[a-zA-Z0-9\\s]{4,35}";
	public static final String CANTIDAD_PRODUCTO ="[0-9\\s]{1,}";
	public static final String PRECIO_PRODUCTO ="\\d+\\.\\d{1,2}";
	
	public static final String NOMBRE_USUARIO = "[a-zA-Z0-9\\s]{1,10}";
	public static final String CONTRASEÑA_USUARIO = "[a-zA-Z0-9\\s]{6,12}";
	
}
