package edadmedia.aV_2;

import java.util.Arrays;

public class Promocion implements AtraccionPromoInterfaz {

	private String descripcion; // Sent� la adrenalina de traspasar las monta�as con un 20% de descuento.
	private Atraccion[] destinos; // Atracciones compradas (incluye la que va gratis)
	private int cantidad;
	private double precio, tiempo;

	public Promocion(int cantidad, double precio, double tiempo) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.tiempo = tiempo;
	}

	public Promocion(String descripcion, Atraccion[] destinos, double tiempo) {
		this.descripcion = descripcion;
		this.destinos = destinos;
		this.tiempo = tiempo;
		precio=Precio();

	}

	public double getPrecio() {
		return precio;
	}

	public Promocion(String descripcion, Atraccion[] destinos) {
		this.descripcion = descripcion;
		this.destinos = destinos;
		tiempo=Tiempo();
		precio=Precio();
		this.cantidad=destinos.length;
		

	}

	public Promocion(String descripcion, Atraccion[] destinos, int cantidad, double precio, double tiempo) {

		this.descripcion = descripcion;
		this.destinos = destinos;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tiempo = tiempo;
	}

	private double Tiempo() {
		double suma = 0;
		if(destinos==null||destinos.length==0) {
			return 0.0;
		}
		for (Atraccion a : destinos) {
			suma += a.getTiempo();
		}
		return suma;
	}
	
	

	public int getCupos() {
		int cupoMin = this.destinos[0].getCupos();
		for (int i = 1; i < this.destinos.length; i++) {
			if (cupoMin > this.destinos[i].getCupos())
				cupoMin = this.destinos[i].getCupos();
		}
		return cupoMin;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Atraccion[] getDestinos() {
		return this.destinos;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return getCupos() < cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	private double Precio() {
		double total =0;
		
		if(destinos==null||destinos.length==0) {
			return 0.0;
		}

		
		for (Atraccion e : destinos) {
			total+=e.getCosto();
		}
		return total;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDestinos(Atraccion[] destinos) {
		this.destinos = destinos;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		double costo = 0;
		for (Atraccion e : destinos) {
			costo += e.getCosto();
		}
		return costo;
	}

	@Override
	public String toString() {
		return "Promocion [descripcion: " + descripcion + ", destinos: \n" + Arrays.toString(destinos) + ", cantidad: "
				+ cantidad + ", precio: " + precio + ", tiempo: " + tiempo + "]";
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return this.tiempo;
	}
	

}