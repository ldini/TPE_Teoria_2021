package com.company;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
	    ProcesarCotizaciones pc = new ProcesarCotizaciones();
       
	    Vector<String> a = pc.getVectorCotizaciones("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\ETH.txt");
	    Vector<String> b = pc.getVectorCotizaciones("C:\\Users\\Leandro\\Documents\\Teoria de la Informacion\\TPE_Teoria_2021\\Info\\BTC.txt");
	    
	    for(String e:a) {
	    	System.out.println("ETH: "+e);
	    }
	    
	    for(String e:b) {
	    	System.out.println("BTC: "+e);
	    }
	    
	    
        
        

    }
}
