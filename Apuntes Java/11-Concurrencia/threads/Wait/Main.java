package org.example.threads.Wait;

public class Main {
    public static void main(String[] args){

        Thread hilo = new Thread(() -> {
            for (int i=0;i<5;i++){
                System.out.println("Iteration: "+i);

                try{
                    //Como puede lanzar una excepción lo metemos en un try-catch
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        });
        hilo.start();

        /*Vemos que esto no espera a que termine el hilo creado
        System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());
         */

        //Como puede soltar excepción lo metemos en un try-catch

        try {
            hilo.join(); //Espera a que muera/termine el hilo para seguir ejecutando código.
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        //Y ahora nos imprimirá el hilo main al final
        System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());
    }
}
