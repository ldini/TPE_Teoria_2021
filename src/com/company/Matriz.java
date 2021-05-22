package com.company;

public class Matriz {

    private float [][] matriz;
    public final int VALOR_POR_DEFECTO = 0;
    public final int TAMANO_FIJO = 1000;

    public Matriz(){
        //Constructor de la clase
        this.matriz = new float[this.TAMANO_FIJO][this.TAMANO_FIJO];
        this.inicializarMatriz();
    }

    public float getElemento (int x, int y){
        //Retorna el elemento guardado en la posicion (x, y)
        return this.matriz[x][y];
    }

    public void setElemento (int x, int y, float valor){
        //Cambia el valor de la posicion (x, y)
        this.matriz[x][y] = valor;
    }

    private void inicializarMatriz (){
        //Inicializa la matriz con ceros en todas sus posiciones
        for (int i = 0; i < this.TAMANO_FIJO; i++)
            for (int j = 0; j < this.TAMANO_FIJO; j++)
                this.matriz[i][j] = this.VALOR_POR_DEFECTO;
    }

}