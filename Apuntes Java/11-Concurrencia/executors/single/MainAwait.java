package org.example.executors.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainAwait {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tarea hecha!");
        };

        try {
            executor.execute(task);
            executor.execute(task);
            executor.execute(task);
        }finally {
            executor.shutdown();//Para que no cerremos el executor antes de tiempo.
        }

        //Supongamos que en el hilo principal hay un código que es necesario ejecutar despues de las task, pues usamos awaitTermination()
        executor.awaitTermination(10, TimeUnit.SECONDS);//Si lo quitamos podría ejecutarse antes.
        System.out.println("Fin del programa");

    }
}
