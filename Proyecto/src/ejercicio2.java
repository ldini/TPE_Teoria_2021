import java.util.Arrays;

public class ejercicio2 {

    private Nodo_Huffman punt_Huffman;
    private Nodo_Huffman[] orden_Huff;

    class Nodo_Huffman implements Comparable<Nodo_Huffman> {

        private float p;
        private int c;
        private Nodo_Huffman izq;
        private Nodo_Huffman der;

        public Nodo_Huffman() {
        }

        public Nodo_Huffman(float p_hoja, int c) {
            this.p = p_hoja;
            this.c = c;
            this.izq = null;
            this.der = null;
        }

        public Nodo_Huffman(float p, Nodo_Huffman izqh, Nodo_Huffman derh) {
            this.p = p;
            this.izq = izqh;
            this.der = derh;
        }

        public float get_Probabilidad() {
            return this.p;
        }

        public int get_simbolo() {
            return c;
        }

        public Nodo_Huffman get_der() {
            return this.der;
        }

        public Nodo_Huffman get_izq() {
            return this.izq;
        }

        boolean es_Hoja() {
            return ((this.izq == null) && (this.der == null));
        }

        public int compareTo(Nodo_Huffman otro_nh) {
            if (this.p < otro_nh.get_Probabilidad())
                return -1;
            else if (this.p > otro_nh.get_Probabilidad())
                return 1;
            return 0;
        }

    }

    public ejercicio2() {
    }

    public float[] calculate_distribucion_de_probabilidades(int[] vector_info) {

        float []array_prob = {0, 0, 0}; // Las posicion 0=baja , 1 = igual, 2= subio
        for (int i = 1; i < 999; i++) {
            if (vector_info[i - 1] < vector_info[i]) {
                array_prob[2]++;
            } else if (vector_info[i - 1] > vector_info[i])
                array_prob[0]++;
            else
                array_prob[1]++;
        }
        array_prob[0] = array_prob[0] / (1000 - 1);
        array_prob[1] = array_prob[1] / (1000 - 1);
        array_prob[2] = array_prob[2] / (1000 - 1);
        return array_prob;
    }


    private void shift2_array() {
        for (int i = 2; i < orden_Huff.length; i++)
            this.orden_Huff[i - 2] = this.orden_Huff[i];
    }

    private void arbol_Huffman(String[] ch, String code, Nodo_Huffman nh) {
        if (nh.es_Hoja())
            ch[nh.get_simbolo()] = new String(code);
        else {
            arbol_Huffman(ch, code + "0", nh.get_izq());
            arbol_Huffman(ch, code + "1", nh.get_der());
        }
    }

    public int mover_ArbolDerecha() {
        this.punt_Huffman = punt_Huffman.get_der();
        if (punt_Huffman.es_Hoja()) {
            int simb = punt_Huffman.get_simbolo();
            punt_Huffman = orden_Huff[0];
            return simb;
        }
        return -1;
    }

    public int mover_ArbolIzquierda() {
        this.punt_Huffman = punt_Huffman.get_izq();
        if (punt_Huffman.es_Hoja()) {
            int simb = punt_Huffman.get_simbolo();
            punt_Huffman = orden_Huff[0];
            return simb;
        }
        return -1;
    }

    public String[] do_Huffman(float[] dist) {

        int ult_pos = dist.length - 1;
        this.orden_Huff = new Nodo_Huffman[dist.length];
        for (int i = 0; i < dist.length; i++)
            this.orden_Huff[i] = new Nodo_Huffman(dist[i], i);
        Arrays.sort(orden_Huff);
        while (!(orden_Huff[0].get_Probabilidad() == 1)) {
            float h3 = orden_Huff[0].get_Probabilidad() + orden_Huff[1].get_Probabilidad();
            Nodo_Huffman nh3 = new Nodo_Huffman(h3, orden_Huff[0], orden_Huff[1]);
            shift2_array();
            orden_Huff[ult_pos] = null;
            ult_pos--;
            orden_Huff[ult_pos] = nh3;
            Arrays.sort(orden_Huff, 0, ult_pos + 1);
        }
        String[] codigo_Huffman = new String[dist.length];
        this.punt_Huffman = orden_Huff[0];
        arbol_Huffman(codigo_Huffman, "", orden_Huff[0]);
        return codigo_Huffman;
    }


}