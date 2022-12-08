import java.util.Scanner;

public class EjemploSencillo {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] Args){

        int operando1;
        int operando2;
        int resultado;

        int respuesta;

        System.out.print("Inserte primer operando: ");
        operando1 = sc.nextInt();
        System.out.print("Inserte segundo operando: ");
        operando2 = sc.nextInt();

        System.out.println("Elija operacion: ");
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicacion");
        System.out.println("4- Division");

        respuesta = sc.nextInt();

        switch (respuesta){

            case 1->{
                    resultado=operando1+operando2;
                    System.out.println("El resultado es: "+resultado);
            }
            case 2->{
                    resultado=operando1-operando2;
                    System.out.println("El resultado es: "+resultado);
            }
            case 3->{
                    resultado=operando1*operando2;
                    System.out.println("El resultado es: "+resultado);
            }
            case 4->{
                    resultado=operando1/operando2;
                    System.out.println("El resultado es: "+resultado);
            }
            default-> System.out.println("Error al insertar numero de operacion. ");
        }
    }
}
