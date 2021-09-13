package edadmedia.aV_2;

public class Atraccion implements AtraccionPromoInterfaz {
	private int cupos;
	private String nombre;
	private TipoAtraccion tipo;
	private double costo;
//	private double costoD;
	
	private double tiempo;

	// super(tipo, nombre, descrip, incluye);
public Atraccion() {};
	public Atraccion(int cupos, String nombre, TipoAtraccion aventura, double costo, double tiempo) {
		this.cupos = cupos;
		this.nombre = nombre;
		this.tipo = aventura;
		this.costo = costo;
		this.tiempo = tiempo;
	}

	public static <T> T getIndex(int x, T[] destinos) {

		if (x < 0) {
			return null;
		}
		if (x > destinos.length) {
			return null;
		}

		return destinos[x];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupos() {
		return cupos;
	}

	public Atraccion[] getDestinos() {
		Atraccion[] destino = { this };
		return destino;
	}

	public void restarCupo() {
		cupos--;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return !(cupos == 0);
	}

	@Override
	public double getCosto() {
		// TODO Auto-generated method stub
		return costo;
	}

	@Override
	public double getTiempo() {
		// TODO Auto-generated method stub
		return tiempo;
	}

	@Override
	public String toString() {
		return "Atraccion [cupos: " + cupos + ", nombre: " + nombre + ", tipo: " + tipo + ", costo: " + costo
				+ ", tiempo: " + tiempo + "]\n";
	}

}
