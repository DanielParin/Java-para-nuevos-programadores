package sockets2_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) {

        final int PORT = 5000;
        byte[] buffer = new byte[1024];



        try {
            System.out.println("Iniciando servidor UDP");
            try (DatagramSocket socketUDP = new DatagramSocket(PORT)) {

                while (true) {


                /*
                    Es el socket
                 */
                    DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                    //Voy a crear un paquete que contiene este buffer con esta longitud (puedes meter información hasta este límite)

                    socketUDP.receive(peticion);
                    //Cuando el usuario se conecte con nosotros, recibiremos algo del cliente.

                    String message = new String(peticion.getData()/*,peticion.getOffset(),peticion.getLength()*/);
                    System.out.println(message);

                    int clientPort = peticion.getPort();
                    InetAddress direccion = peticion.getAddress();


                    message = "Hola desde el servidor";
                    buffer = message.getBytes();//Hace de una cadena un array de bytes para el buffer.


                    DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, clientPort);//Pasamos esta información a esta direccion con este puerto
                    socketUDP.send(respuesta);//Enviamos el paquete
                }
            }catch (SocketException ex){
                throw  new RuntimeException(ex);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
