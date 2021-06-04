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
    	System.out.println("El temano es: "+ vector_info.size());
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
    
//TODO: Aclaracion: al calcularse el este vector con una muestra no se asegura que la muestra sea suficiente para 
//		llegar a un vector en estado estacionario.
    public float[] calculate_distribucion_de_probabilidades(){

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
    	float ocurrencias[] = this.calculate_distribucion_de_probabilidades();
    	
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
        		mat_prob[j][i] = mat_prob[j][i]/this.size();
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
    	float[] aux2 = this.calculate_distribucion_de_probabilidades();
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
    
    public double calculate_varianza() {
    	float media = this.calculate_media();
    	float s2 = 0;
    	for(int value : this.vector_info)
    		s2 += Math.pow((value-media),2);
    	return s2/(this.size()-1);
    }
    
    public double calculate_desvio_estandar() {
    	return Math.sqrt(calculate_varianza());
    }
    
    public float calculate_coeficiente_de_variacion() {
    	return (float) (this.calculate_desvio_estandar()/this.calculate_media());
    }
    
    public float calculate_covarianza(Cotizacion cot) {
    	Vector<Integer> y = cot.get_historial_cotizaciones();
    	float cov_xy = 0;
    	float media_x = this.calculate_media();
    	float media_y = cot.calculate_media();
    	int i = 0;
    	for(Integer x : this.vector_info) {
    		cov_xy += ((x-media_x)*(y.get(i)-media_y));
    		i++;
    	}
    	
    	return cov_xy/this.size();
    }
    
    public float calculate_correlacion_lineal(Cotizacion cot) {
    	float cov_xy = this.calculate_covarianza(cot);
    	return (float) (cov_xy/(this.calculate_desvio_estandar()*cot.calculate_desvio_estandar()));
    }
    
    public static float[][] multiplicar_matrices(float[][] m1, float[][] m2) {
        float[][] mr = new float[m1.length][m2[0].length];
        if (m1[0].length == m2.length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m1[0].length; k++) {
                        mr[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
        }
        return mr;
    }
    
    public static float[][] pow_matriz(float[][] mat,int exponente){
    	float[][] mr = new float[mat.length][mat[0].length];
    	for(int i = 0; i<exponente;i++) {
    		mr = multiplicar_matrices(mat, mat);
    	}
    	return mr;
    }
    
    public float[] calculate_vector_de_estado_inicial() {
    	float[] vec_i = {0,0,0};
		if(vector_info.get(0) > vector_info.get(1))
			vec_i[0] = 1;
		else if(vector_info.get(0) < vector_info.get(1))
			vec_i[2] = 1;
		else
			vec_i[1] = 1;   		
    	return vec_i;
    }
    
    public float[] calculate_vector_de_estado_t(int t) {
        float[] vec_t = new float[3];
        float[] vec_i = calculate_vector_de_estado_inicial();
        float[][] mat_aux = pow_matriz(get_matriz_condicional(), t+1);
        for(int i =0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		vec_t[i] = mat_aux[i][j]*vec_i[j];
        	}
        }
        return vec_t;
    }
}
