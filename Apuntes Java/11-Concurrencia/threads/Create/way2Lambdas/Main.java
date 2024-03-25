package org.example.threads.Create.way2Lambdas;

public class Main {

    public static void main(String[] args) {

        //Forma de hacerlo con Thread y una expresión lambda
        Thread hilo3 = new Thread(() -> System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState()));
        hilo3.start();

        new Thread(() -> System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState())).start();


        //Este sería el hilo main
        System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());

    }
}
