package com.company;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Cotizacion {
    private Vector<Integer> vector_info;
	DecimalFormatSymbols separadoresPersonalizados;
	DecimalFormat formato;

	//Inicializa el Vector con todos los datos del archivo y da formato a los decimales para que se muestre de una forma mas prolija
    public Cotizacion(String file) {
    	vector_info = get_vector_de_cotizaciones(file); 
    	separadoresPersonalizados = new DecimalFormatSymbols();
    	separadoresPersonalizados.setDecimalSeparator('.');
    	formato = new DecimalFormat("#.00", separadoresPersonalizados);
    }

    //cantidad de datos del archivo
    private int size() {
    	return vector_info.size();
    }
    
    //se obtiene los datos del archivo ordenados en un vector de integers
    private Vector<Integer> get_vector_de_cotizaciones(String file) {
        
    	File archivo;
        FileReader fr;
        BufferedReader br;
        Vector<Integer> vector_aux = new Vector<Integer>();
        
        try {
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
            	vector_aux.addElement(Integer.parseInt(linea));
            }
            br.close();
            fr.close();
            return vector_aux;
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
            return null;
        }
    }
    
    //devuelve una copia del vector integer de todas las cotizaciones
    public Vector<Integer> get_historial_cotizaciones(){
    	Object copy_vector = vector_info.clone();	
    	return (Vector<Integer>) copy_vector;
    }
    
    //muestra el historial de todas las cotizaciones
    public void show_historial_cotizaciones(){
	    for(float e:this.get_historial_cotizaciones()) {
	    	System.out.println(e);
	    }
    	
    }
    
//    se obtiene el vector de probabilidad de ocurrecias donde 
//    posicion 0 = baja
//    posicion 1 = estable
//    posicion 2 = alza
    public float[] get_probabilidad_de_ocurrencias(){

    	float array_prob[] = {0,0,0}; // Las posicion 0=baja , 1 = igual, 2= subio

    	for (int i=1; i < this.size();i++){
    		if(vector_info.get(i-1) < vector_info.get(i)) {
    				array_prob[2]++;}
    			else if(vector_info.get(i-1) > vector_info.get(i))
    				array_prob[0]++;
    			else
    				array_prob[1]++;
    	}
    	
    	array_prob[0] = array_prob[0]/(this.size()-1); 
    	array_prob[1] = array_prob[1]/(this.size()-1); 
    	array_prob[2] = array_prob[2]/(this.size()-1); 
    	
    	return array_prob;
    }
    
//    muestra el vector con las probabilidades de las ocurrencias
    public void show_probabilidad_de_ocurrencias() {
    	float ocurrencias[] = this.get_probabilidad_de_ocurrencias();
    	
    	System.out.println("Baja:"+formato.format(ocurrencias[0])+"%");
    	System.out.println("Estable:"+formato.format(ocurrencias[1])+"%");
    	System.out.println("Alza:"+formato.format(ocurrencias[2])+"%");
    }
//  se obtiene la matriz condicional
    public float[][] get_matriz_condicional() {
    	
    	float mat_prob[][] = {{0,0,0},{0,0,0},{0,0,0}};
    	int[] cadena_de_simbolos = new int[this.size()];
    	
    	//Obtengo cadena de simbolos
    	for (int g = 0; g < this.size()-1; g++){
    		if(vector_info.get(g) > vector_info.get(g+1))
    			cadena_de_simbolos[g] = 0;
    		else if(vector_info.get(g) < vector_info.get(g+1))
    			cadena_de_simbolos[g] = 2;
    		else
    			cadena_de_simbolos[g] = 1;
    	}
    	
    	//al coincidir el lugar con el valor se puede generar la matriz de esta forma
    	for(int i = 1;i<cadena_de_simbolos.length;i++) {
    		mat_prob[cadena_de_simbolos[i]][cadena_de_simbolos[i-1]] ++;
    	}
    	
    	for(int i = 0;i<3;i++) {
        	for(int j = 0;j<3;j++) {
        		mat_prob[j][i] = mat_prob[j][i]/999;
        	}
    	}
 
    	return mat_prob;
    	
    }
    
//    se muestra la matriz condicional
    public void show_matriz_condicional() {
    	float aux[][] = this.get_matriz_condicional();
    	
    	for(int i=0 ;i<3;i++) {
    		System.out.println();
    		for(int j=0;j<3;j++) {
    			System.out.print(formato.format(aux[i][j])+" ");
    		}
    	}
    }
    
//    se obtiene la matriz conjunta
    public float[][] get_matriz_conjunta(){
    	float[][] aux1 = new float[3][3];
    	float[] aux2 = this.get_probabilidad_de_ocurrencias();
    	for(int i =0;i<aux2.length;i++) {
    		for(int j=0;j<aux2.length;j++) {
    			aux1[i][j] = (float)(aux2[i]*aux2[j]);
    		}
    	}
    	return aux1;
	}
    
//    se muestra la matriz conjunta
    public void show_matriz_conjunta() {
    	
    	float mat[][] = this.get_matriz_conjunta();
		System.out.println("MATRIZ CONJUNTA");
    	for(int i =0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			System.out.print(formato.format(mat[i][j]));
    		}
    		System.out.println();
    	}
    }
    
    public float calculate_media() {
    	int suma = 0;
    	for(int value : this.vector_info)
    		suma += value;
    	return suma/this.size();
    }
    
    
 
}
