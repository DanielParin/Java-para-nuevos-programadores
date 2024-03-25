package sockets1_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        final String HOST = "127.0.0.1";//A quien nos vamos a conectar, es decir, el host es el servidor.
        final int PORT = 5000;//Mismo puerto que el servidor al ser TCP.
        DataOutputStream out;
        DataInputStream in;




        try {
            //Se crea el socket para poder conectarnos al servidor.
            Socket sc = new Socket(HOST,PORT);


            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());


            out.writeUTF("Hola desde el cliente");//Manda este mensaje al servidor

            String message = in.readUTF();//Recibimos el mensaje del servidor
            System.out.println(message);

            sc.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
