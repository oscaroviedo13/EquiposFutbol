/**
 * CLASE QUE OPTIENE LA TABLA DE EQUIPOS PARTICIPANTES.
 */
package equiposfutbol;

import java.util.ArrayList;




public class CrearTabla {
    
    private ArrayList arrayDatosArchivo = null;
    private ArrayList arrayEquipos = null;

    public CrearTabla() {}

    
    public void iniciarProceso(){
        identificarEquipo();
    }
    
    
    /**
     * Metodo que carga la tabla de equipos sin repetir.
     */
    private void identificarEquipo(){
    
        arrayEquipos = new ArrayList();
        
        for (int i = 0; i < arrayDatosArchivo.size(); i++) {
            String[] a_sObject = (String[]) arrayDatosArchivo.get(i);
            
            if(i == 0){
                arrayEquipos.add(a_sObject[0]);
            }else{
                boolean bEquipoRepetido = buscarEquipoRepetido(a_sObject[0]);
                
                if(bEquipoRepetido == false){
                    arrayEquipos.add(a_sObject[0]);
                }
            }
        }
    }
    
    /**
     * Metodo que busca que un equipo no se repita.
     * @param sEquipo
     * @return 
     */
    private boolean buscarEquipoRepetido(String sEquipo){
        boolean bRetorno = false;
        
        for (int i = 0; i < arrayEquipos.size(); i++) {
            Object object = arrayEquipos.get(i);
            
            if(object.toString().equals(sEquipo)){
                bRetorno = true;
                break;
            }
        }
        return bRetorno;
    }
    
    
    public ArrayList getArrayDatosArchivo() {
        return arrayDatosArchivo;
    }

    public void setArrayDatosArchivo(ArrayList arrayDatosArchivo) {
        this.arrayDatosArchivo = arrayDatosArchivo;
    }

    public ArrayList getArrayEquipos() {
        return arrayEquipos;
    }
    
}
