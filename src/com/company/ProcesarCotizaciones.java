
package com.company;

import java.io.*;
import java.io.File;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProcesarCotizaciones {
    private Vector<String> vector_info = new Vector<>();
    
    public ProcesarCotizaciones() {
    	
    }

    public Vector<String> getVectorCotizaciones(String nombreArchivo) {
        
    	File archivo;
        FileReader fr;
        BufferedReader br;

        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
            	vector_info.addElement(linea);
            }
            br.close();
            fr.close();
            
            Vector<String> aux = new Vector<String>();
            
            for (String e : vector_info) {
            	aux.add(e);
            }
            
            return aux;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
            return null;
        }
    }

}
