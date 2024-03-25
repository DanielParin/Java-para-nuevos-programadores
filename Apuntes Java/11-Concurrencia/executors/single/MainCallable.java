package org.example.executors.single;

import java.util.concurrent.*;

public class MainCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();


        //Usaremos callable cuando queramos obtener el resultado de una tarea con hilos.
        Callable<Integer> task = () -> 50 + 50;

        Callable<Integer> longTask = () ->{
            Thread.sleep(4000);//Asi vemos como de verdad se bloquea el hilo, si superara el tiempo de espera saltaría un TimeoutException.
            return 30+60; //Siempre return ya que devuelve algo.
        };

        executor.submit(task); //Esto devuelve un Future, por lo que podemos guardar el resultado.
        Future<Integer> future = executor.submit(task);

        //Si la tarea es muy grande podemos usar el get para dar un máximo de tiempo para cogerlo y si no cancelar el get.
        Integer result = future.get(30, TimeUnit.SECONDS);
        //El get bloquea el hilo principal, porque se espera un resultado.

        System.out.println("El resultado es:"+ result);


        executor.submit(longTask);
        Future<Integer> future2 = executor.submit(longTask);
        Integer result2 = future2.get(30,TimeUnit.SECONDS);
        System.out.println("El resultado2 es: "+ result2);


        executor.shutdown();

    }
}
