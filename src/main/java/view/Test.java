/* 
    Nombre del programa: Program_2
    Nombre: Andrés David Mojica Ospina
    Fecha: 15-02-2016
    Descripción: Permite visualizar los datos obtenidos y realizar un test del 
    programa.
*/

package view;

import controller.Reporte;

public class Test 
{
    /* Metodo que inicializa el aplicativo*/
    public static void main( String[] args )
    {
        Reporte reporte = new Reporte();
        reporte.generarReporte();
    }   
}