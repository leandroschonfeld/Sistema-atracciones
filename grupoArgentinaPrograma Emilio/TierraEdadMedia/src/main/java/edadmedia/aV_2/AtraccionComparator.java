package edadmedia.aV_2;

import java.util.Comparator;


public class AtraccionComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion a, Atraccion b) {

		
		int resultado = Double.compare(a.getCosto(), b.getCosto());
		
		if(resultado==0) {
			resultado = Double.compare(a.getTiempo(), b.getTiempo());
		}else {
			return resultado;
		}
		return resultado;
	}
}