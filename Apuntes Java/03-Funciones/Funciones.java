import java.util.Scanner;

public class Funciones {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int resultado;

        System.out.print("Inserte valor del primer operando: ");
        final int operando1 = sc.nextInt();
        System.out.print("Inserte valor del segundo operando: ");
        final int operando2 = sc.nextInt();

        resultado=suma(operando1,operando2);
        System.out.println("El resultado de la suma es: "+resultado);
        resultado=resta(operando1,operando2);
        System.out.println("El resultado de la resta es: "+resultado);

    }

    private static int suma(int operando1,int operando2){

        int resultado = operando1+operando2;
        return resultado;
    }

    private static int resta(int operando1,int operando2){
        return operando1-operando2;//Otra forma de hacerlo.
    }
    /*
    A la hora de hacer una funcion tenemos que tener en cuenta 2 cosas, que le pasamos y si devuelve algo.

    INVOCAR FUNCION
    Puede pasar que no devuelva nada: nombreFuncion(x,y)
    O que devuelva algo: variable = nombreFuncion(x,y)

    FUNCION
    A la hora de programar la funcion tenemos que ver que tipo son los parametros que nos pasan,
    en este caso nos pasan dos numeros que son enteros, de ahi que pongamos:
        (int operando1,int operando2)
    Luego como hacemos que nos devuelva un valor la función, antes de escribir el nombre de la funcion y
    después de definir si es privada/pública y static, decimos que tipo de dato nos devuelve, en este caso nos
    devuelve un entero y por eso ponemos:
        private static int  (si nos devolviera un double, private static double, y asi el resto)
    Dentro de la función funciona como un main normal, pero dentro de la funcion solo y si queremos retornar
    un valor, lo pondremos con return x.
    En nuestro caso, la variable resultado del main recoge el valor que devuelve el return de la funcion, o
    como en el otro caso retornamos directamente el resultado la resta y no una variable.
 */
}
