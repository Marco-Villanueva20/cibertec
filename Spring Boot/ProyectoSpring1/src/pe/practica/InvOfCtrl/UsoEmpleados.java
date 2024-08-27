package pe.practica.InvOfCtrl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {
	
	public static void main(String[] args) {
		//Creacion de objetos de tipo Empleado
		
		/*
		Empleados Empleado1 = new JefeEmpleado();
		System.out.println();
		//Uso de los objetos creados
		System.out.println(Empleado1.getTareas());
		*/
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Empleados Juan = contexto.getBean("miEmpleado", Empleados.class);
		
		
		System.out.println(Juan.getTareas());
		contexto.close();
	}

}
