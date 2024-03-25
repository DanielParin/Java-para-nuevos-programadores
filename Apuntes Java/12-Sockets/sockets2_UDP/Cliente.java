package sockets2_UDP;

import java.io.IOException;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {

        final  int PORT_SERVER = 5000;//Donde se envía
        byte[] buffer=new byte[1024];//Para almacenar los paquetes


        try {
            //Aquí obtenemos la localización del localhost
            InetAddress direccion = InetAddress.getByName("localhost");


            System.out.println("Iniciando el servidor UDP");
            DatagramSocket socket = new DatagramSocket();


            String mensaje = "Hola mundo desde el cliente";
            buffer = mensaje.getBytes();//Pasamos el mensaje a bytes para que pueda ser mandado como paquete


            DatagramPacket mensajeEnvio = new DatagramPacket(buffer, buffer.length,direccion,PORT_SERVER);
            socket.send(mensajeEnvio);//Enviamos paquete al servidor

            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length); //Preparamos el paquete de respuesta
            socket.receive(peticion);//Recibimos la respuesta

            mensaje = new String(peticion.getData());//Pasamos el array de Bytes a String

            System.out.println(mensaje);

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
