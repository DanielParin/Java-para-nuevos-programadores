package sockets1_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket server;//Este es el socket del servidor.
        Socket sc; //Este es el socket del cliente.
        final int PORT = 5000;// Puerto por el que nos vamos a conectar.

        DataInputStream in;
        DataOutputStream out;


        try {
            //Creamos el socket del servidor
            server = new ServerSocket(PORT);
            System.out.println("Servidor Iniciado");


            //Ponemos un bucle infinito para que siempre esté escuchando peticiones el servidor.
            while (true){


                sc = server.accept(); //Se queda a la espera de una petición, es decir, esperamos a que el cliente se conecte.
                System.out.println("Cliente conectado");


                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                // in y out se usarán para comunicarse con el cliente


                String messaje = in.readUTF();//Leemos que nos manda el cliente
                System.out.println(messaje);

                out.writeUTF("Hola desde el servidor!!");//Mandamos mensaje al cliente

                sc.close();//Cerramos el cliente
                System.out.println("Cliente desconectado");



            }//El servidor se quedará esperando que se conecte otro cliente.


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
