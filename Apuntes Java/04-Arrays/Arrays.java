import java.util.Scanner;

public class Arrays {
    // Un array es un conjunto de elementos del mismo tipo ya sea enteros, doubles, char, etc.

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int[] array = new int[5];
        int[] array2 = new int[5];

        /* En este caso hemos creado un array de tamaño 5, es decir 5 posiciones, como hemos definido int[]
           lo que tenemos es un conjunto(array) de 5 numeros entero. Ej:[1][2][3][4][5]
         */

        for (int i=0; i<array.length;i++){

            /* Para trabajar con los valores del array, lo hacemos por posiciones, si queremos trabajar u operar
               con el primer número del array hacemos referencia a la posicion cero, es decir array[0].
               Tener en cuenta que el número con el que quieres trabajar, la posicion en la que esta es un número menos.
             */
            System.out.print("Inserte numero del array: ");
            array[i]=sc.nextInt();
        }

        for (int i=0;i< array.length;i++){
            array2[i]=array[i];//Para trabajar con arrays trabajamos por posiciones, no array2=array.
        }

        for (int i=0;i< array.length;i++){
            System.out.print(array2[i]+" ");
        }
    }
}
