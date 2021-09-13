package edadmedia.aV_2;

public enum TipoAtraccion {
	
	Aventura("Aventura"),
	Paisaje("Paisaje"),
	Degustacion("Degustacion");
	
	private final String s ;

	private TipoAtraccion(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}
	
	
}
