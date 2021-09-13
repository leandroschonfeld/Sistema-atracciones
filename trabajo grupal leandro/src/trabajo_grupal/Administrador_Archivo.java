package trabajo_grupal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import pruebas.TipoVehiculo;
import pruebas.Vehiculo;

public class Administrador_Archivo {
	
	
	public static ArrayList<Visitante> leerVisitantes() {
		
		//List<Visitante> visitante = new LinkedList<Visitante>();+
		ArrayList<Visitante> visitantes= new ArrayList<Visitante>();
		String[] line;
		Scanner sc;
		File f = new File("files/Visitantes.txt");
		try {
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				line = sc.nextLine().split("-");
			
			visitantes.add( new Visitante( line[0] ,
						Double.parseDouble(line[1]),
						Double.parseDouble(line[2]),
						TipoAtraccion.valueOf(line[3])
						)	)	;
				line = null;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		
		return visitantes;
	}
	
	
	public static ArrayList<Atraccion> leerAtracciones() {
		ArrayList<Atraccion> atracciones= new ArrayList<Atraccion>();
		String[] line;
		Scanner sc;
		File f = new File("files/Atracciones.txt");
		try {
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				line = sc.nextLine().split("-");
			
			atracciones.add( new Atraccion( line[0] ,
						Double.parseDouble(line[1]),
						Double.parseDouble(line[2]),
						Integer.parseInt(line[3]),
						TipoAtraccion.valueOf(line[4])
						)	)	;
				line = null;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		
		return atracciones;
	}
	
	
	
	public static ArrayList<Promocion> leerPromociones(ArrayList<Atraccion> atracciones) {
		ArrayList<Promocion> promociones= new ArrayList<Promocion>();
		String[] line;
		Scanner sc;
		File f = new File("files/Promociones.txt");
		try {
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				line = sc.nextLine().split("-");
				ArrayList<Atraccion> atracciones_Promocion= new ArrayList<Atraccion>();
				String[] atraccionP;
				atraccionP = line[2].split(",");
				for(String v : atraccionP) {
					
					for(Atraccion a : atracciones) {
						if (a.getNombre().equals(v)) {
							atracciones_Promocion.add(a);
						}
						
					}
				}
				
				
				
		//		for(Atraccion v : atracciones_Promocion) System.out.println(v);
				
				switch (line[0]) 
		        {
		            case "TOTAL": 
		            	promociones.add(new Promocion_Total(line[1],atracciones_Promocion,Double.parseDouble(line[3])));
		                     break;
		            case "GRATIS": 
		            	Atraccion atraccion_Gratis = new Atraccion();
		            	for(Atraccion a : atracciones) {
							if (a.getNombre().equals(line[3])) {
								atraccion_Gratis = a;
							}
							
						}
	          	promociones.add(new Promocion_Gratis(line[1],atracciones_Promocion,atraccion_Gratis));
	                     break;
		            case "DESCUENTO": 
		            	promociones.add(new Promocion_Descuento(line[1],atracciones_Promocion,Double.parseDouble(line[3])));
	                     break;
		        }
		/**	
			promociones.add( new Promocion( line[0] ,
						Double.parseDouble(line[1]),
						Double.parseDouble(line[2]),
						Integer.parseInt(line[3]),
						TipoPromocion.valueOf(line[4])
						)	)	;**/
				line = null;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		
		return promociones;
	}
	
public Atraccion buscarAtraccion(String nombreAtraccion, ArrayList<Atraccion> atracciones)	{
	for(Atraccion v : atracciones) {
		if (v.getNombre().equals(nombreAtraccion)) {
			return v;
		}
		
	}
	return new Atraccion();
	}

}
