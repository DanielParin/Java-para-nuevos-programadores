public class While {


    public static void main(String[] Args){

        int numero = 0;

        while(numero<=10){
            numero++;// Es lo mismo que poner numero = numero+1;
            System.out.print(numero+" ");
        }
    }
   /* Para entrar al bucle while hay que cumplir la condición si no no entra.
   El bucle while se ejecutará cuando deje de cumplirse la condición
   Primero comprueba y luego ejecuta, por eso nos acaba escribiendo un 11, porque la última vez que lo hace entra como
   10, luego suma 1 imprime el 11 y como el número ya es 11 se sale
   */
}
