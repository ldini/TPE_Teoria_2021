package com.company;


public class Main {

    public static void main(String[] args) {
	    ProcesarCotizaciones pc = new ProcesarCotizaciones();
	    pc.lecturaBTC("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\BTC.txt");
		pc.lecturaETH("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\ETH.txt");	
        CalcularMatrizDePasajes aux = new CalcularMatrizDePasajes();
		aux.calcularProbabilidades(pc.getVectorBTC());
    }
}
