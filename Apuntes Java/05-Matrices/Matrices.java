import java.util.Scanner;

public class Matrices {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int[][] matriz = new int[3][3];
        int[][] matriz2 = new int[3][3];

        //misma metodologia que con los arrays, solo que aqui tenemos array de arrays de enteros:
        //[[1][2][3]] [[1][2][3]] [[1][2][3]]

        //para usar matrices, las usamos como si fuera un array pero con dos posiciones
        // i -> "fila"
        // j -> "columna"


        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print("Inserte numero a la matriz: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
            matriz2[i][j]=matriz[i][j];
            }
        }

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(matriz2[i][j]+" ");//para que después de cada numero haga un salto de linea.
            }
            System.out.println();//para cuando acabe de imprimirse una fila salte de línea y sea más visual.
        }
    }
}
