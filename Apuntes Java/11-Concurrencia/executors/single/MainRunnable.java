package org.example.executors.single;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRunnable {

    public static void main(String[] args) {

        Runnable printHello = () -> System.out.println("Hola Runnable.");

        Runnable printHellos = () -> {
            for (int i=0;i<3;i++){
                System.out.println("Hola Runnable "+ i);
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("Empieza:");
        executor.execute(printHello);
        executor.execute(printHellos);
        System.out.println("Fin");
        executor.shutdown();
        System.out.println(executor.isShutdown());
    }
}
