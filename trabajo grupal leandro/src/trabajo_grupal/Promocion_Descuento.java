package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Descuento extends Promocion {
private double descuento;

public Promocion_Descuento(String nombre, ArrayList<Atraccion> atracciones, double descuento) {
	this.descuento=descuento;
	this.nombre=nombre;
	this.atracciones=atracciones;
}

	public double getDescuento() {
	return descuento;
}


public void setDescuento(double descuento) {
	this.descuento = descuento;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		
		return "\nNombre Promocion: "+this.nombre+"; Tipo: Descuento "+"; Descuento: "+this.descuento;
	}

}
