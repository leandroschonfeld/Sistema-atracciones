package edadmedia.aV_2;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {
	public static void main(String[] args) {

		Usuario usuario[] = { new Usuario("Emilio", 800, 80000, TipoAtraccion.Aventura),
				new Usuario("Mauro", 800, 80000, TipoAtraccion.Aventura),
				new Usuario("Lucas", 800, 80000, TipoAtraccion.Aventura),
				new Usuario("Leandro", 800, 80000, TipoAtraccion.Aventura) };

		
		
		Atraccion a1 =new Atraccion(10, "Atraccion1", TipoAtraccion.Aventura, 10, 2.20);
		Atraccion a2=new Atraccion(10, "Atraccion2", TipoAtraccion.Paisaje, 100, 2.20);
		Atraccion a3 =new Atraccion(10, "Atraccion3", TipoAtraccion.Aventura, 10, 2.20);
		Atraccion a4=new Atraccion(10, "Atraccion4", TipoAtraccion.Degustacion, 100, 2.20);
		Atraccion a5 =new Atraccion(10, "Atraccion5", TipoAtraccion.Aventura, 10, 2.20);
		Atraccion a6=new Atraccion(10, "Atraccion6", TipoAtraccion.Degustacion, 100, 2.20);
		Atraccion a7 =new Atraccion(10, "Atraccion7", TipoAtraccion.Aventura, 10, 2.20);
		Atraccion a8=new Atraccion(10, "Atraccion8", TipoAtraccion.Paisaje, 100, 2.20);
		Atraccion a9 =new Atraccion(10, "Atraccion9", TipoAtraccion.Aventura, 10, 2.20);
		Atraccion a10=new Atraccion(10, "Atraccion10", TipoAtraccion.Paisaje, 100, 2.20);
				 
		Atraccion[] atracciones = {a1,a2,a3,a4,a5,a6,a6,a7,a8,a9,a10 };

		Atraccion[] prom = 	{a1,a2,a3,a4,a5};
		Atraccion[] prom1 = {a3,a5,a6,a4,a7};
		Atraccion[] prom2 = {a1,a2,a3,a10,a6};
		Atraccion[] prom3 = {a1,a8,a9,a4,a5};
		
		Arrays.sort(atracciones, new AtraccionComparator());

		PromAxB axb= new PromAxB("axb", prom, a10);
		PromAxB axb1= new PromAxB("axb", prom1, a9);
		PromAxB axb2= new PromAxB("axb", prom2, a8);
		PromAxB axb3= new PromAxB("axb", prom3, a7);
		
		PromAxB[] Paxb= {axb,axb1,axb2,axb3};
		
		
		Arrays.sort(prom, new AtraccionComparator());
		Arrays.sort(prom1, new AtraccionComparator());
		Arrays.sort(prom2, new AtraccionComparator());
		Arrays.sort(prom3, new AtraccionComparator());

		Promocion promo1 = new Promocion("promo1",
				new Atraccion[] { a1,a2,a3,a4,});
		Promocion promo2 = new Promocion("promo2",
				new Atraccion[] { a5,a6,a6,a7,});

		Promocion promo3 = new Promocion("promo3",
				new Atraccion[] { a6,a7,a8,a9,a10 });

		Promocion[] promociones = { promo1, promo2, promo3 };

		Porcentual porcentual = new Porcentual("descuentos", atracciones, 10);

		System.out.println("Bienvenido a Turismo en la Tierra Media.");
		System.out.println("Antes de comenzar inicie sesión");
		Scanner in = new Scanner(System.in);
		int id;
		String entrada = "";
		while (!entrada.equals("finalizar")) {
			while (!entrada.equals("cambiar usuario")) {
				System.out.print("Seleccionar usuario: \n");

				id = elegirUsuario(usuario);
				comprasUsuario(promociones, porcentual, usuario, id, atracciones,Paxb);

				System.out.println("escribir [ cambiar usuario ] para cambiarlo");
				entrada = in.nextLine();
			}

			System.out.println("**********************\n"
					+ "enter para cambiar usuario \n_______________ \nescribir [ finalizar ] para terminar");
			entrada = in.nextLine();
		}
		in.close();
		System.out.println("fin del programa");

	}

	/**
	 * @param entrada
	 * @param porcentual
	 * @param usuario
	 * @param id
	 * @param atracciones
	 * 
	 *                    Este metodo muesta atracciones y el usuario elige comprar
	 */
	public static void comprasUsuario(Promocion[] promociones, Porcentual porcentual, Usuario[] usuario, int id,
			Atraccion[] atracciones, PromAxB[] Paxb) {
		Scanner in = new Scanner(System.in);
		Scanner nro = new Scanner(System.in);
		
		
		
		System.out.println("Bienvenido " + usuario[id].getNombre());

		System.out.println("Su perfil es el siguiente...");
		System.out.println("Tiempo disponible: " + usuario[id].getTiempo() + "hs    Paseo preferido: "
				+ usuario[id].getPreferencia() + "   Presupuesto: " + usuario[id].getPresupuesto()
				+ " monedas.");
		
		
		
		info();
		String entrada = in.nextLine();
		switch (entrada) {
		case "a": {
			int index = 0;
			for (Atraccion e : porcentual.getAtraccion()) {

				System.out.println(index + " : " + e);
				index++;
			}

			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");

				try {
					int x1 = nro.nextInt();
					usuario[id].setCompras(Atraccion.getIndex(x1, porcentual.getAtraccion()));
					System.out.println(usuario[id].getPresupuesto());
					System.out.println(usuario[id].getTiempo());

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}System.out.println("------ enter para seguir----");
			info();
			break;
		}
		case "b": {
			int x1 = 0;
			for (Atraccion e : atracciones) {
				
				if (e.getTipo() == TipoAtraccion.Aventura) {
					System.out.println(x1 + ": " + e);
				}
				x1++;
			}
			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");

				try {
					int x3 = nro.nextInt();
					usuario[id].setCompras(Atraccion.getIndex(x3, atracciones));
					System.out.println(usuario[id].getPresupuesto());
					System.out.println(usuario[id].getTiempo());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}System.out.println("------ enter para seguir----");
			info();

			break;
		}
		case "c": {
			int x2 = 0;
			for (Atraccion e : atracciones) {
				x2++;
				if (e.getTipo() == TipoAtraccion.Degustacion) {
					System.out.println(x2 + ": " + e);
				}
			}
			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");

				try {
					int x1 = nro.nextInt();
					usuario[id].setCompras(Atraccion.getIndex(x1, atracciones));
					System.out.println(usuario[id].getPresupuesto());
					System.out.println(usuario[id].getTiempo());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}System.out.println("------ enter para seguir----");
			info();
			break;
		}

		case "d": {
			int x4 = 0;
			for (Atraccion e : atracciones) {
				if (e.getTipo() == TipoAtraccion.Paisaje) {
					System.out.println(x4 + ": " + e);
				}
				x4++;
			}
			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");

				try {
					int x1 = nro.nextInt();
					usuario[id].setCompras(Atraccion.getIndex(x1, atracciones));
					System.out.println(usuario[id].getPresupuesto());
					System.out.println(usuario[id].getTiempo());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("------ enter para seguir----");
			info();
			break;

		}
		case "e": {
			int x = 0;
			for (Promocion promocion : promociones) {
				System.out.println("promo " + x + ": \n" + promocion);
				System.out
						.println("\nsu costo: " + promocion.getCosto() + "tiempo requerido: " + promocion.getTiempo());
				x++;

			}
			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");
				x = nro.nextInt();
				try {
					usuario[id].setCompras(Atraccion.getIndex(x, promociones));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}System.out.println("------ enter para seguir----");
			info();
			break;
		}
		case "f": {
			int x = 0;
			for (PromAxB promocion : Paxb) {
				System.out.println("promo " + x + ": \n" + promocion);
				System.out
						.println("\nsu costo: " + promocion.getCosto() + "tiempo requerido: " + promocion.getTiempo());
				x++;

			}
			System.out.println("Desea aquirir??\n [v] adquirir, [q] no adquirir");
			entrada = in.nextLine();
			if (entrada.equalsIgnoreCase("v")) {
				System.out.println("cual desea adquirir? ");
				x = nro.nextInt();
				try {
					usuario[id].setCompras(Atraccion.getIndex(x, Paxb));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}System.out.println("------ enter para seguir----");
			info();
			break;
		}
		case "mis compras": {

			if (usuario[id].getcompras() == null) {
				System.out.println("el usuario " + usuario[id].getNombre() + " no hizo compras \n");
			} else {
				System.out.println(usuario[id].getcompras() + "\n");
			}
			System.out.println("------ enter para seguir----");
			info();
			break;
		}
		default:
		}
	}

	public static void info() {
		System.out.println("\nElegir opcion:\n" + "[a] Mostrar ofertas con 10% de descuento,\n"
				+ "[b] Mostrar ofertas  atracciones de tipo aventura," + "\n"
				+ "[c] Mostrar ofertas atracciones de tipo degustacion,\n"
				+ "[d] Mostrar ofertas atracciones de tipo paisaje" + "\n" 
				+ "[e] Mostrar promociones"
				+"\n[f] Mostras Promociones AxB\n"
				+ "para ver sus compras, escriba [mis compras]\n" + "[ cambiar usuario ]");
	}

	public static int elegirUsuario(Usuario[] usuario) {
		int x = 0;
		Scanner nro = new Scanner(System.in);
		for (Usuario e : usuario) {
			System.out.println(x + " : " + e);
			x++;
		}
		return nro.nextInt();
	}
}
