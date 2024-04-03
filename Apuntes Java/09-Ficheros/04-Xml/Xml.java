//Necesario hacer un proyecto maven para importar las dependencias (poo.xml).

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Root indica que es elemento raiz, es decir, es un elemento propio que es independiente de otro elemento.
// Si no se crearía una clase superior donde estaría contenida.
@Root
class Personas {

    @ElementList(inline = true) // Declaramos que todos los elementos vayan en uno mismo.
    List<Persona> personas;

    public Personas(List<Persona> personas) {
        this.personas = personas;
    }

    // En simple-xml es necesario crear otro constructor vacío aparte para que la
    // biblioteca pueda crear objetos de esta clase.
    public Personas() {
    }

}

@Root
class Persona {

    @Element // Declaramos que, en este caso, la variable nombre es un elemento de la clase
             // que lo contiene.
    String nombre;
    @Element
    int edad;
    @Attribute // Declaramos que ciudad es un atributo de la clase que lo contiene.
    String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public Persona() {
    }
}

public class Xml {

    public static void main(String[] args) {

        // Creamos e instanciamos 3 personas.
        Persona persona = new Persona("Claudia", 21, "Avila");
        Persona persona1 = new Persona("Jose", 35, "Oviedo");
        Persona persona2 = new Persona("Matilde", 64, "Jaen");

        // Creamos e instanciamos una lista vacía y posteriormente le agregamos las
        // personas creadas.
        List<Persona> personasLista = new ArrayList<>();
        personasLista.add(persona);
        personasLista.add(persona1);
        personasLista.add(persona2);

        // Creamos e instanciamos el objeto Personas pasándole la lista que hemos creado
        Personas personas = new Personas(personasLista);

        Serializer serializer = new Persister(); // El serializer nos servirá para pasar Clases a xml y viceversa.
        File fichero = new File("personas.xml"); // Indicamos el nombre del archivo a leer/escribir.

        // ESCRIBIR EL XML
        try {
            serializer.write(personas, fichero); // Decimos que escriba la variable personas y en que fichero.
        } catch (Exception e) {
            e.printStackTrace();
        }

        // LEER EL XML
        Personas personasLeidas = serializer.read(Personas.class, fichero);// Decimos que clase vamos a leer y de que
                                                                           // fichero.

        // Para cada persona escribimos sus atributos.
        for (Persona persona : personasLeidas.personas) {
            System.out.println("Nombre: " + persona.nombre);
            System.out.println("Edad: " + persona.edad);
            System.out.println("Ciudad:  " + persona.ciudad);
            System.out.println("----------------------------------");
        }
    }
}
