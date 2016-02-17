/* 
    Nombre del programa: Program_2
    Nombre: Andrés David Mojica Ospina
    Fecha: 15-02-2016
    Descripción: Permite crear un reporte con todas las líneas de código 
    contadas en la clase Contador
*/
package controller;

import java.util.LinkedList;
import model.AbrirArchivo;

public class Reporte 
{
    /* Metodo para generar el reporte */
    public void generarReporte()
    {
        AbrirArchivo a = new AbrirArchivo();
        LinkedList lista_rutas = a.seleccionarRuta();
        Contador c = new Contador();
        LinkedList loc = c.contar(lista_rutas);
        LinkedList total_items = c.contarItem(lista_rutas);
        
        for (int i = 0; i < loc.size(); i++) 
        {
            String ruta = (String) lista_rutas.get(i);
            String nombre_clase = ruta.substring(ruta.lastIndexOf("/") + 1, ruta.length());
            
            // Se imprime el reporte
            System.out.println("Nombre de la clase: " + nombre_clase + " Líneas de Código: " + loc.get(i) + " Items: " + total_items.get(i));
        }
        // Total de lineas del programa
        int total_programa = c.total(loc);
        System.out.println("Tamaño total del programa: " + total_programa);
    }
}