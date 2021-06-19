public class main {
//TODO: INFORME https://docs.google.com/document/d/1IeiCi0ZMFGBDWYQ7VFwu0N7eBE5A7xpJ731BahcOnb8/edit?usp=sharing

    public static void main(String[] args) {
	    
	    Cotizacion ETH = new Cotizacion("ETH.txt");
	    Cotizacion BTC = new Cotizacion("BTC.txt");

//TODO: 1A
	    System.out.println("Matriz de BTC");
	    BTC.show_matriz_condicional();
	    System.out.println("Matriz de ETH");
	    ETH.show_matriz_condicional();
//TODO: 1B - Al usar valores los valores del documento queda por sentado que trabajamos con valores muestrales.
	   // System.out.println("Correlacion: ");
	   // System.out.print(BTC.calculate_correlacion_lineal(BTC)); // por convertir bouble a float de pierde presicion y no da 1.  
	    Correlacion aux = new Correlacion();
	    System.out.println();
	    for(int i=0; i<5;i++) {
	    	
	    	System.out.println("Correlacion cruzada: "+aux.calcular_correlacion_cruzada(ETH.getVectorCotizacion(), BTC.getVectorCotizacion(), 0, 200)[i]);
	      	//System.out.println("Correlacion cruzada: "+aux.calcular_correlacion_cruzada(BTC.getVectorCotizacion(), ETH.getVectorCotizacion(), 0, 200)[i]);
	    }
	    
	    
	    ETH.graficate();
	    
    }
}
