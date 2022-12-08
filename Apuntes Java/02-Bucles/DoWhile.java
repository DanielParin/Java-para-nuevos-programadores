public class DoWhile {

    public static void main(String[] Args){

        int numero = 0;

        do{
            System.out.print(numero+" ");
            numero++;
        }while (numero != 0 && numero <= 10);

    }

    /* El bucle Do While primero ejecuta el código y luego comprueba si se cumple por lo que a diferencia del ejemplo
   del While podemos inicializar el número a 0 porque nos lo ejecuta igual. Debido a que al final del do
   número vale 1 y ya es distinto de 0.
   */

}
