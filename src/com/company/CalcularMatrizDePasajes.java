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

    

    public void calcularProbabilidades(Vector<String> cotizaciones){
	    for (int i = 0; i < cotizaciones.size(); i++)
	        System.out.println(cotizaciones.get(i));
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
    
    public void getMatrizConjunta(Vector<String> cotizaciones) {
    	Vector<Float> cot_float = new Vector<Float>();
    	int size = cotizaciones.size();
    	int[] array_estados = new int[size];
    	System.out.println("tam"+size);

//    	float Mc_prob[][] = {{0,0,0},{0,0,0},{0,0,0}};
    	
    	for (int j=0; j < size;j++){
    		cot_float.add(j,Float.parseFloat(cotizaciones.get(j)));
    	}
    	
    	for (int g = 0; g < size-1; g++){
    		if(cot_float.get(g) > cot_float.get(g+1))
    			array_estados[g] = 0;
    		else if(cot_float.get(g) < cot_float.get(g+1))
    			array_estados[g] = 2;
    		else
    			array_estados[g] = 1;
    	}
    	
    	for (int j=0; j < size;j++){
    		System.out.print(array_estados[j]+" ,");
    	}
    }
}
  