/**
 * CLASE QUE ORDENA LOS DATOS DE LA TABLA
 */
package equiposfutbol;

import java.util.ArrayList;




public class OrdenarTabla {
    
    private ArrayList arrayResultados = null;
    private Object[][] aa_sResultadosFinales = null;

    
    public void Iniciar(){        
        pasarAarreglo();
        aa_sResultadosFinales = OrdenarBurbuja(aa_sResultadosFinales);
    }
    
   
    /**
     * Metodo que convierte la lista a arreglos de tipo Objeto.
     */
    private void pasarAarreglo(){
        
        aa_sResultadosFinales = new Object[arrayResultados.size()][( (Object[]) arrayResultados.get(0)).length ];
        
        for (int i = 0; i < arrayResultados.size(); i++) {
            aa_sResultadosFinales[i] = (Object[])arrayResultados.get(i);            
        }
    }
    
    /**
     * Metodo de ordenacion burbuja modificado para que ordene como 
     * primer criterio los puntos obtenidos, y como segundo criterio 
     * los goles a favor.
     * 
     * @param aa_oDatos
     * @return 
     */
    public Object[][] OrdenarBurbuja(Object[][] aa_oDatos){
        Object[] temp;
        int t = aa_oDatos.length;
        for (int i = 1; i < t; i++) {
            for (int k = t- 1; k >= i; k--) {
                if(Integer.parseInt(aa_oDatos[k][1].toString()) > Integer.parseInt(aa_oDatos[k-1][1].toString()) ){
                    temp = aa_oDatos[k];
                    aa_oDatos[k] = aa_oDatos[k-1];
                    aa_oDatos[k-1]= temp;
                }else if(Integer.parseInt(aa_oDatos[k][1].toString()) == Integer.parseInt(aa_oDatos[k-1][1].toString()) ){
                   if(Integer.parseInt(aa_oDatos[k][6].toString()) > Integer.parseInt(aa_oDatos[k-1][6].toString()) ){
                        temp = aa_oDatos[k];
                        aa_oDatos[k] = aa_oDatos[k-1];
                        aa_oDatos[k-1]= temp;
                    } 
                }
            }// fin 2 for
        }//fin 1 for
        return aa_oDatos;
    }//fin    
    
    
    public ArrayList getArrayResultados() {
        return arrayResultados;
    }

    public void setArrayResultados(ArrayList arrayResultados) {
        this.arrayResultados = arrayResultados;
    }
    
    public Object[][] getAa_sResultadosFinales() {
        return aa_sResultadosFinales;
    }

    
}
