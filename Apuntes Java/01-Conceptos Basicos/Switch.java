import java.util.Scanner;

public class Switch {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int respuesta;

        System.out.print("Introduce un numero: ");
        respuesta = sc.nextInt();

        switch (respuesta){

            case 1-> System.out.println("Has introducido 1.");
            case 2-> System.out.println("Has introducido 2.");
            case 3-> System.out.println("Has introducido 3.");
            default-> System.out.println("Has introducido un numero que no se analizar.");
        }

    }
    /* El when funcicona como una cadena de if-elseIf, pero más limpio (clean code).
   Dependiendo del valor de respuesta se hace lo que este asignado a ese valor, si respuesta es igual a 1,
   ejecuta lo asignado a 1 (println("Has introducido 1.")), si no se cumple ninguna condicion entrará al default.
 */
}
