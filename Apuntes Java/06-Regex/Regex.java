import java.util.Scanner;

public class Regex {


    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        String dniPattern = "[0-9]{8}[A-Z]";

        System.out.print("Dime tu DNI: ");
        String dni = sc.next();

        while (!dni.matches(dniPattern)){//Usamos esto para que haga lo del while si no coincide con la Regex
            System.out.print("DNI invalido, inserte otro: ");
            dni = sc.next();
        }
        System.out.println("El DNI introducido es: "+dni);
    }
    /*
   Entenderemos una expresion regular (Regex) como un patron para verificar que la entrada es correcta.
   Hay infinidad de posibilidades con las regex, en este caso protegemos la entrada de valores que
   no tengan 8 numeros del 0 al 9 seguidos de una letra mayuscula de la A a la Z. Por lo que al salir del
   while estaremos muy seguros de que el valor de la variable es el que queremos.
 */
}
