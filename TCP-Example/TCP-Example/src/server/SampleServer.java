package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class SampleServer {

    public static void main(String[] args) throws IOException {
    	// Define que el socket escuchara en el puerto 9090
        ServerSocket listener = new ServerSocket(9091);
        
        try {
            while (true) {
            	// Abre el socket y acepta las conexiones
                Socket socket = listener.accept();
                System.out.print("Server has connected!\n");

                try {
                	
                	BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                	
                    while (true) {
                    	// Lee la linea de texto que llega del cliente
                        String input = in.readLine();                        
                        if (input == null || input.equals(".")) {
                            break;
                        }
                        // Hace el tratamiento al texto recibido, en este caso imprimir en la consola
                        
                        //System.out.println(input);
                     NmeatoJson.SepararToken(input);
                    }
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
        
    }


}
