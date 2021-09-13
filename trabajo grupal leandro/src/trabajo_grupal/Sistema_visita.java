package trabajo_grupal;

import java.util.ArrayList;
import java.util.List;

import pruebas.AdministradorDeArchivos;
import pruebas.Vehiculo;


public class Sistema_visita {
	private static ArrayList<Atraccion> atracciones;
	private static List<Promocion> promociones;
	private static ArrayList<Visitante> visitantes;
	
	
	
	
	
	public static void main(String[] args) {	
		
	
		
		System.out.println("Visitantes:\n");
		visitantes = Administrador_Archivo.leerVisitantes();
		
		for(Visitante v : visitantes) System.out.println(v);
		
		System.out.println("\nAtracciones:\n");
		atracciones = Administrador_Archivo.leerAtracciones();
		
		for(Atraccion v : atracciones) System.out.println(v);
		
		System.out.println("\nPromociones:\n");
		promociones = Administrador_Archivo.leerPromociones(atracciones);
		
		for(Promocion v : promociones) {
			System.out.println(v);
			for(Atraccion a : v.getAtracciones()) System.out.println(a);
		}
		
	}
	
	

	
	

}
