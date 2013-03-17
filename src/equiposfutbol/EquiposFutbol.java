/**
 * CLASE PRINCIPAL  
 */
package equiposfutbol;

import java.util.ArrayList;




public class EquiposFutbol {

   
    public static void main(String[] args) {
        
        //Linea que lee el archivo de texto con los equipos.
        LeerArchivo leerArchivo = new LeerArchivo("Tabla.txt");
        
        /**
         * Llamado a la clase que crea la estructura de la tabla 
         */
        CrearTabla crearTabla = new CrearTabla();
        crearTabla.setArrayDatosArchivo(leerArchivo.getArrayDatosArchivo());
        crearTabla.iniciarProceso();
        
        /**
         * Llamado a la clase que calcula los datos de la tabla de acuerdo 
         * a los encuentros.
         */
        CalcularTabla calcularTabla = new CalcularTabla();
        calcularTabla.setArrayDatosArchivo(leerArchivo.getArrayDatosArchivo());
        calcularTabla.setArrayEquipos(crearTabla.getArrayEquipos());
        calcularTabla.iniciar();
        ArrayList arrayResultado = calcularTabla.getArrayResultado();
        
        /**
         * Llamado a la clase que ordena la tabla de acuerdo a los puntos 
         * obtenidos y a los goles a favor.
         */
        OrdenarTabla ordenarTabla = new OrdenarTabla();
        ordenarTabla.setArrayResultados(arrayResultado);
        ordenarTabla.Iniciar();
        
        /**
         * Arreglo de la tabla ordenada.
         */
        Object[][] aa_sResultadosFinales = ordenarTabla.getAa_sResultadosFinales();
        
        /**
         * Codigo para la impresion de los datos.
         */
        System.out.println("[Equipo\t\tPuntos\t\tPJ\t\tPG\t\tPE\t\tPP\t\tGF\t\tGC\t\tGD]");//Impresion de los titulos
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for (Object[] strings : aa_sResultadosFinales) {
            System.out.println("[" +
                    contarCaracteres(strings[0].toString()) + "\t" + 
                    contarCaracteres(strings[1].toString()) + "\t" + 
                    contarCaracteres(strings[2].toString()) + "\t" + 
                    contarCaracteres(strings[3].toString()) + "\t" + 
                    contarCaracteres(strings[4].toString()) + "\t" + 
                    contarCaracteres(strings[5].toString()) + "\t" + 
                    contarCaracteres(strings[6].toString()) + "\t" + 
                    contarCaracteres(strings[7].toString()) + "\t" + 
                    aumentarPositivo(strings[8].toString()) + "]");
        }
    }
    
    /**
     * Metodo que detecta coloca el simbolo (+) a los datos (GD) - gol diferencia
     * @param sCadena
     * @return 
     */
    private static String aumentarPositivo(String sCadena){
        if(sCadena.length() < 2){
            sCadena = "+" + sCadena;
        }        
        return sCadena;
    }
    
    /**
     * Metodo que completa los datos con espacios en blanco para que 
     * la impresion de la tabla salga ordenada y los tabulados sean 
     * correctos.
     * 
     * @param sCadena
     * @return 
     */
    private static String contarCaracteres(String sCadena){
        
        if(sCadena.length() < 9){
            for (int i = sCadena.length(); i < 9; i++) {
                sCadena += " ";
            }
        }                
        return sCadena;
    }
}
