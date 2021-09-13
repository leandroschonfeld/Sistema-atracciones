package edadmedia.aV_2;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;   
	private double tiempo;
	private double presupuesto;
	private TipoAtraccion preferencia;
	private double costoTot = 0;
	private double tiempoTot = 0;
	private List<Atraccion> compras = new ArrayList<>();

	public Usuario(String nombre, double tiempo, double presupuesto, TipoAtraccion preferencia) {
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.presupuesto = presupuesto;
		this.preferencia = preferencia;
	}

	public void restarTiempo(double d) {
		this.tiempo -= d;
		this.tiempoTot += d;
	}

	public void pagar(double costo) {
		this.presupuesto -= costo;
		this.costoTot += costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public TipoAtraccion getPreferencia() {
		return preferencia;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCostoTot() {
		return this.costoTot;
	}

	public double getTiempoTot() {
		return this.tiempoTot;
	}

	public List<Atraccion> getcompras() {

		if (this.compras.isEmpty()) {
			return null;
		}

		return compras;
	}

	public void setCompras(Atraccion a) throws Exception {

		if (this.getPresupuesto() >= a.getCosto() && this.getTiempo() >= a.getTiempo()) {
			this.compras.add(a);
			System.out.println("usted adquirio-> " + a);
			pagar(a.getCosto());
			restarTiempo(a.getTiempo());
			a.restarCupo();


		} else {
			throw new Exception("No se pudo hacer la compra");
		}

	}
	

	public void setCompras(Promocion a) throws Exception {

		if (this.getPresupuesto() >= a.getCosto() && this.getTiempo() >= a.getTiempo()) {

			for (Atraccion e : a.getDestinos()) {
				
				this.compras.add(e);
				e.restarCupo();
			}
			System.out.println("usted adquirio-> " + a);
			pagar(a.getCosto());
			restarTiempo(a.getTiempo());
			for (Atraccion at : a.getDestinos()) {
				at.restarCupo();
			}
		} else {
			throw new Exception("No se pudo hacer la compra");
		}

	}

	@Override
	public String toString() {
		return "Usuario [nombre: " + nombre + ", tiempo: " + tiempo + ", presupuesto: " + presupuesto
				+ ", preferencia: " + preferencia + ", costoTot: " + costoTot + ", tiempoTot: " + tiempoTot
				+ ", compras: \n" + compras + "]";
	}

}
