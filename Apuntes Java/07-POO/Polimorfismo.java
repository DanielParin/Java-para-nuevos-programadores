/*
    El polimorfismo es un concepto que sin querer lo hemos visto pero vamos a incidir en él porque es importante tenerlo en cuenta.
    El polimorfismo es un concepto que permite a una clase hija ser una instancia de la del padre pero tener un comportamiento propio.
    Para entenderno vamos a poner un ejemplo.
    Tú eres una persona pero no te tratan igual si estas trabajando, vas al super a comprar o vas a jugar al baloncesto.
    En todas eres una persona pero dependiendo de cual eres un trabajador, o un cliente o un jugador. Te comportas distinto dependiendo
    de donde te encuentres.
*/



class Figura{

    public void dibujar(){
        System.out.println("Dibujando una figura");
    }
}

class Cuadrado extends Figura{

    @Override
    public void dibujar(){
        System.out.println("Dibujando un cuadrado");
    }
}

class Circulo extends Figura{

    @Override
    public void dibujar(){
        System.out.println("Dibujando un circulo");
    }
}

public class Polimorfismo {
    public static void main(String[] args) {

        Cuadrado cuadrado = new Cuadrado();
        Circulo circulo = new Circulo();

        cuadrado.dibujar();
        circulo.dibujar();
    }
}
