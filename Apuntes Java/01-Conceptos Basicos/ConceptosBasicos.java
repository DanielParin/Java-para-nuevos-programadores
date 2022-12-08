import java.util.Scanner;

public class ConceptosBasicos {

    /*Tener en cuenta que todo en java tiene que estar dentro de una clase.
      La clase tiene que empezar por mayúscula.
      Y para realizar nuestros ejemplos sencillos, escribiremos dentro de un main.
     */

    private static final Scanner sc = new Scanner(System.in);
    /* El Scanner es una clase que nos permitirá leer por teclado, y la defino aqui para poder usarla
       en el main y si hubiera alguna funcion, si no "sería como una variable" y tienes que tener en cuenta
       el entorno donde está definida. El nombre puede ser el que quieras, en nuestro caso es sc, que usaremos
       luego para hacer referencia a él.
    */

    public static void main(String[] Args){//Definimos el main y empezamos nuestro programa.

        int numero = 3;
        final char letra = 'a';


        System.out.println("Inserte numero:");//println salta de linea, print en la misma linea.
        numero = sc.nextInt();
        System.out.println("Inserte frase:");
        String frase=sc.next();


        /*
          En Java declararemos el tipo de dato antes de nombrar la variable.
          La podemos declarar dandole un valor o solo mediante el tipo.
          Recordad poner puntos y coma al final de cada línea de codigo.

          final lo usaremos cuando no queramos modificar el valor de esa variable, en este caso no dejará
          asignar otro valor a letra más que el que ya tiene (a).
          Si no utilizamos final, podemos asignar valor o cambiarlo, independientemente de si ya tenía uno.
         */

        System.out.println("El numero es: "+numero+" PD:Es entero.");//ver como aqui no coge el 3, sino el valor leido por teclado.
        System.out.println("La letra es: "+ letra);
        System.out.println(frase);

        // poniendo sout y dando a enter se pone directamente el codigo para escribir por pantalla.(TRUCO)
        /*
         Para escribir una cadena junto con una variable, tenemos que emplear lo que se conoce como concatenación,
         es decir, tendremos que juntar cadenas usando +
         En este caso unimos cadenas entre comillas con las variables que definimos antes.
         */
    }

}
