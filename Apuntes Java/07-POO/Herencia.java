
/*
    La herencia es un concepto muy importante de la programación orientada a objetos.
    Consiste en una clase padre (superclase) que consta de una o mas clases hijas (subclases), las cuales obtinen (heredan) los métodos y 
    atributos de la clase padre.
    Un ejemplo, que luego veremos implementado, tenemos la clase animal (superclase) de la cual heredan perro y gato. Las dos son animales
    pero no son la misma clase por lo cual tendrán todo lo de un animal y cosas modificadas o cosas propias del tipo de animal.
*/

class Animal{

    //Atributos de la clase
    String nombre;
    int edad;

    //Constructor de la clase
    public Animal (String nombre, int edad){ 
        this.nombre=nombre;
        this.edad=edad;
    }

    //Metodo de la clase
    public void ejecutarSonido(){
        System.out.println("Estoy haciendo un sonido");
    }
}

class Perro extends Animal{ // Con "extends Animal" decimos que herede perro herede de animal.

    // Atributos propios de la subclase
    boolean conChip;

    //Constructor de la subclase
    public Perro(String nombre, int edad, boolean conChip){
        super(nombre, edad); // Como el perro tiene los atributos de animal, para el constructor le pasamos el constructor de la superclase.
        this.conChip=conChip; // Y luego el resto de atributos propios de la subclase, los tratamos como siempre.
    }

    //Metodo propio de la subclase
    public void pasear(){
        System.out.println("Estoy paseando.");
    }


    @Override // Aqui podemos modificar el método de la superclase con @Override
    public void ejecutarSonido(){
        System.out.println("Guau Guau Guau");
    }
}


class Gato extends Animal{

    String color;

    public Gato(String nombre, int edad, String color){
        super(nombre, edad);
        this.color = color;
    }

    public void limpiarse(){
        System.out.println("Me estoy limpiando.");
    }

    //Vamos a dejar el metodo de la superclase sin modificar para ver lo que pasa.
}


public class Herencia { // Esta clase la usaremos solo para el main.
    
    public static void main(String[] args) {
        
        //Creamos e instanciamos el objeto perro.
        Perro perro = new Perro("Rex", 9, true); 
        Gato gato = new Gato("Xer", 2, "Naranja");


        perro.ejecutarSonido();
        gato.ejecutarSonido(); // Como no lo hemos modificado el método lo ejecuta con lo heredado de la superclase.
        
    }
}

/*
    Podemos ver como ambas clases (Perro y Gato) tienen nombre y edad pero luego tienen otros atributos y otra forma de funcionar
    aún siendo los dos animales, eso es lo que nos aporta la herencia.
*/
