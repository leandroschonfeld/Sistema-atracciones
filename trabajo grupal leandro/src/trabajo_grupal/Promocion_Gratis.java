package trabajo_grupal;

import java.util.ArrayList;

public class Promocion_Gratis extends Promocion {
private Atraccion atraccion;

public Promocion_Gratis(String nombre, ArrayList<Atraccion> atracciones, Atraccion atraccion) {
	this.atraccion=atraccion;
	this.nombre=nombre;
	this.atracciones=atracciones;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Atraccion getAtraccion() {
		return atraccion;
	}
	public void setAtraccion(Atraccion atraccion) {
		this.atraccion = atraccion;
	}
	
public String toString() {
		
		return "\nNombre Promocion: "+this.nombre+"; Tipo: Gratis "+"; Atraccion gratuita: "+this.atraccion.getNombre();
	}
}
