//Necesario hacer un proyecto maven para importar las dependencias (poo.xml).

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Persona {

    String nombre;
    int edad;
    String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

}

class Personas {

    List<Persona> personas;

    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

}

public class Json { // Solo usada para el main
    public static void main(String[] args) {

        // Creamos e instanciamos tres personas
        Persona persona = new Persona("Adrian", 15, "Madrid");
        Persona persona1 = new Persona("Carmen", 26, "Caceres");
        Persona persona2 = new Persona("Claudia", 21, "Avila");

        // Creamos una lista de personas y le añadimos las personas creadas
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(persona);
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);

        // Creamos e instanciamos el objeto Personas pasándole la lista que hemos creado
        Personas personas = new Personas(listaPersonas);

        // Aqí creamos el objeto gson y como le vamos a agregar unas cosas ponemos el
        // new GsonBuilder() -> .setPrettyPrinting() : Para que nos de un json bonito,
        // no todo en una línea. -> .create() : Creamos el objeto.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // ESCRIBIR EL JSON

        // Usamos try-with-resources con Print y File writer para escribir el fichero
        // personas.json
        try (PrintWriter pw = new PrintWriter(new FileWriter("personas.json"))) {
            gson.toJson(personas, Personas.class, pw); // Decimos que queremos pasar a Json el objeto "personas",
                                                       // teniendo como clase modelo "Personas.class", escribiendo con
                                                       // el objeto "pw".
        } catch (IOException e) {
            e.printStackTrace();
        }

        // LEER EL JSON

        // Lo mismo que al escribirlo pero para leerlo.
        try (FileReader fr = new FileReader("personas.json")) {

            Personas personasFichero = gson.fromJson(fr, Personas.class); // Lo pasamos de json a objeto lo que leemos
                                                                          // en el "fr" usando de modelo
                                                                          // "Personas.class"
            List<Persona> personasLeidas = personasFichero.personas; // Lo leido lo pasamos a una lista normal.

            // Imprimimos lo que vayamos leyendo.
            for (Persona personaLeida : personasLeidas) {

                System.out.println("Nombre: " + personaLeida.nombre);
                System.out.println("Edad: " + personaLeida.edad);
                System.out.println("Ciudad: " + personaLeida.ciudad);
            }

        } catch (FileNotFoundException || IOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}