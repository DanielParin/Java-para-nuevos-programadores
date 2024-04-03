/*
    Para empezar debemos saber que es un fichero.csv :

    Un fichero .csv es un fichero de texto donde almacenamos datos en forma de filas y columnas. Para saber a que corresponde
    cada dato precisamos primero un encabezado donde irán los titulos de cada columna y los valores.
    
    Todo esto va separado por un caracter cualquiera, normalmente comas. Este caracter es el que nos
    separa los datos en columnas. 

    Columna1,Columna2,....
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Csv {
    
    public static void main(String[] args) {
        
        
        // Método para escribir el csv.
        escribirCsv();


        // Método para leer el csv.
        leerCsv();
    }


    public static void escribirCsv(){
        String fichero = "data.csv";
        String[] encabezado = {"Nombre","Edad","Ciudad"};
        String[] datos = {"Rafa","27","Madrid"};

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))){

            bw.write(String.join("," , encabezado)); // Escribimos los elementos de encabezado separados por comas.
            bw.newLine();
            bw.write(String.join("," , datos)); // Al igual que antes escribimos los elementos de datos separados con comas.

        }catch(IOException e){
            e.printStackTrace();
        }

        // El caracter que nos dirá a qué pertenece cada dato es la coma.
    }

    public static void leerCsv(){
        String fichero = "data.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            
            String linea;

            while((linea = br.readLine()) != null){
                String[] datos = linea.split(","); // Separamos la linea que leemos por las comas para ir obteniendo  un array donde cada elemento es un dato.

                //Nos imprimirá el encabezado también pero sería hacer un retoque sencillo.
                System.out.println("Nombre: "+ datos[0]);
                System.out.println("Edad: "+datos[1]);
                System.out.println("Ciudad: "+datos[2]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
