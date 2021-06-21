import java.util.List;
public class main {

public static void main(String[] args) {
	    
	    Cotizacion ETH = new Cotizacion("ETH.txt");
	    Cotizacion BTC = new Cotizacion("BTC.txt");

//TODO: 1A
	    System.out.print("Matriz de BTC");
	    BTC.show_matriz_condicional();
	 	System.out.println();
	    System.out.print("Matriz de ETH");
	    ETH.show_matriz_condicional();
//TODO: 1B - Al usar valores los valores del documento queda por sentado que trabajamos con valores muestrales.
	    Correlacion aux = new Correlacion();
	    System.out.println();
	    for(int i=0; i<5;i++) {
	    	
	    	System.out.println("Correlacion cruzada: "+aux.calcular_correlacion_cruzada(ETH.getVectorCotizacion(), BTC.getVectorCotizacion(), 0, 200)[i]);
	      	//System.out.println("Correlacion cruzada: "+aux.calcular_correlacion_cruzada(BTC.getVectorCotizacion(), ETH.getVectorCotizacion(), 0, 200)[i]);
	    }
//TODO: 2A - 
	    distribucionProbabilidades aux1 = new distribucionProbabilidades();
		System.out.println("Distribucion de probabilidades (ETH): "+aux1.calcular_distribucion_de_probabilidades(ETH.getVectorCotizacion()));
	    
		//2C - Codificar las cotizaciones de cada moneda usando RLC (Run Length Coding)
		//ETC
		RLC ETHCodificadoRLC = new RLC();
		ETHCodificadoRLC.codificarCotizacion(ETH.getVectorCotizacion(), 1000);
		List<parCodificado> codificacion = ETHCodificadoRLC.getCodificacion();
		System.out.println("ETH Codificado RLC: "+ codificacion.size());
		List<Integer> ETHDescodificado=ETHCodificadoRLC.descodificarCotizacion();
		System.out.println("ETH Descodificado RLC: " + ETHDescodificado.size());
		//BTC
		RLC BTCCodificadoRLC = new RLC();
		BTCCodificadoRLC.codificarCotizacion(BTC.getVectorCotizacion(), 1000);
		List<parCodificado> codificacion2 = BTCCodificadoRLC.getCodificacion();
		System.out.println("BTC Codificado RLC: "+ codificacion2.size());
		List<Integer> BTCDescodificado=BTCCodificadoRLC.descodificarCotizacion();
		System.out.println("BTC Descodificado RLC: " + BTCDescodificado.size());
		
	}
}