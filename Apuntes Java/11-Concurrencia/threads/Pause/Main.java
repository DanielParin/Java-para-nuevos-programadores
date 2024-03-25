package org.example.threads.Pause;

public class Main {
    public static void main(String[] args) {

        Thread hilo = new Thread(() -> {
            for (int i=0;i<5;i++){
                System.out.println("Iteracion: "+i);

                try{
                    //Como puede lanzar una excepción lo metemos en un try catch
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        });

        hilo.start();
    }
}
