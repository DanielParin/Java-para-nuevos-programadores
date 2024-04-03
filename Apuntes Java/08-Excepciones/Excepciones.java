/*
    Hasta ahora sabemos que al momento de escribir código podemos ver y saber que errores tenemos. Pero, ¿qué ocurre mientras se 
    está ejecutando el código?

    Las excepciones son eso, errores que  nos ocurren mientras el código se ejecuta e interrumpen el flujo del programa.
    Hay muchas excepciones como para explicarlas todas, pero,  la mayoría de ellas se pueden solventar haciendo bien tu código.
    Esto es importante, porque como las excepciones te cortan el programa, lo suyo es no dejar que te salten y que si saltan
    sea por algo que tu no has podido controlar. Por ejemplo:

    Al dividir entre 0 matemáticamente no es un número exacto. Cuando se divide (en programación) entre 0, salta una 
    ArithmeticException. Esta es una de las excepciones que he dicho antes que podemos controlar para que no salten. Ya que
    si sabemos que vamos a hacer una división deberíamos controlar que el divisor no fuera 0.
*/

import java.util.Scanner;

public class Excepciones {


    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Aquí vamos a ver distintas formas de lidiar con las excepciones.

        //1. Try-catch

        try{ // Aquí irá la parte del código que puede lanzar una excepción.
            System.out.print("Inserte un numero para dividir 10: ");

            int numero = sc.nextInt();
            int resultado = 10 / numero;

            System.out.println("El resultado es " + resultado);
        }catch(ArithmeticException e){ // Aquí se manejan las excepciones lanzadas en el try. Si saltan y las ponemos en el catach se ejecuta esta parte.
            System.err.println("Has dividido entre 0. " + e.getMessage());
        }
        // Si pudiera haber mas excepciones las pondríamos como: catch(ArithmeticException | ......  e){...}

        //2. Try-catch-finally

        try{
            System.out.print("Inserte un numero para dividir 100: ");

            int numero = sc.nextInt(); // Poner 0 alguna vez para ver que el finally lo seguirá ejecutando igual.
            int resultado = 100 / numero;

            System.out.println("El resultado es " + resultado);

        }catch(ArithmeticException e){ 
            System.err.println("Has dividido entre 0. " + e.getMessage());

        }finally{ // Se ejecutará independientemente de si se lanzó o no excepción.
            System.out.println("Esto se está ejecutando en el finally.");
        }


        

        
    }

    // Método-throws

    public void dividir( int numero) throws ArithmeticException{ // Con poner aquí la excepción que podría salir en el método nos quitamos el try-catch

        int resultado = 1000 / numero;

        System.out.println("El resultado es: "+ resultado);

    }


    /*
        Por último un uso que veremos en el apartado de ficheros es el try-with-resources. 

        Este caso lo usamos para fragmentos de código que hay que acabar cerrando, por ejemplo, el BufferedReader al terminar de usarlo
        tenemos que poner br.close(), para que no tengas que estar atento de cerrarlo podemos hacer lo siguiente:

        try( creamos el objeto que tendíamos que cerrar){
            ...código...

        }catch(excepción que suelta){....}
    */
    
}