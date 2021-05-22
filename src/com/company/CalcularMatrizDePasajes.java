package com.company;

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
}
  