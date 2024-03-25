package org.example.threads.Async;

public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread(()-> System.out.println("Thread1"));
        Thread thread2 = new Thread(()-> System.out.println("Thread2"));
        Thread thread3 = new Thread(()-> System.out.println("Thread3"));

        /*

        //Asíncrono: Se ejecutan aparte del hilo principal

        System.out.println("Inicio");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Fin");

         */

        //Síncrono: El hilo principal queda bloqueado hasta que terminen los hilos.
        System.out.println("Inicio");
        thread1.run();
        thread2.run();
        thread3.run();
        System.out.println("Fin");

    }
}
