

/*

    Hasta ahora hemos empleado clases aunque sin reparar mucho en ellas, ya que Java es un lenguaje orientado a objetos. Lo que haciamos era dentro de una clase
    poner el main para ejecutar el código y dentro del main teníamos todo el código. Pero ahora vamos a "explotar" el concepto de clase.

    Entendemos una clase como un tipo de dato. Es decir, podemos englosar varios datos(campos) con sus tipos de dato en un solo tipo de dato personalizado(Clase).
    Una clase consta de una serie de campos y un constructor básicamente.
    Campos -> Los datos de los que constará nuestra clase.
    Constructor -> La manera que tendremos de crear/instanciar variables de esa clase.

    Cuando creamos una variable de una clase. Lo que en realidad hacemos es crear un objeto. Por lo que en realidad de denominar variable a lo que definimos,
    lo llamamos objeto.

    Para instanciar (crear en memoria) un objeto necesitaremos llamar al constructor de la clase.
*/

public class Clases {

    public int campo1; // Aqui definimos un atributo(campo) llamado campo1 de tipo entero que es de acceso público (puede ser usado desde cualquier parte del programa, otras clase u otras partes de código).
    private String campo2; // Aquí definimos un atributo privado, con lo que  no se podrá acceder desde fuera de la propia clase.
    /*
        Si un atributo privado no se puede acceder desde fuera de la clase, ¿Cómo accedemos a él desde fuera?

        Para ello emplearemos 2 métodos de clase.
        Un método de clase es una función asociada a la propia clase, por lo cual no los llamamos como a las funciones normales, sino que tenemos que pasar por
        la clase primero. Algunos métodos de clase muy conocidos son:
        Getters y setters -> para obtener o dar valores a un atributo. Se suele definir con get/set<NombreDelCampo>
        Constructores -> para instanciar objetos de una clase.
        HasCode -> para devolver un valor hash único para cada objeto.
        ToString -> para obtener un String con los datos indicados(suelen ser los datos del objeto).
        Equals -> para comparar si dos objetos son iguales.
    */



    public String getCampo2() { // Nos servirá para obtener el valor del campo2.
        return campo2;
    }

    public void setCampo2(String campo2) { // Nos servirá para dar valor al campo2.
        this.campo2 = campo2;
    }

    //Definición del constructor

    public Clases (int campo1, String campo2){ // Creacion: public <nombreClase> (atributos que queramos darle valor y su tipo)
        this.campo1 = campo1; // this. -> hace referencia a que son del objeto, cuando ponemos un this. siempre nos metemos al objeto que estamos "tocando".
        this.campo2 = campo2;
    }
    @Override // Como el método toString ya viene por defecto ponemos esto para sobreescribirlo como queramos.
    public String toString() { 
        
        return "Campo1: "+campo1+" Campo2: "+campo2; // Cuando imprimamos la clase lo imprimirá de esta forma.
    }

    public void saludar(){ // Esto es un método de clase. Una función que realiza algo.
        System.out.println("Yo soy el "+campo1);
    }
    public static void main(String[] args) {
        
        //Vamos a crear un objeto clase

        Clases clase; //Aqui hemos definido un objeto pero no lo instanciamos hasta que llamemos al constructor.

        clase = new Clases(1, "Primer objeto"); //Aquí ya hemos instanciado el objeto. 
        
        Clases clase2 = new Clases(2, "Segundo objeto");

        System.out.println(clase.campo2);
        System.out.println(clase2); //Aquí imprimirá lo definido en el método toString
        System.out.println(clase.campo1+clase2.campo1);

        clase.saludar(); // Como saludar es un método de clase lo tenemos que llamar desde el objeto creado que queremos que realice el método.
        clase2.saludar(); 
    }
}