package trabajo_grupal;

public class Visitante {
private String nombre;
private double presupuesto;
private double tiempo;
private TipoAtraccion preferencia;
private Promocion[] itinerario;

public Visitante( String nombre,double presupuesto,double tiempo,TipoAtraccion preferencia) {
	this.nombre=nombre;
	this.presupuesto=presupuesto;
	this.tiempo=tiempo;
	this.preferencia=preferencia;
	
}


public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPresupuesto() {
	return presupuesto;
}
public void setPresupuesto(double presupuesto) {
	this.presupuesto = presupuesto;
}
public double getTiempo() {
	return tiempo;
}
public void setTiempo(double tiempo) {
	this.tiempo = tiempo;
}
public Promocion[] getItinerario() {
	return itinerario;
}
public void setItinerario(Promocion[] itinerario) {
	itinerario = itinerario;
}

public String toString() {
	return "Nombre: "+this.nombre+"; Presupuesto: "+this.presupuesto+"; Tiempo: "+this.tiempo;
}
}
