package org.example.executors.single;

import java.util.concurrent.*;

public class MainScheduled {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> hello = () -> "Hello!" ;
        Callable<String> bye = () -> "Bye!" ;
        Runnable finisih = () -> System.out.println("End");


        var executor = Executors.newSingleThreadScheduledExecutor();
        //Esto nos va a permitir "programar" cuando se ejecutan las tareas.

        ScheduledFuture<String> future1 = executor.schedule(hello,5, TimeUnit.SECONDS);
        // En este caso, después de 5 seundos realiza la tarea hello.

        System.out.println(future1.get());//Esto bloquea el hilo principal, recordemos.

        ScheduledFuture<String> future2 = executor.schedule(bye,5, TimeUnit.SECONDS);
        System.out.println(future2.get());


        executor.scheduleWithFixedDelay(finisih,5,5,TimeUnit.SECONDS);
        //Esto ejecutará por primera vez, al pasar en este caso 5segundos, cada 5 la tarea finish (todo el rato)

        Thread.sleep(15000);
        /*
        Al no haber get ek hilo principal no se bloquea, asi lo paramos 15 segundos y se nos debería ejecutar finish 2 veces.
        Ya que 5 segundos que tarda en ejecutarse la primera vez más los otros 5 que tarda en ejecutar la siguiente hacen 15
        por lo que el hilo principal ejecutaría el shutdown.
         */

        executor.shutdown();


    }
}
