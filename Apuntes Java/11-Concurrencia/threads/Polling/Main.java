package org.example.threads.Polling;


import java.util.List;

public class Main {

    static List<String> messages = List.of("mensaje1","mensaje2","mensaje3","mensaje4","mensaje5");
    static long patience = 10000;//Probar con 50000

    public static void main(String[] args) throws InterruptedException {

        //Cambiamos el nombre del hilo main.
        Thread.currentThread().setName("Hilo1");

        long startTime = System.currentTimeMillis();

        Thread thread= new Thread(() ->{
            Thread.currentThread().setName("Hilo2");
            print("Iniciando tareas");

                try {

                    for (String msg: messages) {
                        Thread.sleep(4000);
                        print(msg);
                    }
                    print("Fin de las tareas");
                } catch (InterruptedException e) {
                    print("Hilo interrumpido");
                }
        });
        thread.start();

        while (thread.isAlive()){
            print("Continuo esperando");
            thread.join(1000);
            long endTime = System.currentTimeMillis();
            long processTime = endTime -startTime;

            if (processTime > patience && thread.isAlive()){
                print("No espero mas!");
                thread.interrupt();
                thread.join();

            }
        }

        print("Fin");
    }

    static void print(String message){
        String threadName = Thread.currentThread().getName();

        System.out.format("%s: %s%n",threadName,message);

    }
}
