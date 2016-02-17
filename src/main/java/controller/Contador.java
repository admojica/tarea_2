/* 
    Nombre del programa: Program_2
    Nombre: Andrés David Mojica Ospina
    Fecha: 15-02-2016
    Descripción: Permite realizar el conteo de las líneas de código totales y por item.
*/
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Contador 
{
    LinkedList<Integer> lineas_codigo = new LinkedList<>();
    LinkedList<Long> numero_items = new LinkedList<>();
    
    /* Metodo para contar el numero de lineas*/
    public LinkedList contar(LinkedList lista_rutas)
    {
        for (int i = 0; i < lista_rutas.size(); i++) 
        {
            int numero_lineas = 0;
            String ruta = (String) lista_rutas.get(i);

            try
            {
                FileReader lector = new FileReader(ruta);
                BufferedReader buffer = new BufferedReader(lector);    
                String linea;
                while (( linea = buffer.readLine()) != null) 
                {   
                    linea = linea.trim();
                    if(linea.length() != 0) 
                    { 
                        numero_lineas++; 
                    }            
                }
                lineas_codigo.add(numero_lineas);
            }
            catch(IOException ex)
            {
                System.out.println("Error al abrir el archivo para contar: " + ex);
            }
        }
        return lineas_codigo;
    }
    
    /* Metodo para contar el numero de items */
    public LinkedList<Long> contarItem(LinkedList lista_rutas)
    {
        for (int i = 0; i < lista_rutas.size(); i++) 
        {
            try
            {
                FileReader lector = new FileReader((String) lista_rutas.get(i));
                BufferedReader buffer = new BufferedReader(lector);
                long numero_metodos = 0;
                String linea;
                while (( linea = buffer.readLine()) != null) 
                {   
                    linea = linea.trim();
                    if((linea.length() != 0) && (linea.startsWith("/* Metodo"))) 
                    { 
                        numero_metodos++;
                    }            
                }
                numero_items.add(numero_metodos);
            }
            catch(IOException ex)
            {
                System.out.println("Error al abrir el archivo para contar items: " + ex);
            }
        }
        return numero_items;
    }
    
    /* Metodo para contar el total de lineas del programa */
    public int total(LinkedList lista)
    {
        int total = 0;
        for(int i = 0; i < lista.size(); i++) 
        {
            total = total + (Integer) lista.get(i);
        }
        return total;
    }
}