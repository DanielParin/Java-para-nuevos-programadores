package org.example.executors.mutiple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRunnable {

    public static void main(String[] args) {

        Runnable task =  () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hola multi hilo.");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        };


        //Ahora el executor lo vamos a hacer con una cantidad de hilos.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //Ahora es capaz de asignar una tarea a cada hilo por lo que sería más rápido.
        //Aparte sabemos que cada hilo ejecuta una tarea porque al pasar 2 segundos se imprimen los 3 mensajes.
        System.out.println("Empieza");
        executor.execute(task);
        executor.execute(task);
        executor.execute(task);
        System.out.println("Fin");

        executor.shutdown();
    }
}
