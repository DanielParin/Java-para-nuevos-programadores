import java.util.Scanner;

public class For {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int resultado;

        System.out.println("Inserte numero");
        int numero = sc.nextInt();

        for (int i=0;i<=10;i++){
            resultado=numero*i;
            System.out.println(numero+"x"+i+"="+resultado);
        }

    }
    /*Para usar el for creamos una variable contador que en este caso (y suele ser) "i", la podemos definir
      dentro del mismo for o fuera de él:
        int i;
        for(i=0;i<...;i++)
        -----------
        for(int i=0;i<...;i++)

      El bucle for es un bucle definido por lo que a diferencia del While y el DoWhile, sabemos cuando empieza
      y cuando acaba. Su funcionamiento es el siguiente:

      for(x;y;z)
      x -> La declaración de inicio del contador, es decir, desde cuando empieza. En nuestro caso empieza
      DESDE que i vale 0 (i=0).
      y -> El "tramo de valores" para los que se sigue ejecutando el bucle, es decir, mientras que eso ocurra
      el bucle for se seguirá ejecutando. En nuestro caso se ejecutará mientras que i sea menor o igual que 10
      (i<=10).
      z -> El funcionamiento del contador, es decir, si va creciendo o decreciendo, puede ser i++ o i-- por lo que
      cada iteración (vuelta) del bucle se irá sumando 1 o restando 1 hasta que no se cumpla la condición. En nuestro
      caso cada vez que se ejecute el codigo del for la i aumentará su valor en 1 (i++).

      Resumen de nuestro caso:
      Iniciamos el contador i a 0 y va sumando 1 mientras que sea menor o igual a 10.
    */

}
