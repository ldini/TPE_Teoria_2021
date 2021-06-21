public class NodoArbolHuffman{
    int simbolo;
    double probabilidad;
    NodoArbolHuffman menor; // Nodo Izquierdo
    NodoArbolHuffman mayor; // Nodo Derecho

    public NodoArbolHuffman(int simbolo, double probabilidad) {
        this.simbolo = simbolo;
        this.probabilidad = probabilidad;
        this.menor = null;
        mayor = null;
    }
    public int getSimbolo() {
        return simbolo;
    }
    public double getProbabilidad() {
        return probabilidad;
    }
    public NodoArbolHuffman getMenor() {
        return menor;
    }
    public void setMenor(NodoArbolHuffman menor) {
        this.menor = menor;
    }
    public NodoArbolHuffman getMayor() {
        return mayor;
    }
    public void setMayor(NodoArbolHuffman mayor) {
        this.mayor = mayor;
    }
    public boolean esHoja() {
        return ((mayor == null) && (menor == null));
    }
    public int compareTo(Object otroNodo) {
        double result = this.probabilidad - ((NodoArbolHuffman) otroNodo).getProbabilidad();
        if (result < 0)
            return -1;
        else if (result > 0)
            return 1;
        return (int) result;
    }
}