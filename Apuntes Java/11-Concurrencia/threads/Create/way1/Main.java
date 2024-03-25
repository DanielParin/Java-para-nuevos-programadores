package org.example.threads.Create.way1;

public class Main {
    public static void main(String[] args) {

        Thread hilo = new CustomThread();
        hilo.start();

        //Este sería el hilo main
        System.out.println("Thread: "+ Thread.currentThread().getName() + " State:"+ Thread.currentThread().getState());
    }

    //Opción uno por herencia de thread
    public static class  CustomThread extends Thread{

        @Override
        public void run() {
            System.out.println("Thread: "+ this.getName() + " State:"+ this.getState());
        }
    }
}
