package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SampleClient implements Runnable {
	
	
	private Socket clientSocket;
	private PrintWriter out;
	
	public SampleClient() throws UnknownHostException, IOException {
		// Abre el cliente y se conecta al servidor en el purto 9090
		clientSocket = new Socket("localhost", 9091);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		 
	}
	
    @Override
	public void run() {
    	/* Enviamos un mensaje con el formato usado por NMEA
    	 * Aqui podemos jugar para emular los mensajes enviados al servidor
    	 */
    	
		out.println("$GPGGA,181908.00,3404.7041778,N,07044.3966270,W,4,13,1.00,495.144,M,29.200,M,0.10,0000*40");	
		    	
	}




	public static void main(String[] args) throws IOException {
		// Crea el scheduler
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		// Programa la ejecución cada 2 segundos del hilo (servicio). La ejecuión empieza a los 5 segundos
		executor.scheduleAtFixedRate(new SampleClient(), 5, 2, TimeUnit.SECONDS);
    }

}
