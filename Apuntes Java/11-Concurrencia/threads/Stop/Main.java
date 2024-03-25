package org.example.threads.Stop;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new Thread(() -> {
            for (int i=0;i<5;i++){
                System.out.println("Iteration: "+i);

                try{
                    //Como puede lanzar una excepción lo metemos en un try catch
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                    //Si en algún momento lo interrumpen hace esto, en vez de lanzar excepción.
                    System.out.println("El hilo: "+ Thread.currentThread().getName()+" , ha sido interrumpido.");
                    return;//Para salir del bucle for.

                }
                /*Nos podemos evitar el try-catch de esta forma:
                    if(Thread.interrupted()){
                    System.out.println("El hilo: "+ Thread.currentThread().getName()+" , ha sido interrumpido.");
                    return;
                    }
                 */

            }
        });
        hilo.start();

        //El bloque de arriba tarda 10 segundos en ejecutarse completo, y vamos a suponer que en el segundo 5 es esencial que el hilo pare

        //Para evitarnos el try-catch ponemos que la clase puede soltar una InterruptedException
        Thread.sleep(5000);

        if (hilo.isAlive()){
            hilo.interrupt();
        }
    }
}
