
/*
    El concepto de interfaces es parecido a la herencia.
    En este caso no definimos una clase sino una interfaz. Una interfaz es una especie de contrato con la clase, definiremos los métodos que 
    queramos y luego la clase que la implemente deberá tener los métodos de la interfaz, si no los tiene nos da un error.
*/

interface Trabajador {

    // Aquí solo definimos los métodos, no hace falta desglosarlos y poner aquí el código que ejecutan.
    void trabajar(); // Definimos un método de tipo void llamado trabajar.
    void descansar(int tiempo); // Definimos un método de tipo void que recibe un int como argumento y lo llamamos descansar.
    
}

class Persona implements Trabajador{ // con "implements Trabajador" definimos que implemente la interfaz Trabajador.
    // Aquí veremos que nos dará error hasta que no implementemos los métodos de la interfaz.
    public void trabajar(){
        System.out.println("Estoy trabajando.");
    }

    public void descansar(int tiempo){
        System.out.println("Estoy descansando "+tiempo+" minutos.");
    }

    //No vamos a definir atributos ya que no tienen mucha relevancia aquí.
}
public class Interfaces { // Clase usada solo como main.

    public static void main(String[] args) {

        Persona persona = new Persona();

        persona.trabajar();
        persona.descansar(12);
    }


}
