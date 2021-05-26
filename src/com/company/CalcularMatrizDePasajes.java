package com.company;

import java.util.ArrayList;
import java.util.Vector;


public class CalcularMatrizDePasajes{

    private Vector<Float> resultado;
    public static int TAM_VEC =  1000;

    public CalcularMatrizDePasajes() {
        //Metodo constructor de la clase
        resultado = new Vector<>();
        for(int i = 0; i < TAM_VEC; i++) {
            resultado.add(0f);
        }
    }


    public Matriz probabCondi(Vector<String> vector_btc) {
        //Calcula la matriz de probabilidades condicionales

        Matriz matriz = new Matriz(); //Crea la matriz que luego se retornara
        float[] cant = new float[matriz.TAMANO_FIJO];

        for (int i = 0; i < matriz.TAMANO_FIJO; i++) {
            //Inicializa el arreglo
            cant[i] = 0;
        }
        return matriz;
    }
    
//  Este metodo devuelve la probabilidad de ocurrencias de acciones
    public float[] getVectorProbabilidades(Vector<String> cotizaciones){
    	Vector<Float> cot_float = new Vector<Float>();
    	int size = cotizaciones.size(); 

    	float array_prob[] = {0,0,0}; // Las posicion 0=baja , 1 = igual, 2= subio
 
    	for (int j=0; j < size;j++){
    		cot_float.add(j,Float.parseFloat(cotizaciones.get(j)));
    	}
    	
    	for (int i=1; i < size;i++){
    		if(cot_float.get(i-1) < cot_float.get(i)) {
    				array_prob[2]++;}
    			else if(cot_float.get(i-1) > cot_float.get(i))
    				array_prob[0]++;
    			else
    				array_prob[1]++;
    	}
    	
    	array_prob[0] = array_prob[0]/(size-1); 
    	array_prob[1] = array_prob[1]/(size-1); 
    	array_prob[2] = array_prob[2]/(size-1); 
    	
    	return array_prob;
    }
   
    
    //Se puedo simular con el vector de probabilidad utilizando convergencia
    //pero al tener el vector de simbolos tambien se puede estimar
    //mejor seria simular un gran numero de casos.
    public float[][] getMatrizCondicional(Vector<String> cotizaciones) {
    	Vector<Float> cot_float = new Vector<Float>();
    	int size = cotizaciones.size();
    	int[] cadena_de_simbolos = new int[size];
    	System.out.println("tam"+size);

    	float mat_prob[][] = {{0,0,0},{0,0,0},{0,0,0}};
    	
    	//convierto a flotante el string
    	for (int j=0; j < size;j++){
    		cot_float.add(j,Float.parseFloat(cotizaciones.get(j)));
    	}
    	
    	//Obtengo cadena de simbolos
    	for (int g = 0; g < size-1; g++){
    		if(cot_float.get(g) > cot_float.get(g+1))
    			cadena_de_simbolos[g] = 0;
    		else if(cot_float.get(g) < cot_float.get(g+1))
    			cadena_de_simbolos[g] = 2;
    		else
    			cadena_de_simbolos[g] = 1;
    	}
    	
    	//al coincidir el lugar con el valor se puede generar la matriz de esta forma
    	for(int i = 1;i<size;i++) {
    		mat_prob[cadena_de_simbolos[i]][cadena_de_simbolos[i-1]] ++;
    	}
    	
    	//Matriz en porcentaje
    	for(int i=0 ;i<3;i++) {
    		System.out.println();
    		for(int j=0;j<3;j++) {
    			mat_prob[i][j] = mat_prob[i][j]/(size-1);
    			System.out.print(mat_prob[i][j]+","); 
    		}
    	}
    	
    	return mat_prob;
    	
    }
    
    public void getMatrizConjunta(Vector<String> cotizaciones){
    	float[][] aux = new float[cotizaciones.size()][cotizaciones.size()];
    	for(int i =0;i<cotizaciones.size();i++) {
    		System.out.println();
    		for(int j=0;j<cotizaciones.size();j++) {
    			aux[i][j] = Float.parseFloat(cotizaciones.get(i))*Float.parseFloat(cotizaciones.get(j));
    			System.out.print(aux[i][j]);
    		}
    	}
	}
}
  