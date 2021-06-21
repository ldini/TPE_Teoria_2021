import java.util.ArrayList;
import java.util.List;

public class RLC {
	private List<parCodificado> elementos = new ArrayList<parCodificado>();
		
	public void codificarCotizacion(int[] vectorCotizacion, int size) {
		parCodificado simbolo = new parCodificado(vectorCotizacion[0]);
		simbolo.aumentarSecuencia();
		elementos.add(simbolo);
		for(int i=1; i<size; i++) {
			if ((elementos.get(elementos.size()-1).getSimbolo()) == vectorCotizacion[i]) {
				simbolo=elementos.get(elementos.size()-1);
				simbolo.aumentarSecuencia();
				elementos.set(elementos.size()-1, simbolo);
			} else {
				simbolo = new parCodificado(vectorCotizacion[i]);
				simbolo.aumentarSecuencia();
				elementos.add(simbolo);
			}
		}
	}
	public List<parCodificado> getCodificacion(){
		List<parCodificado> clon = new ArrayList<parCodificado>(elementos);			
		return clon;
	}
	
	
}
	

