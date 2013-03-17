/**
 * CLASE QUE PERMITE CALCULAR LOS DATOS DE ACUERDO A LOS ENCUENTROS.
 * 
 */
package equiposfutbol;

import java.util.ArrayList;



public class CalcularTabla {
    
    /**
     * Lista que recibe los datos del archivo
     */
    private ArrayList arrayDatosArchivo = null;
    
    /**
     * Lista que recibe los nombres de los equipos.
     */
    private ArrayList arrayEquipos = null;
    
    /**
     * Lista que guardara la tabla con los resultados de los calculos.
     */
    private ArrayList arrayResultado = new ArrayList();

    
    /**
     * Constructor de la clase.
     */
    public CalcularTabla(){
        
    }
    
    
    /**
     * Metodo que inicia el proceso.
     */
    public void iniciar(){
        calcular();
    }
    
    /**
     * Metodo que genera el calculo de los partidos llamando el metodo 
     * contar.
     */
    private void calcular(){
        
        for (int i = 0; i < arrayEquipos.size(); i++) {
            String sEquipo = arrayEquipos.get(i).toString();
            
            
            arrayResultado.add(contar(new Object[]{
                sEquipo, //Equipo
                0, //Puntos
                0, //Partidos jugados
                0, //Partidos ganados 
                0, //Partidos empatados
                0, //Partidos perdidos   
                0, //Goles a Favor
                0, //Goles en contra
                0  //Gol diferencia
            }));
            
            
        }
    }
    
    /**
     * Metodo que permite calcular de acuerdo a encuentro los datos de la 
     * tabla.
     * 
     * 
     * @param a_sEquipo
     * @return 
     */
    private Object[] contar(Object[] a_sEquipo){
        
        String sNombre = a_sEquipo[0].toString();
        int iPuntos = Integer.parseInt(a_sEquipo[1].toString());
        int iPartidosJugados = Integer.parseInt(a_sEquipo[2].toString());
        int iPartidosGanados = Integer.parseInt(a_sEquipo[3].toString());
        int iPartidosEmpatados = Integer.parseInt(a_sEquipo[4].toString());
        int iPartidosPerdidos = Integer.parseInt(a_sEquipo[5].toString());
        int iGolesFavor = Integer.parseInt(a_sEquipo[6].toString());
        int iGolesContra = Integer.parseInt(a_sEquipo[7].toString());
        int iGolDiferencia = Integer.parseInt(a_sEquipo[8].toString());
        
        
        for (int i = 0; i < arrayDatosArchivo.size(); i++) {
            Object[] a_sObject = (Object[])arrayDatosArchivo.get(i);
            
            String sEquipoA = a_sObject[0].toString();
            String sEquipoB = a_sObject[1].toString();
            int iMarcadorA = Integer.parseInt(a_sObject[2].toString());
            int iMarcadorB = Integer.parseInt(a_sObject[3].toString());
            
            /**
             * Estructuras de desicion que permiten calcular los valores 
             * de acuerdo a las combinaciones posibles
             */
            if(sEquipoA.equals(sNombre)){
                if(iMarcadorA == iMarcadorB){
                    iPuntos += 1;
                    iPartidosJugados += 1;
                    iPartidosEmpatados += 1;
                    iGolesFavor += iMarcadorA; //Puede ser tambien iMarcadorB
                    iGolesContra += iMarcadorB;
                }else{
                    if(iMarcadorA > iMarcadorB){
                        iPuntos += 3;
                        iPartidosJugados += 1;
                        iPartidosGanados += 1;
                        iGolesFavor += iMarcadorA;
                        iGolesContra += iMarcadorB;
                    }else{
                        iPartidosPerdidos += 1;
                        iPartidosJugados += 1;
                        iGolesFavor += iMarcadorA;
                        iGolesContra += iMarcadorB;
                    }
                }
            }else{
                if(sEquipoB.equals(sNombre)){
                    if(iMarcadorB == iMarcadorA){
                        iPuntos += 1;
                        iPartidosJugados += 1; 
                        iPartidosEmpatados += 1;
                        iGolesFavor += iMarcadorA;
                        iGolesContra += iMarcadorB;
                    }else{
                        if(iMarcadorB > iMarcadorA){
                            iPuntos += 3;
                            iPartidosJugados += 1;
                            iPartidosGanados += 1;
                            iGolesFavor += iMarcadorB;
                            iGolesContra += iMarcadorA;
                        }else{
                            iPartidosPerdidos += 1;
                            iPartidosJugados += 1;
                            iGolesFavor += iMarcadorB;
                            iGolesContra += iMarcadorA;
                        }
                    }
                }
            }
            
        }
        
        /**
         * El gol diferencia sepuee calcular teniendo el gol a favor 
         * y el gol en contra, por eso no entra en la estructura de 
         * desiciones.
         */
        iGolDiferencia = iGolesFavor - iGolesContra;
        
        /**
         * Retorna arreglo con calculos.
         */
        return (new Object[]{
            sNombre, 
            iPuntos, 
            iPartidosJugados, 
            iPartidosGanados, 
            iPartidosEmpatados, 
            iPartidosPerdidos, 
            iGolesFavor, 
            iGolesContra, 
            iGolDiferencia
        });
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

    public void setArrayEquipos(ArrayList arrayEquipos) {
        this.arrayEquipos = arrayEquipos;
    }
    
    public ArrayList getArrayResultado() {
        return arrayResultado;
    }
}
