/**
 * CLASE QUE PERMITE LEER EL ARCHIVO DESDE DISCO.
 */
package equiposfutbol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class LeerArchivo {
    
    /**
     * Variable que recibe la ruta del archivo
     */
    private String sRutaArchivo = null;
    
    /**
     * Lista que recibe los datos del archivo
     */
    private ArrayList arrayDatosArchivo = null;
    
    
    /**
     * Constructor de la clase.
     * 
     * @param sRutaArchivo 
     */
    public LeerArchivo(String sRutaArchivo){
        this.sRutaArchivo = sRutaArchivo;
        arrayDatosArchivo = new ArrayList();
        
        /**
         * Llamado al metodo que lee el archivo
         */
        interpretarArchivo();
    }
    
    /**
     * Metodo que recibe el archivo.
     */
    private void interpretarArchivo(){
        java.io.BufferedReader in = null;
        String sLineaArchivoTexto;
        try {
            in = new java.io.BufferedReader(new java.io.FileReader(sRutaArchivo));
            while( (sLineaArchivoTexto = in.readLine()) != null) {
                
                    /**
                     * Convierte la cadena a un arreglo.
                     */
                    String[] a_sDatoTMP = sLineaArchivoTexto.split("\t");
                    
                    /**
                     * Se recorre el arreglo para eliminar los espacios en blanco a traves
                     * de un trim
                     */
                    for (int i = 0; i < a_sDatoTMP.length; i++) {
                        a_sDatoTMP[i] = a_sDatoTMP[i].trim();
                    }
                    
                    /**
                     * Se carga el arreglo a la lista.
                     */
                    arrayDatosArchivo.add(a_sDatoTMP);
           		
            }
            
            /**
             * Se cierra la conexion.
             */
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getArrayDatosArchivo() {
        return arrayDatosArchivo;
    }

    public void setArrayDatosArchivo(ArrayList arrayDatosArchivo) {
        this.arrayDatosArchivo = arrayDatosArchivo;
    }
}
