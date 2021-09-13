package edadmedia.aV_2;

public class PromAxB extends Promocion {
	private Atraccion gratis;
	private double costo;

	public PromAxB(String descrip, Atraccion[] incluye, Atraccion gratis) {
		super(descrip, incluye);
		gratis(incluye, gratis);
		this.costo=costo();
	}

	public double getCosto() { // PARTICULAR
		return this.costo;
	}
	
	
	private double costo() {
		int suma = 0;
		for (Atraccion a : this.getDestinos()) {
			suma += a.getCosto();
		}
		return suma;
	}

	/*
	 * si supero las 3 compras me dan el gratis que pido
	 */
	private void gratis(Atraccion[] incluyee, Atraccion gratis) { // PARTICULAR

		if (incluyee.length > 3) {
			this.gratis =  new Atraccion(gratis.getCupos(), gratis.getNombre(), gratis.getTipo(), 0,
					gratis.getTiempo());
		
		}else {
			this.gratis=null;
		}
			
	}

	public Atraccion getGratis() { // PARTICULAR
		return this.gratis;
	}

	@Override
	public String toString() {
		return "PromAxB [gratis: " + gratis + "]" + super.toString();
	}

}
