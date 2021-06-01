package com.company;

public class Main {

    public static void main(String[] args) {
	    
	    Cotizacion ETH = new Cotizacion("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\ETH.txt");
	    Cotizacion BTC = new Cotizacion("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\BTC.txt");

	    BTC.show_matriz_condicional();
	    ETH.show_historial_cotizaciones();

    }
}
