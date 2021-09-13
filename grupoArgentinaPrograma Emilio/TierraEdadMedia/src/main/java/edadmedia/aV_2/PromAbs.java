package edadmedia.aV_2;


public class PromAbs extends Promocion {


	public PromAbs( String descrip, Atraccion[] incluye){
		super( descrip, incluye, tiempoTotal(incluye));
	}
	
	

	public static double tiempoTotal(Atraccion[] incluye) {
		double tiempo=0;
		for (Atraccion atraccion : incluye) {
			tiempo+=atraccion.getTiempo();
		}
		return tiempo;
	}
}
