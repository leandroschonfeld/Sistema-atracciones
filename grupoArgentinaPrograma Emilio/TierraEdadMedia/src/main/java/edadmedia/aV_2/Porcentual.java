package edadmedia.aV_2;

import java.util.Arrays;

public class Porcentual extends Promocion {
	private double descuento; // EN PORCENTAJE
	private Atraccion atraccion[];
	private boolean control = false;
//	private double costo;

	public Porcentual(String descrip, Atraccion[] incluye, double descuento) {
		super(descrip, incluye);
		this.descuento = descuento;

		this.atraccion = new Atraccion[incluye.length];
//		for (int i = 0; i < atraccion.length; i++) {
//			this.atraccion[i]=incluye[i];
//			
//		}
		descuentos(incluye);
//		for (Atraccion e : this.atraccion) {
//			e.setCosto(porcentaje(e));
//		}
	}

	public void descuentos(Atraccion[] incluye) {
		if (!control) {
			control = true;
			for (int i = 0; i < atraccion.length; i++) {
				double x = incluye[i].getCosto() - (incluye[i].getCosto() * 10 / 100);
				atraccion[i] = new Atraccion(incluye[i].getCupos(), incluye[i].getNombre(), incluye[i].getTipo(), x,
						incluye[i].getTiempo());

				}
		}
	}

	public Atraccion[] getAtraccion() {
		return atraccion;
	}

	public void setAtraccion(Atraccion[] atraccion) {
		this.atraccion = atraccion;
	}

	public double porcentaje(Atraccion a) {

		return (a.getCosto() * (100 - descuento)) / 100;
	}

	@Override
	public String toString() {
		return "Porcentual [descuento: " + descuento + ", atraccion: \n" + Arrays.toString(atraccion) + ", control: "
				+ control + "]";
	}

}
