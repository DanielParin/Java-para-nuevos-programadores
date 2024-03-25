package org.example.threads.Create.way2;

public class Main {

    public static void main(String[] args) {

        Runnable tarea= new CustomRunnable();
        Thread hilo = new Thread(tarea);
        hilo.start();

        //Este sería el hilo main
        System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());
    }

    //Opción dos por implementación de Runnable

    public static class CustomRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());
        }
    }
}
