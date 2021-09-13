package trabajo_grupal;

public class Atraccion {
private double costo;
private double tiempo;
private int personas;
private String nombre;
private TipoAtraccion tipo;

public Atraccion(String nombre,double costo,double tiempo,int personas, TipoAtraccion tipo ) {
	this.nombre=nombre;
	this.costo=costo;
	this.tiempo=tiempo;
	this.personas=personas;
	
	this.tipo=tipo;
	
	
}
public Atraccion() {}

public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}
public double getTiempo() {
	return tiempo;
}
public void setTiempo(double tiempo) {
	this.tiempo = tiempo;
}
public int getPersonas() {
	return personas;
}
public String getNombre() {
	return nombre;
}
public void setPersonas(int personas) {
	this.personas = personas;
};
public String toString() {
	return "Nombre: "+this.nombre+"; Costo: "+this.costo+"; Cupo diponibre: "+this.personas+"; Tiempo: "+this.tiempo+"; Tipo: "+this.tipo;
}
}
