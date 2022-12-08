import java.util.Scanner;

public class IfElseIf {

    private final static Scanner sc = new Scanner(System.in);



    public static void main(String[] Args){

        int numero;

        System.out.print("Inserte numero: ");
        numero = sc.nextInt();

        if (numero == 0){
            System.out.println("El numero es 0.");
        }else if (numero<0) {
            System.out.println("El numero es menor que 0.");
        }else{ //Si no cumple nada de lo anterior entra aquí.
            System.out.println("El numero es mayor que 0.");
        }
    }

    /* El codigo se ejecuta secuencialmente por lo que se hace de arriba a abajo, y en este caso en concreto
       entrara en el primer if/else if que sea cierto y terminará el programa.
       If -> Si se cumple la condición entre paréntesis entra al código entre corchetes, si no se cumple
             sigue al else/elseIf (si pasa esto me haces esto)
       Else -> Cuando no se cumple la condición del if entra al else independientemente de lo que valga la
       condicion empleada en el if. ( si no pasa esto(if), me haces esto(else))
       Else If -> Es equivalente a dentro del else poner un if. (Si no pasa esto(if), si pasa esto(else if),
                  si no pasa nada de lo anterior me haces esto(else)
     */
    /*
        OPERADORES PARA CONDICIONES:
        != -> sea distinto, como tal la ! delante significa no, en este caso no sea igual.
        == -> sea igual, no confundir con un solo igual, ya que eso no es una condición sino una asignación
              de valor.
        < -> sea menor que , no incluye el propio número.
        > -> sea mayor que, no incluye el propio numero.
        <=,>= -> sea menor igual/mayor igual que, incluye el número.
        ENTRE CONDICIONES:
        x && z -> si pasa x y pasa z me lo haces, con que una no se cumpla ya no lo hace.
        x || z -> si pasa x o pasa z me lo haces, con que se cumpla minimo una lo hace.
     */
}
