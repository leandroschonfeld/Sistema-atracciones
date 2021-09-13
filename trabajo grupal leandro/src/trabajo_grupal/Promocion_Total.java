package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Total extends Promocion{
private double total;

public Promocion_Total( String nombre, ArrayList<Atraccion> atracciones,double total) {
	this.total=total;
	this.nombre=nombre;
	this.atracciones=atracciones;
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
public String toString() {
		
		return "\nNombre Promocion: "+this.nombre+"; Tipo: Total "+"; Precio total: "+this.total;
	}
}
