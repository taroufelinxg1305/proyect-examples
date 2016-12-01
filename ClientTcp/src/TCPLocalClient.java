
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TCPLocalClient implements Runnable {

	private Socket clientSocket; // socket usado para la conexion con el
									// servidor
	private PrintWriter out;
	private int nextlinenumber = 0; // entero usado para recorrer la colecion de
									// lineas
	private ArrayList<String> allLines; // colecion que almacena todas las
										// lineas GGA nmea de un archivo
										// predispuesto
	private  static GenerateRoute groute;

	public TCPLocalClient() throws UnknownHostException, IOException {
		// Abre el cliente y se conecta al servidor en el puerto 9091
		clientSocket = new Socket("localhost", 9091);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		// carga cada linea de un archivo que contiene GGA nmea en una entrada
		// de la colecion allLines
		allLines= cargarArchivo();
		
	}

	@Override
	public void run() {
		/*
		 * Enviamos un mensaje con el formato usado por NMEA Aqui podemos jugar
		 * para emular los mensajes enviados al servidor
		 */

		// out.println("$GPGGA,181908.00,3404.7041778,N,07044.3966270,W,4,13,1.00,495.144,M,29.200,M,0.10,0000*40");
		//String sensor = "$GPGGA,000106.00,7.090184,N,73.108926,E,0,,,-18.0,M,18.0,M,,*59\n$GPRMC,000106.00,V,0000.0000,N,00000.0000,E,00.00,000.0,,,,N*41\n$GPGSV,1,1,00*79\n$GLGSV,1,1,00*65\n$GPGSA,A,1,,,,,,,,,,,,,,,*1E\n$PORZD,V,999.9*2B";
		out.println(allLines.get(nextlinenumber)); // imprime y envia al
													// servidor la linea GGA
													// correspondiente al indice
													// nextlinenumber
		nextlinenumber++;

	}

	public static void main(String[] args) throws IOException {
		//groute = new GenerateRoute();
		//groute.generateNemea();
		
		// Crea el scheduler
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		// Programa la ejecución cada 2 segundos del hilo (servicio). La
		// ejecuión empieza a los 5 segundos
		executor.scheduleAtFixedRate(new TCPLocalClient(), 0, 2, TimeUnit.SECONDS);
	}

	/*
	 * Metodo que tomo un archivo de texto con unas lineas de contenido GGA
	 * nmea, lo carga y lo almacena en una coleccion
	 */
	private ArrayList<String> cargarArchivo()

	{
		ArrayList<String> list = new ArrayList<String>(); // colecion de strings
															// para almacenar
															// las lineas
		String str = ""; // string que almacena temporalmente cada linea del
							// archivo de texto

		try {
			Scanner input = new Scanner(new File("nmea-sample.txt")); // cargo el
																	// archivo
																	// de texto
			while (input.hasNextLine()) { // mientras halla una linea mas
				str = input.nextLine(); // Cargo la siguiente linea
				list.add(str); // y se guarda en la colecion
			}
		} catch (FileNotFoundException f) {
			System.out.println("no cargo el archivo nmea"); // si no encuentra
															// el archivo
															// "nmea-sample.txt"
		}
		System.out.println("el archivo tiene " + list.size() + " lineas"); // informa
																			// el
																			// numero
																			// de
																			// lineas
																			// del
																			// archivo
		return list; // retorna la colecion
	}

}
