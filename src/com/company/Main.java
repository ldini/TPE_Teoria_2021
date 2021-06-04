package com.company;

public class Main {
//TODO: INFORME https://docs.google.com/document/d/1IeiCi0ZMFGBDWYQ7VFwu0N7eBE5A7xpJ731BahcOnb8/edit?usp=sharing

    public static void main(String[] args) {
	    
	    Cotizacion ETH = new Cotizacion("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\ETH.txt");
	    Cotizacion BTC = new Cotizacion("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\BTC.txt");

//TODO: 1A
	    System.out.println("Matriz de BTC");
	    BTC.show_matriz_condicional();
	    System.out.println("Matriz de ETH");
	    ETH.show_matriz_condicional();
//TODO: 1B - Al usar valores los valores del documento queda por sentado que trabajamos con valores muestrales.
	    System.out.println("Correlacion: ");
	    System.out.print(BTC.calculate_correlacion_lineal(BTC)); // por convertir bouble a float de pierde presicion y no da 1.  
	    
    }
}
