
package com.company;

import java.io.*;
import java.io.File;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProcesarCotizaciones {
    private Vector<String> vector_btc = new Vector<>();
    private Vector<String> vector_eth = new Vector<>();

    public void lecturaBTC(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;

        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                vector_btc.addElement(linea);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }

    public void lecturaETH(String nombreArchivo) {
        File archivo;
        FileReader fr;
        BufferedReader br;

        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                vector_eth.addElement(linea);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }

    public Vector<String> getVectorBTC(){
        Vector<String> aux = new Vector<>();
        for (int i = 0; i < vector_btc.size(); i++) {
            aux.addElement(vector_btc.get(i));
        }
        return aux;
    }
}
