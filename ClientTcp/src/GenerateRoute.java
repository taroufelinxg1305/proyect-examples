import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GenerateRoute {

	private ArrayList<String> parescoord = new ArrayList<String>();

	public void cargarCoordRoute() {
		String str = "";
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(new File("ruta1.txt")); // cargo el
																// archivo
																// de texto
			while (input.hasNextLine()) { // mientras halla una linea mas
				str = input.nextLine(); // Cargo la siguiente linea
				StringTokenizer st = new StringTokenizer(str);
				while (st.hasMoreTokens()) {
					parescoord.add(st.nextToken()); // y se guarda en la
													// colecion
				}
			}
		} catch (FileNotFoundException f) {
			System.out.println("no cargo el archivo nmea");
		}
	}

	public void generateNemea() {
		cargarCoordRoute();
		System.out.println(parescoord.size());
		for (String s : parescoord) {
			StringTokenizer st = new StringTokenizer(s, ",");
			while (st.hasMoreTokens()) {
				String lon = st.nextToken();
				String lat = st.nextToken();
				String alt = st.nextToken();
				char ns, ew;
				if (lat.substring(0, 1).equals("-")) {
					ns = 'S';
					lat = lat.substring(1);
				} else
					ns = 'N';
				if (lon.substring(0, 1).equals("-")) {
					ew = 'W';
					lon = lon.substring(1);
				} else
					ew = 'E';
				String newLine = "$GPGGA,185523.538," + lat + "," + ns + "," + lon + "," + ew + ",0,00,,,M,,M,,*55";
				System.out.println(newLine);
				guardar(newLine);
			}
		}
	}

	public static void guardar(String linea) {
		String filename = ""; // String que contiene la ruta del archivo usado
								// en el metodo guardar
		filename = "nmea-sample.txt";
		try {
			File file = new File(filename);
			// si no existe el archivo
			if (!file.exists()) {
				file.createNewFile();
			}
			// fw y bw son elementos para escritura de archivos
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(linea); // guardo el string
			bw.newLine(); // creo un salto de linea en el archivo
			bw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}
