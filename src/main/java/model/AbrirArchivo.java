/* 
    Nombre del programa: Program_2
    Nombre: Andrés David Mojica Ospina
    Fecha: 15-02-2016
    Descripción: Permite abrir un archivo para que sea contado posteriormente.
*/
package model;

import java.io.File;
import java.util.LinkedList;
import javax.swing.JFileChooser;

public class AbrirArchivo 
{
    LinkedList<String> lista_rutas = new LinkedList<>();
    
    /* Metodo para seleccionar la ruta en la que estan las clases para contar*/
    public LinkedList seleccionarRuta()
    {
        LinkedList lista_clases = null;
        try
        {
            // Metodo que permite cargar la ventana para escoger el directorio
            JFileChooser file_chooser = new JFileChooser();
            file_chooser.setCurrentDirectory(new java.io.File("."));
            //Desactiva las opciones para escoger archivos que no sean directorios
            file_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            file_chooser.setAcceptAllFileFilterUsed(false);
            
            if (file_chooser.showOpenDialog(file_chooser) == JFileChooser.APPROVE_OPTION)
            { 
                lista_clases = recorrerDirectorio(new File(String.valueOf(file_chooser.getSelectedFile())));
            }
            else 
            {
                System.out.println("No selecciono ningún directorio.");
            }
        }
        catch(Exception ex)
        {
            System.out.println("No se pudo abrir la ruta: " + ex);
        }
        return lista_clases;
    }
    
    /* Metodo para recorrer todas las carpetas del directorio escogido */
    public LinkedList recorrerDirectorio(File directorio) 
    {
        String ruta;
        File lista_archivos[] = directorio.listFiles();
        if (lista_archivos != null) 
        {
            for(int i = 0; i < lista_archivos.length; i++) 
            {
                if (lista_archivos[i].isDirectory()) 
                {
                    recorrerDirectorio(lista_archivos[i]);
                } 
                else 
                {
                    ruta = String.valueOf(lista_archivos[i]);
                    if(ruta.endsWith(".java") || ruta.endsWith(".JAVA"))
                    {
                        lista_rutas.add(ruta);
                    }                  
                }
            }
        }
        return lista_rutas;
    }
}