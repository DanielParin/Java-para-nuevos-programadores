/*
    Para leer y escribir en ficheros vamos a usar  la clase que nos aporta java.io llamada BufferedReader/Writer y FileWriter/Reader.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Texto{

    public static void main(String[] args){
        
        String archivo = "texto.txt"; // Nombre del archivo(si está en el mismo directorio) o ruta al archivo (si está en otro sitio).

        
        //ESCRITURA DEL FICHERO DE TEXTO
        
        // Como el bufferedwriter/reader necesitamos cerrarlo usamos el try-whit-resources.
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            //Si el fichero no existe a la hora de escribir lo crea.

            bw.write("Esta será la primera línea en nuestro fichero de texto.");
            bw.newLine();// Es hacer un salto de línea en el fichero, solo con el write no saltamos de línea.
            bw.write("Este texto estará en la segunda línea del fichero.\n"); // Si ponemos \n si hacemos un salto de línea.
            bw.write("Este texto estará en la tercera línea del fichero.");
            bw.write("Esto seguirá en la tercera línea del fichero.\nY este está en la cuarta.");

        } catch(IOException e){ // La excepción que obtendríamos es una IOException, por eso la recogemos aquí.
            System.err.println("Error escribiendo en el archivo: " + e.getMessage()); // Imprimimos lo que ha sucedido.
        }


        //LEER DEL FICHERO DE TEXTO

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        //Si el fichero no existe al leer nos salta una excepción.

        String linea;// Donde guardaremos las lineas que leamos del fichero.

        while ((linea = br.readLine()) != null) { // La condición dice, en pocas palabras, si leemos una linea y hay algo, seguimos leyendo, si no salimos del bucle y dejamos de leer.
            System.out.println(linea); // Imprimimos lo que hayamos leído en la iteración del bucle.
        }

    } catch (IOException e) {
        System.err.println("Error escribiendo en el archivo: "+ e.getMessage());
    }
    }

}